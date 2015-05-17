package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i=0; i<2; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            //group.name = generateRandomString();
            //group.footer = generateRandomString();
            //group.header = generateRandomString();
            list.add(new Object[]{group});
        }
        return list.iterator();
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

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i=0; i<2; i++) {
            Random rnd = new Random();
            ContactData contactData = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHomePhoneNumber(String.valueOf(rnd.nextInt()))//it seems that when phone numbers are null or "" then program generate random number for this field
                    .withMobilePhoneNumber(String.valueOf(rnd.nextInt()))
                    .withWorkPhoneNumber(String.valueOf(rnd.nextInt()))
                    .withEmail("test" + rnd.nextInt()) //it seems that when email is null or "" then program generate random not null value for this field
                    .withEmail2("test" + rnd.nextInt())
                    .withBday(generateRandomBday())
                    .withBmonth(generateRandomBmonth())
                    .withByear(generateRandomByear())
                    .withAddress2(generateRandomString())
                    .withHomePhoneNumber2(String.valueOf(rnd.nextInt()));
                    list.add(new Object[]{contactData});
        }
        return list.iterator();
    }

    private String generateRandomString() {
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "";
        }else if (rndValue == 1){
            return null;
        }else{
            return("test" + rnd.nextInt());
        }
    }

    public String generateRandomNumber(){
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "";
        } else if (rndValue == 1) {
            return null;
        } else {
            return String.valueOf(rnd.nextInt());
        }
    }

   public String generateRandomBday(){
       Random rnd = new Random();
       int rndValue = rnd.nextInt(4);
       if (rndValue == 0){
           return "-";
       } else {
           return String.valueOf(rnd.nextInt(30)+1);
       }
   }

    public String generateRandomBmonth(){
        Random rnd = new Random();
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "-";
        } else {
            return months[rnd.nextInt(12)];
        }
    }

    public String generateRandomByear(){
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "";
        } else if (rndValue == 1) {
            return null;
        } else {
            return String.valueOf(1900 + rnd.nextInt(115));
        }
    }
}
