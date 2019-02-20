package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.flat.FlatUser;
import hu.codecool.flatium.flatmanager.service.FlatUserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlatUserController {

    @Autowired
    private FlatUserStorageService flatUserStorage;

    @RequestMapping(
            path = "create-flatuser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> createFlatUser(@RequestBody FlatUser flatUser) {
        flatUserStorage.addFlatUser(flatUser);
        return ResponseEntity.ok("User added successfully.");
    }

    @RequestMapping(
            path = "/delete-flatUser",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> deleteFlatUser(@RequestBody int id) {
        flatUserStorage.deleteFlatUser(id);
        return ResponseEntity.ok("Flat User with the id: " + id + " deleted successfully");
    }

}
