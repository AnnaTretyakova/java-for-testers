package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ContactModificationTests extends TestBase {

    @Test (dataProvider = "randomValidContactGenerator")
    public void modifySomeContacts(ContactData contact){
        //save old ContactsList
        //SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

        //action
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        ContactData contactFromModificationForm = app.getContactHelper().modifyContact(index, contact);
        assertThat(contactFromModificationForm, equalTo(oldList.get(index)));

        //save new ContactsList
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        //sinse type method in fillGroupForm does't change field if value is null
        // I should save contact.firstname and contact.lastname from OldList before remove, sort, assert
        if (contact.getFirstname() == null){contact.withFirstname(oldList.get(index).getFirstname());}
        if (contact.getLastname() == null){contact.withLastname(oldList.get(index).getLastname());}
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }
}