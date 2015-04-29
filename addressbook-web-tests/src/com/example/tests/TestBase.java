package com.example.tests;

import com.example.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by 801646 on 21.04.2015.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
        }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

}
