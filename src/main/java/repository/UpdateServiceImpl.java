package repository;

import fileService.FileService;
import model.Contact;
import service.UpdateService;

import java.util.ArrayList;
import java.util.List;

public class UpdateServiceImpl implements UpdateService {

    private final FileService fileService;
    private final List<Contact> contacts;

    public UpdateServiceImpl() {
        this.fileService = new FileService();
        this.contacts = fileService.read() != null ? fileService.read() : new ArrayList<>();
    }

    @Override
    public void update(Contact oldContact, Contact newContact) {
        newContact.setId(oldContact.getId());
        contacts.remove(oldContact);
        contacts.add(newContact);
        fileService.write(contacts);
    }


    @Override
    public List<Contact> findAllByName(String name) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }

    @Override
    public List<Contact> findAllBySurname(String surname) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getSurname().equalsIgnoreCase(surname)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }

    @Override
    public List<Contact> findAllByAddress(String address) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getAddress().equalsIgnoreCase(address)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }

    @Override
    public List<Contact> findAllByPhone(String phone) {
        String cleanPhone = phone.replaceAll("\\s", "");
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhone().replaceAll("\\s", "").equalsIgnoreCase(cleanPhone)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }


}
