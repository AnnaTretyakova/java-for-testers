package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator{

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

        List<GroupData> groups = generateRandomGroups(amount,false);

        if ("csv".equals(format)) {
            saveGroupsToCsvFile(groups, file);
        } else if ("xml".equals(format)) {
            saveGroupsToXmlFile(groups, file);
        } else {
            System.out.println("Unknown format" + format);
            return;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Generate RandomData

    public static List<GroupData> generateRandomGroups(int amount, boolean useNull) {
        List<GroupData> list = new ArrayList<GroupData>();
        for (int i=0; i<amount; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString(useNull))
                    .withHeader(generateRandomString(useNull))
                    .withFooter(generateRandomString(useNull));
            list.add(group);
        }
        return list;
    }

    public static String generateRandomString(boolean useNull) {
        Random rnd = new Random();
        int rndValue = rnd.nextInt(4);
        if (rndValue == 0){
            return "";
        }else if (rndValue == 1 && useNull == true ){
            return null;
        }else{
            return("test" + rnd.nextInt());
        }
    }

    //LoadDataFromFile

    public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
        List<GroupData> list = new ArrayList<GroupData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null){
            String[] fields = line.split(",");
            GroupData group = new GroupData()
                    .withName(fields[0])
                    .withHeader(fields[1])
                    .withFooter(fields[2]);
            list.add(group);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }

    public static List<GroupData> loadGroupsFromXMLFile(File file){
        XStream xstream = new XStream();
        xstream.alias("groups", GroupData.class);
        return (List<GroupData>) xstream.fromXML(file);
    }

    //Save methods

    private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("groups", GroupData.class);
        String xml = xstream.toXML(groups);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (GroupData group: groups){
            writer.write(group.getName()+","+group.getHeader()+","+group.getFooter()+ ",!"+"\n");
        }
        writer.close();
    }

}
