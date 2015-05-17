package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);
        app.getGroupHelper().modifyGroup(index,group);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        //sinse type method in fillGroupForm does't change field if value is null I should save group.name from OldList before remove, sort, assert
        if (group.getName() == null){
            group.withName(oldList.get(index).getName());
        }
        assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
    }
}
