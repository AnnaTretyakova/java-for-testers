package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()){
            click(By.linkText("home"));
        }
    }

    public void homePage() {
        if (! onMainPage()){
            click(By.linkText("home page"));
        }
    }

    public void groupsPage() {
        if (! onGroupsPage()) {
            click(By.linkText("groups"));
        }
    }

    public void groupPage() {
        if (! onGroupsPage()){
            click(By.linkText("group page"));
        }
    }

    public void printPhones() {
        if(! onPrintPhones()) {
            click(By.linkText("print phones"));
        }
    }

    private boolean onPrintPhones() {
        return (driver.findElements(By.id("view")).size()>0 && driver.getCurrentUrl().contains("all&print&phones"));
    }

    private boolean onGroupsPage() {
        if(driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size()>0){
            return true;
        }else{return false;}
    }

    private boolean onMainPage() {
        return (driver.findElements(By.id("maintable")).size()>0);
    }
}
