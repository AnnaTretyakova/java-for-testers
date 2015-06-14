package com.example.fw;

public class Contact {

    public String firstName;
    public String lastName;

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
