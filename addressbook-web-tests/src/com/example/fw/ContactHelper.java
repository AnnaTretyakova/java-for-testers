package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by 801646 on 27.04.2015.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname);
        type(By.name("lastname"), contactData.lastname);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.homePhoneNumber);
        type(By.name("mobile"), contactData.mobilePhoneNumber);
        type(By.name("work"), contactData.workPhoneNumber);
        type(By.name("email"), contactData.email);
        type(By.name("email2"), contactData.email2);
        selectByText(By.name("bday"), contactData.bday);
        selectByText(By.name("bmonth"), contactData.bmonth);
        type(By.name("byear"), contactData.byear);
        type(By.name("address2"), contactData.address2);
        type(By.name("phone2"), contactData.homePhoneNumber2);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}
