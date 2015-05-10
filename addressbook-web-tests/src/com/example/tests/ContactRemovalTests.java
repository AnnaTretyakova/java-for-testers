package com.example.tests;

import com.example.fw.ContactHelper;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactRemovalTests extends TestBase{

    //@Test (dataProvider = "randomIndex")
    //public void deleteSomeContact(int index) throws Exception {
    @Test
    public void deleteSomeContact() throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old ContactsList
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //action
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        app.getContactHelper().deleteContact(index);
        app.getNavigationHelper().returnToHomePage();

        //save new ContactsList
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        oldList.remove(index);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);
    }
}
