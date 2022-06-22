package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImp implements ContactRepository {

    private int count = 0;
    List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {

        if (savedContactExists(contact.getFirstName(), contact.getLastName()))
            throw new IllegalArgumentException("Contact already exists, change input ");
        if (phoneNumberExists(contact.getPhoneNumber()))
            throw new IllegalArgumentException("Phone Number is duplicated, Contact already exists, change input");
        contacts.add(contact);
        assignId(contact);
        System.out.println(contact);
        return contact;
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public void updatePhoneNumberByFullName(String firstName, String lastName, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                contact.setPhoneNumber(newPhoneNumber);
            }
            System.out.println(contact);
        }
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void deleteContactByFullName(String firstName, String LastName) {
        for (Contact foundContact : contacts) {
            if (foundContact.getFirstName().equalsIgnoreCase(firstName) && foundContact.getLastName().equalsIgnoreCase(LastName)) {
//                System.out.println(foundContact);
                contacts.remove(foundContact);
                System.out.println(foundContact);
            }
        }
    }

    @Override
    public Contact findByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }


    private void assignId(Contact contact) {
        contact.setId(contacts.size());
    }

    @Override
    public int count() {
        return contacts.size();
    }

    public boolean savedContactExists(String firstName, String LastName) {
        for (Contact contact : contacts) {
            return contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(LastName);
        }
        return false;
    }

    public boolean phoneNumberExists(String PhoneNumber) {
        for (Contact contact : contacts) {
            return (PhoneNumber.equals(contact.getPhoneNumber()));
        }
        return false;
    }
}