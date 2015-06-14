package com.example.tests;

import com.example.fw.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactCreation extends TestBase{

    @Test
    public void createContactWithValidData () {
        Contact contact = new Contact().setFirstName("tester").setLastName("tester");
        app.getContactHelper().createContact(contact);
        Contact createdContact = app.getContactHelper().getFirstContact();
        Assert.assertEquals(contact, createdContact);
    }
}
