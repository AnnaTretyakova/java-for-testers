package com.example.tests;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class GroupRemovalTests extends TestBase {

    //@Test (dataProvider = "randomIndex")
    //public void deleteSomeGroup(int index){
    @Test
    public void deleteSomeGroup(){
        app.navigateTo().mainPage();
        app.navigateTo().groupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);
        app.getGroupHelper().delete(index);
        app.navigateTo().groupPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
