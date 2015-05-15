package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by 801646 on 27.04.2015.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void groupsPage() {
        click(By.linkText("groups"));
    }

    public void groupPage() {
        click(By.linkText("group page"));
    }

    public void homePage() {
        click(By.linkText("home page"));
    }
}
