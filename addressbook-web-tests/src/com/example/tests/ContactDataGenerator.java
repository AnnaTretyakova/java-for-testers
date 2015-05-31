package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.example.tests.GroupDataGenerator.generateRandomString;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists()){
            System.out.println("File already exists, please remove it manually: " + file);
        }

        List<ContactData> contacts = generateRandomContacts(amount, false);

        if ("csv".equals(format)) {
            saveContactsToCsvFile(contacts, file);
        } else if ("xml".equals(format)) {
            saveContactsToXmlFile(contacts, file);
        } else {
            System.out.println("Unknown format" + format);
            return;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Generate RandomData

    public static List<ContactData> generateRandomContacts(int amount, boolean useNull) {
        List<ContactData> list = new ArrayList<ContactData>();
        for (int i=0; i<amount; i++) {
            Random rnd = new Random();
            ContactData contactData = new ContactData()
                    .withFirstname(generateRandomString(useNull))
                    .withLastname(generateRandomString(useNull))
                    .withAddress(generateRandomString(useNull))
                    .withHomePhoneNumber(String.valueOf(rnd.nextInt()))//it seems that when phone numbers are null or "" then program generate random number for this field
                    .withMobilePhoneNumber(String.valueOf(rnd.nextInt()))
                    .withWorkPhoneNumber(String.valueOf(rnd.nextInt()))
                    .withEmail("test" + rnd.nextInt()) //it seems that when email is null or "" then program generate random not null value for this field
                    .withEmail2("test" + rnd.nextInt())
                    .withBday(generateRandomBday())
                    .withBmonth(generateRandomBmonth())
                    .withByear(generateRandomByear(useNull))
                    .withAddress2(generateRandomString(useNull))
                    .withHomePhoneNumber2(String.valueOf(rnd.nextInt()));
            list.add(contactData);
        }
        return list;
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

    public static String generateRandomBday(){
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "-";
        } else {
            return String.valueOf(rnd.nextInt(30)+1);
        }
    }

    public static String generateRandomBmonth(){
        Random rnd = new Random();
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "-";
        } else {
            return months[rnd.nextInt(12)];
        }
    }

    public static String generateRandomByear(boolean useNull){
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "";
        } else if (rndValue == 1 && useNull == true ) {
            return null;
        } else {
            return String.valueOf(1900 + rnd.nextInt(115));
        }
    }

    //LoadDataFromFile

    public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<ContactData> contacts = new ArrayList<ContactData>();
        String line = bufferedReader.readLine();
        while (line!=null){
            String[]fields = line.split(",");
            ContactData contact = new ContactData()
                    .withFirstname(fields[0])
                    .withLastname(fields[1])
                    .withAddress(fields[2])
                    .withHomePhoneNumber(fields[3])
                    .withMobilePhoneNumber(fields[4])
                    .withWorkPhoneNumber(fields[5])
                    .withEmail(fields[6])
                    .withEmail2(fields[7])
                    .withBday(fields[8])
                    .withBmonth(fields[9])
                    .withByear(fields[10])
                    .withAddress2(fields[11])
                    .withHomePhoneNumber2(fields[12]);
            contacts.add(contact);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return contacts;
    }

    //Save methods

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        String xml = xstream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact: contacts){
            writer.write(contact.getFirstname()+","+contact.getLastname()+","+contact.getAddress()+",");
            writer.write(contact.getHomePhoneNumber()+","+contact.getMobilePhoneNumber()+","+contact.getWorkPhoneNumber()+",");
            writer.write(contact.getEmail()+","+contact.getEmail2()+",");
            writer.write(contact.getBday()+","+contact.getBmonth()+","+contact.getByear()+",");
            writer.write(contact.getAddress2()+","+contact.getHomePhoneNumber2()+","+"!"+"\n");
            }
         writer.close();
    }
}
