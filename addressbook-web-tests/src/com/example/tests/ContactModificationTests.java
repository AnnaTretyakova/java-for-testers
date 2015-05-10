package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactModificationTests extends TestBase {

    @Test public void modifySomeContacts(){

            app.getNavigationHelper().openMainPage();

            //save old ContactsList
            List<ContactData> oldList = app.getContactHelper().getContacts();

            //action
            app.getContactHelper().initContactModification(0);
            ContactData contact = new ContactData();
            contact.firstname = "new name";
            contact.byear = "2000";
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().submitContactModification();
            app.getNavigationHelper().returnToHomePage();

            //save new ContactsList
            List<ContactData> newList = app.getContactHelper().getContacts();

            //compare old and new ContactLists
            //I have changed only firstname and byear, but I compare by firstname, lastname, email, homeFhoneNumber
            //that's why I should save them to contact before sort and assert
            contact.lastname = oldList.get(0).lastname;
            contact.email = oldList.get(0).email;
            contact.homePhoneNumber = oldList.get(0).homePhoneNumber;
            oldList.remove(0);
            oldList.add(contact);
            Collections.sort(oldList);
            Collections.sort(newList);
            assertEquals(oldList, newList);
    }
}