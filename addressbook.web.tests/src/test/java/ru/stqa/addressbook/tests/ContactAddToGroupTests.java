package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.model.ContactsData;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests extends TestBase {

//    @BeforeMethod
//    public void ensurePrecondtions() {
//        app.db().groups();
//
//        if (app.db().groups().size() == 0) {
//            app.goTo().groupPage();
//            app.group().create(new GroupData().withName("TestAddContactGroup"));
//
//        } else if (!app.contacts().findGroupForAdd()) {
//            app.goTo().groupPage();
//            app.group().create(new GroupData().withName("TestAddContactGroup"));
//        }
//
//        app.goTo().contactPage();
//        Groups groups = app.db().groups();
//        if (app.db().contacts().size() == 0) {
//            app.contacts().create(new ContactsData().withFirstName("FirstName").withMiddleName("MiddleName").
//                    withLastName("LastName").withNickname("nickname").withTitle("Title").withCompane("company").
//                    withAddress("address").withMobile("111").withHomePhone("222").withEmail("E-mail@E-mail.ru").withWorkPhone("333").
//                    inGroup(groups.iterator().next()));
//        }
//    }

    @Test
    public void addContactToGroupTests() {
        ContactsData contact = new ContactsData();
        int id = contact.getId();
        findContactInGroup(id);
    }

    public ContactsData findContactInGroup(int id) {
        Contacts contacts = app.db().contacts();
        for (ContactsData contact : contacts) {
            if (contact.getId() =)
            System.out.println("!!!!!!!!"+contact.getGroups());
            System.out.println(id+"!!!!!!!");
        } return contact;
    }
}




