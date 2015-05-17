package com.example.tests;

import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group){
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        app.getGroupHelper().modifyGroup(index,group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        //sinse type method in fillGroupForm does't change field if value is null I should save group.name from OldList before remove, sort, assert
        if (group.getName() == null){
            group.withName(oldList.get(index).getName());
        }
        oldList.remove(index);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
