package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupRemovalTests extends TestBase {

    //@Test (dataProvider = "randomIndex")
    //public void deleteSomeGroup(int index){
    @Test
    public void deleteSomeGroup(){
        //save old state
        //SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);
        app.getGroupHelper().delete(index);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
