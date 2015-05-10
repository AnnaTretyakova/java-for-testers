package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteContact(int index) {
        selectContactByIndex(index);
        click(By.xpath("//input[@value = 'Delete']"));
    }

    public void initContactModification(int index) {
        selectContactByIndex(index);
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//tr[" + (index + 2) + "]//a/img[@title = 'Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = driver.findElements(By.name ("entry"));
        for (WebElement row : rows){
            ContactData contact = new ContactData();
            contact.firstname = row.findElement(By.xpath("td[3]")).getText();
            contact.lastname = row.findElement(By.xpath("td[2]")).getText();
            contact.email = row.findElement(By.xpath("td[4]")).getText();
            contact.homePhoneNumber = row.findElement(By.xpath("td[5]")).getText();
            contacts.add(contact);
        }
        return contacts;
    }
}
