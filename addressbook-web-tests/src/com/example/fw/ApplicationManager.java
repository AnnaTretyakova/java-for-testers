package com.example.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by 801646 on 26.04.2015.
 */
public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    public ApplicationManager(){
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
     }

    public NavigationHelper getNavigationHelper(){
        if(navigationHelper == null){
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }

    public GroupHelper getGroupHelper() {
        if (groupHelper == null) {
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }
    }