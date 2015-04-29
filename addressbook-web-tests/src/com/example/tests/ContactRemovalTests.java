package com.example.tests;

import com.example.fw.ContactHelper;
import org.testng.annotations.Test;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactRemovalTests extends TestBase{

    @Test
    public void deleteSomeContact() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().deleteContact(1);
        app.getNavigationHelper().returnToHomePage();
    }
}
