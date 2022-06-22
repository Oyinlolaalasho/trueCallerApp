package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

public interface ContactRepository {
    Contact save(Contact contant);
    int count();
    Contact findByFirstName(String firstName);
    Contact findById(int id);


    void updatePhoneNumberByFullName(String firstName, String lastName, String newPhoneNumber);

    Contact findByPhoneNumber(String phoneNumber);

    void deleteContactByFullName(String firstName, String LastName);

    Contact findByLastName(String lastName);
}
















