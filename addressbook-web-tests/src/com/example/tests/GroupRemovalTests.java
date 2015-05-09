package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by 801646 on 29.04.2015.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().delete(0);
        app.getNavigationHelper().returnToGroupPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
