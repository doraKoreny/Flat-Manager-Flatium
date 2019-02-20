package hu.codecool.flatium.flatmanager.flat.contacts;

import hu.codecool.flatium.flatmanager.person.Person;

public class ContactPerson extends Person {
    private ContactPersonType type;

    public ContactPerson(ContactPersonType type) {
        this.type = type;
    }

    public ContactPerson(String name, String phoneNumber, String email, ContactPersonType type) {
        super(name, phoneNumber, email);
        this.type = type;
    }
}
