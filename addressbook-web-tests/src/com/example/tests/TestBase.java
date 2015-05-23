package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
        }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator(){
        return wrapGroupsFromDataProvider(generateRandomGroups(2, true)).iterator();
    }

    public static List<Object[]> wrapGroupsFromDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group: groups){
            list.add(new Object[]{group});
        }
        return list;
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        return wrapContactsFromDataProvider(generateRandomContacts(2, true)).iterator();
    }

    private List<Object[]> wrapContactsFromDataProvider(List<ContactData> contactsData) {
        List<Object[]> list = new ArrayList<Object[]>();
        for(ContactData contact: contactsData){
            list.add(new Object[]{contact});
        }
        return list;
    }

    @DataProvider
    public Iterator<Object[]> randomIndex(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i=0; i<10; i++){
            Random rnd = new Random();
            int index = rnd.nextInt(10);
            list.add(new Object[]{index});
        }
        return list.iterator();
    }
}
