package com.example.tests;

public class ContactData implements  Comparable<ContactData> {
    private String id;
    private String firstname;
    private String lastname;
    private String address;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String workPhoneNumber;
    private String email;
    private String email2;
    private String bday;
    private String bmonth;
    private String byear;
    private String address2;
    private String homePhoneNumber2;

    public ContactData() {
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ContactData other = (ContactData) obj;
        if (firstname != null ? !firstname.equals(other.firstname) : other.firstname != null)
            return false;
        if (lastname != null ? !lastname.equals(other.lastname) : other.lastname != null)
            return false;
        if (homePhoneNumber != null ? !homePhoneNumber.equals(other.homePhoneNumber) : other.homePhoneNumber != null)
            return false;
        return !(email != null ? !email.equals(other.email) : other.email != null);
    }

    @Override
    public int hashCode() {
        /*
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (homePhoneNumber != null ? homePhoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        */
        int result = 1;
        return result;
    }

    @Override
    public int compareTo(ContactData obj) {
        int i = this.lastname.toLowerCase().compareTo(obj.lastname.toLowerCase());
        if (i == 0) {
            i = this.firstname.toLowerCase().compareTo(obj.firstname.toLowerCase());
            if (i == 0) {
                i = this.email.toLowerCase().compareTo(obj.email.toLowerCase());
                if (i == 0) {
                    i = this.homePhoneNumber.toLowerCase().compareTo(obj.homePhoneNumber.toLowerCase());
                }
            }
        }
        return i;
    }

    public ContactData withId (String id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    public ContactData withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ContactData withWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withHomePhoneNumber2(String homePhoneNumber2) {
        this.homePhoneNumber2 = homePhoneNumber2;
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setHomePhoneNumber2(String homePhoneNumber2) {
        this.homePhoneNumber2 = homePhoneNumber2;
    }

    public String getId() {  return id;    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomePhoneNumber2() {
        return homePhoneNumber2;
    }
}

