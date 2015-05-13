package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class ContactModificationTests extends TestBase {

    @Test (dataProvider = "randomValidContactGenerator")
    public void modifySomeContacts(ContactData contact){
            app.getNavigationHelper().openMainPage();

            //save old ContactsList
            List<ContactData> oldList = app.getContactHelper().getContacts();

            //action
            Random rnd = new Random();
            int index = rnd.nextInt(oldList.size()-1);
            app.getContactHelper().initContactModification(index);
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().submitContactModification();
            app.getNavigationHelper().returnToHomePage();

            //save new ContactsList
            List<ContactData> newList = app.getContactHelper().getContacts();

            //compare old and new ContactLists
            //sinse type method in fillGroupForm does't change field if value is null
            // I should save contact.firstname and contact.lastname from OldList before remove, sort, assert
            if (contact.getFirstname() == null){contact.withFirstname(oldList.get(index).getFirstname());}
            if (contact.getLastname() == null){contact.withLastname(oldList.get(index).getLastname());}
            oldList.remove(index);
            oldList.add(contact);
            Collections.sort(oldList);
            Collections.sort(newList);
            assertEquals(oldList, newList);
    }
}