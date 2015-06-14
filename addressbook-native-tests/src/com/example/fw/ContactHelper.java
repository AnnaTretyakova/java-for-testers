package com.example.fw;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createContact(Contact contact){
        initContactCreation();
        fillContactForm(contact);
        confirmContactCreation();
    }

    public Contact getFirstContact() {
        manager.getAutoItHelper()
                .focus("TListView1")
                .send("{DOWN}{SPACE}")
                .click("Edit")
                .winWaitAndActivate("Update Contact", "", 5000);
        Contact contact = new Contact()
                .setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
                .setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
        manager.getAutoItHelper()
                .click("Cancel")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
        return contact;
    }

    public void deleteContacts() {
        initContactsRemoval();
        confirmContactsRemoval();
    }

    public void verifyContactsRemoval() {
        manager.getAutoItHelper()
                .focus("TListView1")
                .send("{DOWN}{SPACE}");
        manager.getAutoItHelper()
                .click("Edit")
                .winWaitAndActivate("Information", "", 5000)
                .click("OK")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }

    //------------------------------------------------------------------------------------

    private void initContactCreation() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("Add")
                .winWaitAndActivate("Add Contact", "", 5000);
    }

    private void fillContactForm(Contact contact) {
        manager.getAutoItHelper()
                .send("TDBEdit12", contact.firstName)
                .send("TDBEdit11", contact.lastName);
    }

    private void confirmContactCreation() {
        manager.getAutoItHelper()
                .click("Save")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }

    private void initContactsRemoval() {
        manager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("Select All")
                .click("Delete");
    }

    private void confirmContactsRemoval() {
        manager.getAutoItHelper()
                .winWaitAndActivate("Confirm", "", 5000)
                .click("TButton2")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }
}
