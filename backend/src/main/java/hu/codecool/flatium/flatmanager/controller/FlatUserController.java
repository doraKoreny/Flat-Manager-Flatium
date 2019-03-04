package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.FlatUserUpdateRequest;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.service.FlatUserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatUserController {

    @Autowired
    private FlatUserStorageService flatUserStorage;

    @PostMapping(path = "/create-flatuser")
    public ResponseEntity<String> createFlatUser(@RequestBody Person person) {
        flatUserStorage.addFlatUser(person);
        return ResponseEntity.ok("User added successfully.");
    }

    @DeleteMapping(path = "/delete-flatuser")
    public ResponseEntity<String> deleteFlatUser(@RequestBody int id) {
        flatUserStorage.deleteFlatUser(id);
        return ResponseEntity.ok("Flat User with the id: " + id + " deleted successfully");
    }

    @GetMapping(path = "/get-flatusers")
    public ResponseEntity<List<Person>> getAllFlatUser() {
        return ResponseEntity.ok(flatUserStorage.getPersonList());
    }

    @PostMapping(path = "/update-flatuser")
    public ResponseEntity<String> updateFlatUser(@RequestBody FlatUserUpdateRequest flatUser) {
        flatUserStorage.updateFlatUser(flatUser.getFlatUserId(), flatUser.getPerson());
        return ResponseEntity.ok("Updated successfully");
    }
}
