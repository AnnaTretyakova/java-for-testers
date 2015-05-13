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
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhoneNumber());
        type(By.name("mobile"), contactData.getMobilePhoneNumber());
        type(By.name("work"), contactData.getWorkPhoneNumber());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        selectByText(By.name("bday"), contactData.getBday());
        selectByText(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getHomePhoneNumber2());
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
            ContactData contact = new ContactData()
                    .withFirstname(row.findElement(By.xpath("td[3]")).getText())
                    .withLastname(row.findElement(By.xpath("td[2]")).getText())
                    .withEmail(row.findElement(By.xpath("td[4]")).getText())
                    .withHomePhoneNumber(row.findElement(By.xpath("td[5]")).getText());
            contacts.add(contact);
        }
        return contacts;
    }
}
