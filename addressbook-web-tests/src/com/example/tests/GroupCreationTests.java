package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().createGroup(group);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        //sinse type method in fillGroupForm does't change field if value is null they will be got in getGroups() as ""
        if (group.getName() == null){group.withName("");}
        assertThat(newList, equalTo(oldList.withAdded(group)));
    }
}

