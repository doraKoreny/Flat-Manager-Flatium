package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.FlatUserUpdateRequest;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.repository.FlatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatUserController {

    @Autowired
    private FlatUserRepository flatUserRepository;

    @PostMapping(path = "/create-flatuser")
    public String createFlatUser(@RequestBody Person person) {
        flatUserRepository.save(person);
        return "User added successfully.";
    }

    @DeleteMapping(path = "/delete-flatuser")
    public String deleteFlatUser(@RequestBody int id) {
        flatUserRepository.deleteById(id);
        return "Flat User with the id: " + id + " deleted successfully";
    }

    @GetMapping(path = "/get-flatusers")
    public List<Person> getAllFlatUser() {
        return flatUserRepository.findAll();
    }

    @PostMapping(path = "/update-flatuser")
    public String updateFlatUser(@RequestBody FlatUserUpdateRequest flatUser) {
        Person flatUserToSave = flatUser.getPerson();
        flatUserToSave.setId(flatUser.getFlatUserId());
        flatUserRepository.save(flatUserToSave);
        return "Updated successfully";
    }
}
