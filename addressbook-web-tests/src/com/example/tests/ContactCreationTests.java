package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old ContactsList
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        app.getContactHelper().createContact(contact);

        //save new ContactsList
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        //sinse contact.firstname and contact.lastname fields can be generated as null, they will be got in getContacts() as ""
        if (contact.getFirstname() == null){contact.withFirstname("");}
        if (contact.getLastname()== null){contact.withLastname("");}
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }
}
