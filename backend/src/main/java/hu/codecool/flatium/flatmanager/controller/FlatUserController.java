package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.FlatUserUpdateRequest;
import hu.codecool.flatium.flatmanager.flat.FlatUser;
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
            path = "/delete-flatuser",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> deleteFlatUser(@RequestBody int id) {
        flatUserStorage.deleteFlatUser(id);
        return ResponseEntity.ok("Flat User with the id: " + id + " deleted successfully");
    }

    @RequestMapping(
            path = "/get-flatusers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<FlatUser>> getAllFlatUser() {
        return ResponseEntity.ok(flatUserStorage.getFlatUserList());
    }

    @RequestMapping(
            path = "/update-flatuser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> updateFlatUser(@RequestBody FlatUserUpdateRequest flatUser) {
        flatUserStorage.updateFlatUser(flatUser.getFlatUserId(), flatUser.getFlatUser());
        return ResponseEntity.ok("Updated successfully");
    }
}
