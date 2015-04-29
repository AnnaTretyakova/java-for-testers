package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;

/**
 * Created by 801646 on 27.04.2015.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name);
        type(By.name("group_header"), groupData.header);
        type(By.name("group_footer"), groupData.footer);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void delete(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }
}
