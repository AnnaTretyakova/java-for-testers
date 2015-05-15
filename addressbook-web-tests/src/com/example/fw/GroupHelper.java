package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper delete(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
        return this;
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkmox: checkboxes){
            GroupData group = new GroupData();
            String title = checkmox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            groups.add(group.withName(name));
        }
        return groups;
    }
}
