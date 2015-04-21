package com.example.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        openMainPage();
        initContactCreation();

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

        fillContactForm(contactData);
        submitContactCreation();
        returnToHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        openMainPage();
        initContactCreation();

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

        fillContactForm(contactData);
        submitContactCreation();
        returnToHomePage();
    }

}

