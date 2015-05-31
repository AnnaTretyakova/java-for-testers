package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile","application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        app = new ApplicationManager(properties);
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

    public static List<Object[]> wrapContactsFromDataProvider(List<ContactData> contactsData) {
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
