package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrintPhoneTests extends TestBase {

    @Test
    public void testPrintPhonePage()throws Exception {

        SortedListOf<String> contactInfoFromHomePage = app.getContactHelper().getContactsInfo();

        String numberOfContacts = app.getContactHelper().getNumberOfContacts();

        SortedListOf<String> contactInfoFromPrintPhonesPage = app.getPhoneHelper().getContactsInfo();

        assertThat(numberOfContacts, equalTo(String.valueOf(contactInfoFromPrintPhonesPage.size())));
        assertThat(contactInfoFromHomePage, equalTo(contactInfoFromPrintPhonesPage));

    }
}
