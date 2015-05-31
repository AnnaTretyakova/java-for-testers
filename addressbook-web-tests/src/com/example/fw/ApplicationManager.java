package com.example.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {

    public WebDriver driver;
    public String baseUrl;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private PhoneHelper phoneHelper;
    private Properties properties;

    public ApplicationManager(Properties properties){
        this.properties = properties;
        String browser = properties.getProperty("browser");
        if("firefox".equals(browser)){
            driver = new FirefoxDriver();
        }else if("chrome".equals(browser)){
            driver = new ChromeDriver();
        }else if("ie".equals(browser)){
            driver = new InternetExplorerDriver();
        }
        else{
            throw new Error("Unsupported browser:" + browser);
        }
        baseUrl = properties.getProperty("baseUrl");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public void stop() {
        driver.quit();
     }

    public NavigationHelper navigateTo(){
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

    public PhoneHelper getPhoneHelper() {
        if (phoneHelper == null) {
            phoneHelper = new PhoneHelper(this);
        }
        return phoneHelper;
    }
    }
