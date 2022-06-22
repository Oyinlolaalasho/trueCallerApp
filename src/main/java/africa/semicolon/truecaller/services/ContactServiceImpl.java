package africa.semicolon.truecaller.services;
import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepository;


public class ContactServiceImpl implements ContactService {



//    public class ContactServiceImp implements ContactService {
        private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

//    public void ContactRepositoryImp(ContactRepository contactRepository){
//
//        }

        @Override
        public void addContact(String firstName, String lastname, String phoneNumber) {
            Contact contact = new Contact(firstName, lastname, phoneNumber);
            contactRepository.save(contact);
        }

        @Override
        public Contact findById(int i) {
            return contactRepository.findById(i);
        }
    }



//package africa.semicolon.truecaller.services;
