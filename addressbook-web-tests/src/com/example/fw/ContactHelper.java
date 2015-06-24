package com.example.fw;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends WebDriverHelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContacts() {
        if (cachedContacts == null) {
            rebuildCash();
        }
        return cachedContacts;
    }

    private void rebuildCash() {
        manager.navigateTo().mainPage();
        cachedContacts = new SortedListOf<ContactData>();
        List<WebElement> rows = driver.findElements(By.name ("entry"));
        for (WebElement row : rows){
            ContactData contact = new ContactData()
                    .withFirstname(row.findElement(By.xpath("td[3]")).getText())
                    .withLastname(row.findElement(By.xpath("td[2]")).getText())
                    .withEmail(row.findElement(By.xpath("td[4]")).getText())
                    .withHomePhoneNumber(row.findElement(By.xpath("td[5]")).getText());
            cachedContacts.add(contact);
        }
    }

    public SortedListOf<String> getContactsInfo(){
        SortedListOf<String> contactInfoList = new SortedListOf<String>();
        SortedListOf<ContactData> contactList = this.getContacts();
        for (ContactData contact: contactList){
            String contactInfo = contact.getFirstname()+contact.getLastname()+contact.getHomePhoneNumber();
            contactInfoList.add(contactInfo);
        }
        return contactInfoList;
    }


    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact, CREATION);
        submitContactCreation();
        manager.navigateTo().homePage();
        rebuildCash();
        return this;
    }

    public ContactData modifyContact(int index, ContactData contact) {
        manager.navigateTo().mainPage();
        initContactModification(index);
        ContactData oldContact = new ContactData();
        getInformationFromContactForm(oldContact,index, MODIFICATION);
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        manager.navigateTo().homePage();
        rebuildCash();
        return oldContact;
    }

    public ContactHelper deleteContact(int index) {
        manager.navigateTo().mainPage();
        selectContactByIndex(index);
        click(By.xpath("//input[@value = 'Delete']"));
        manager.navigateTo().homePage();
        rebuildCash();
        return this;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNumberOfContacts(){
        manager.navigateTo().mainPage();
        return driver.findElement(By.id("search_count")).getText();
    }

    public ContactHelper fillContactForm(ContactData contactData, boolean formType) {
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
        if (formType == CREATION) {
            //selectByText(By.name("new_group"), "group1");
        }else{
            if(driver.findElements(By.name("new_group")).size()!=0){
                throw new Error("Group selector exists in contact modification form");
            }
        }

        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getHomePhoneNumber2());
        return this;
    }

    public ContactData getInformationFromContactForm(ContactData contact, int index, boolean formType) {
        contact.setFirstname(driver.findElement(By.name("firstname")).getAttribute("value"));
        contact.setLastname(driver.findElement(By.name("lastname")).getAttribute("value"));
        contact.setAddress(driver.findElement(By.name("address")).getText());
        contact.setHomePhoneNumber(driver.findElement(By.name("home")).getAttribute("value"));
        contact.setMobilePhoneNumber(driver.findElement(By.name("mobile")).getAttribute("value"));
        contact.setWorkPhoneNumber(driver.findElement(By.name("work")).getAttribute("value"));
        contact.setEmail(driver.findElement(By.name("email")).getAttribute("value"));
        contact.setEmail2(driver.findElement(By.name("email2")).getAttribute("value"));
        contact.setBday(driver.findElement(By.xpath("//select[1]/option[1]")).getAttribute("value"));
        contact.setBmonth(driver.findElement(By.xpath("//select[2]/option[1]")).getAttribute("value"));
        contact.setByear(driver.findElement(By.name("byear")).getAttribute("value"));
        contact.setAddress(driver.findElement(By.name("address2")).getText());
        contact.setHomePhoneNumber2(driver.findElement(By.name("phone2")).getAttribute("value"));
        return contact;
    }

    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper initContactModification(int index) {
        selectContactByIndex(index);
        return this;
    }

    private ContactHelper selectContactByIndex(int index) {
        click(By.xpath("//tr[" + (index + 2) + "]//a/img[@title = 'Edit']"));
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.name("update"));
        cachedContacts = null;
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cachedContacts = null;
        return this;
    }
}
