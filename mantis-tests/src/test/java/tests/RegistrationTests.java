package tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testReRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String email = String.format("user@localhost%s.localdomain", now);
        String user1 = String.format("user%s" , now);
        String password = ("password");
        app.registration().start(user1, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confrimationLink = findConfrimationLink(mailMessages, email);
        app.registration().finish(confrimationLink, password);
        Assert.assertTrue(app.newSession().login(user1, password));

    }

    private String findConfrimationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
