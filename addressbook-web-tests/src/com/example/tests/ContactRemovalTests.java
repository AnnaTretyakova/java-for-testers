package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactRemovalTests extends TestBase{

    //@Test (dataProvider = "randomIndex")
    //public void deleteSomeContact(int index) throws Exception {
    @Test
    public void deleteSomeContact() throws Exception {
        app.navigateTo().mainPage();

        //save old ContactsList
        //SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

        //action
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        app.getContactHelper().deleteContact(index);

        //save new ContactsList
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
