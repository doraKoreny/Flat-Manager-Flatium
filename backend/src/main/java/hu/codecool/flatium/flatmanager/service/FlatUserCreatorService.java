package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.FlatUser;
import org.springframework.stereotype.Service;

@Service
public class FlatUserCreatorService {

    public FlatUser createFlatUser(String name, String phoneNumber, String email) {
        return new FlatUser(name, phoneNumber, email);

    }
}
