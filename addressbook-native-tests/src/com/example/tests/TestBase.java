package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;


public class TestBase {

    protected static ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        app = ApplicationManager.getInstance(properties);
        }

    @AfterTest
    public void tearDown() throws Exception {
        ApplicationManager.getInstance(null).stop();
    }
 }
