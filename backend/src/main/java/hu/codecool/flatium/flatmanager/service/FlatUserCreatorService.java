package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import org.springframework.stereotype.Service;

@Service
public class FlatUserCreatorService {

    public Person createFlatUser(String name, String phoneNumber, String email) {
        return Person.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .type(PersonType.FLATUSER)
                .build();
    }
}
