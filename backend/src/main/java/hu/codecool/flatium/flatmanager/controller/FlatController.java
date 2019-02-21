package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.BoughtFlatRequest;
import hu.codecool.flatium.flatmanager.api.FlatUpdateRequest;
import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.FlatUser;
import hu.codecool.flatium.flatmanager.service.FlatStorageService;
import hu.codecool.flatium.flatmanager.service.FlatUserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlatController {

    @Autowired
    private FlatStorageService flatStorage;

    @Autowired
    private FlatUserStorageService flatUserStorage;

    @RequestMapping(
            path = "/create-flat",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Flat> createFlat() {
        return ResponseEntity.ok(flatStorage.addFlat());
    }

    @RequestMapping(
            path = "/delete-flat",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> deleteFlat(@RequestBody int id) {
        flatStorage.deleteFlat(id);
        return ResponseEntity.ok("Flat with the id: " + id + " deleted successfully");
    }

    @RequestMapping(
            path = "/get-flats",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<Flat>> getAllFlats() {
        return ResponseEntity.ok(flatStorage.getFlats());
    }

    @RequestMapping(
            path = "/update-flat",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> updateFlat(@RequestBody FlatUpdateRequest flatUpdateRequest) {
        flatStorage.updateFlat(flatUpdateRequest.getId(),flatUpdateRequest.getFlat());
        return ResponseEntity.ok("Flat updated.");
    }

    @RequestMapping(
            path = "/add-to-flat",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> getFlatUser(@RequestBody BoughtFlatRequest boughtFlatRequest) {
        FlatUser flatUser = flatUserStorage.getUserById(boughtFlatRequest.getUserId());
        Flat flat = flatStorage.getFlat(boughtFlatRequest.getFlatId());
        flat.setFlatUser(flatUser);
        flatStorage.updateFlat(flat);
        return ResponseEntity.ok("User " + flatUser.getName() + " successfully alligned to flat.");
    }
}
