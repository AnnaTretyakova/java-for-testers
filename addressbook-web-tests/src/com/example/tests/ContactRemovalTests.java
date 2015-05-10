package com.example.tests;

import com.example.fw.ContactHelper;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactRemovalTests extends TestBase{

    @Test
    public void deleteSomeContact() throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old ContactsList
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        app.getContactHelper().deleteContact(0);
        app.getNavigationHelper().returnToHomePage();

        //save new ContactsList
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        oldList.remove(0);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }
}
