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

    private List<GroupData> cachedGroups;

    public List<GroupData> getGroups() {
        if (cachedGroups == null) {
            rebuildCash();
        }
        return cachedGroups;
    }

    private void rebuildCash() {
        cachedGroups = new ArrayList<GroupData>();
        manager.navigateTo().groupsPage();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkmox: checkboxes){
            GroupData group = new GroupData();
            String title = checkmox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroups.add(group.withName(name));
        }
    }

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        manager.navigateTo().groupPage();
        rebuildCash();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        manager.navigateTo().groupPage();
        rebuildCash();
        return this;
    }

    public GroupHelper delete(int index) {
        manager.navigateTo().groupsPage();
        selectGroupByIndex(index);
        click(By.name("delete"));
        manager.navigateTo().groupPage();
        rebuildCash();
        return this;
    }
    //------------------------------------------------------------------------------------------------------------------

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    public GroupHelper initGroupCreation() {
        manager.navigateTo().groupsPage();
        click(By.name("new"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
        return this;
    }
}
