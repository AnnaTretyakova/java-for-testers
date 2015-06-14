package com.example.tests;

import org.testng.annotations.Test;

public class TestContactRemoval extends TestBase {

    @Test
    public void removeContacts(){
        app.getContactHelper().deleteContacts();
        app.getContactHelper().verifyContactsRemoval();
    }
}
