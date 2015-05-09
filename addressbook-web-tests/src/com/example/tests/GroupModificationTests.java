package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupModification(0);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnToGroupPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
