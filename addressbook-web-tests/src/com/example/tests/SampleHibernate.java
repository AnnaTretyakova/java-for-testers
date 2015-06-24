package com.example.tests;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SampleHibernate {

    public static void main(String args[]) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("application.properties")));
        ApplicationManager app = new ApplicationManager(properties);
        System.out.println(app.getHibernateHelper().listGroups());
        System.out.println(app.getHibernateHelper().listContacts());
    }
    }
