package com.example.tests;

import org.testng.annotations.*;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old ContactsList
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        app.getContactHelper().initContactCreation();

        ContactData contactData = new ContactData();
        contactData.firstname = "Anna";
        contactData.lastname = "Tretyakova";
        contactData.address = "Saint-Petersburg";
        contactData.homePhoneNumber = "8(812)7252525";
        contactData.mobilePhoneNumber = "8(950)7257272";
        contactData.workPhoneNumber = "8(812)725725";
        contactData.email = "anna.tretyakova@gmail.com";
        contactData.email2 = "anna2.tretyakova@gmail.com";
        contactData.bday = "1";
        contactData.bmonth = "January";
        contactData.byear = "1988";
        contactData.address2 = "Moscow";
        contactData.homePhoneNumber2 = "";

        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();

        //save new ContactsList
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        oldList.add(contactData);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old ContactsList
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        app.getContactHelper().initContactCreation();

        ContactData contactData = new ContactData();
        contactData.firstname = "";
        contactData.lastname = "";
        contactData.address = "";
        contactData.homePhoneNumber = "";
        contactData.mobilePhoneNumber = "";
        contactData.workPhoneNumber = "";
        contactData.email = "";
        contactData.email2 = "";
        contactData.bday = "-";
        contactData.bmonth = "-";
        contactData.byear = "";
        contactData.address2 = "";
        contactData.homePhoneNumber2 = "";

        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();

        //save new ContactsList
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        oldList.add(contactData);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }
}

