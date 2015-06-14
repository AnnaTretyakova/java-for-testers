package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

    private static ApplicationManager singleton;
    private Properties properties;
    private ContactHelper contactHelper;
    private ProcessHelper processHelper;
    private AutoItHelper autoItHelper;

    public static ApplicationManager getInstance(Properties properties) throws IOException {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(properties);
            singleton.start();
        }
        return singleton;
    }

    public void start() throws IOException {
        getProcessHelper().startApplicationUnderTest();
    }

    public void stop() {
        getProcessHelper().stopApplicationUnderTest();
     }

    private void setProperties(Properties key) {
        this.properties = key;
    }

    public String getProperty(String property) {
        String value = properties.getProperty(property);
        return value;
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public ProcessHelper getProcessHelper() {
        if (processHelper == null) {
            processHelper = new ProcessHelper(this);
        }
        return processHelper;
    }

    public AutoItHelper getAutoItHelper() {
        if (autoItHelper == null) {
            autoItHelper = new AutoItHelper(this);
        }
        return autoItHelper;
    }
}
