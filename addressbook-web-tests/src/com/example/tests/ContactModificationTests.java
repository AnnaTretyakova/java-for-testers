package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactModificationTests extends TestBase {

    @Test public void modifySomeContacts(){

            app.getNavigationHelper().openMainPage();
            app.getContactHelper().initContactModification(1);
            ContactData contact = new ContactData();
            contact.firstname = "new name";
            contact.byear = "2000";
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().submitContactModification();
            app.getNavigationHelper().returnToHomePage();
    }
}