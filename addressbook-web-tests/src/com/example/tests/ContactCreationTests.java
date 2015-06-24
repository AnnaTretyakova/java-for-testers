package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        return wrapContactsFromDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
    }

    @Test(dataProvider = "contactsFromFile")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old ContactsList
        //SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
        SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

        //action
        app.getContactHelper().createContact(contact);

        //save new ContactsList
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare old and new ContactLists
        //sinse contact.firstname and contact.lastname fields can be generated as null, they will be got in getContacts() as ""
        if (contact.getFirstname() == null){contact.withFirstname("");}
        if (contact.getLastname()== null){contact.withLastname("");}
        assertThat(newList, equalTo(oldList.withAdded(contact)));
        assertThat(newList, equalTo(new SortedListOf<ContactData>(app.getHibernateHelper().listContacts())));
    }
}
