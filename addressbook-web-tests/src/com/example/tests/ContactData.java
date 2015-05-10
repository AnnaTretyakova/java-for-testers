package com.example.tests;

public class ContactData implements  Comparable<ContactData> {
    public String firstname;
    public String lastname;
    public String address;
    public String homePhoneNumber;
    public String mobilePhoneNumber;
    public String workPhoneNumber;
    public String email;
    public String email2;
    public String bday;
    public String bmonth;
    public String byear;
    public String address2;
    public String homePhoneNumber2;

    public ContactData() {
    }

    @Override
    public String toString() {
        return "ContactData{" +
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
}
