package com.example.tests;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import java.util.*;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().createGroup(group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        //sinse type method in fillGroupForm does't change field if value is null they will be got in getGroups() as ""
        if (group.getName() == null){group.withName("");}
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}

