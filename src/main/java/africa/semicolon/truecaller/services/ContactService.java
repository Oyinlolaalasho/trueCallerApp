package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;

public interface ContactService {


    void addContact(String firstName, String lastname, String phoneNumber);
    
    
    Contact findById(int i);
}
