package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by 801646 on 27.04.2015.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
}
