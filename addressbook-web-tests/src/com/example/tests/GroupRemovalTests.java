package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by 801646 on 29.04.2015.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().delete(1);
        app.getNavigationHelper().returnToGroupPage();
    }
}
