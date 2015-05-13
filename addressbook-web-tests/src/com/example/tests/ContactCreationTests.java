package com.example.tests;

import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old ContactsList
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        app.getContactHelper().initContactCreation();

        app.getContactHelper()
                .fillContactForm(contact)
                .submitContactCreation();
        app.getNavigationHelper().returnToHomePage();

        //save new ContactsList
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        //sinse contact.firstname and contact.lastname fields can be generated as null, they will be got in getContacts() as ""
        if (contact.getFirstname() == null){contact.withFirstname("");}
        if (contact.getLastname()== null){contact.withLastname("");}
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }
}
