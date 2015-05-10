package com.example.tests;

import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        app.getGroupHelper().initGroupModification(index);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnToGroupPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        //sinse type method in fillGroupForm does't change field if value is null I should save group.name from OldList before remove, sort, assert
        if (group.name == null){
            group.name = oldList.get(index).name;
        }
        oldList.remove(index);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
