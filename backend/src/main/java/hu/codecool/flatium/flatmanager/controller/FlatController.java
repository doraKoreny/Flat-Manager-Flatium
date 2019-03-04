package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.BoughtFlatRequest;
import hu.codecool.flatium.flatmanager.api.FlatUpdateRequest;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.service.FlatStorageService;
import hu.codecool.flatium.flatmanager.service.FlatUserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatController {

    @Autowired
    private FlatStorageService flatStorage;

    @Autowired
    private FlatUserStorageService flatUserStorage;

    @PostMapping(path = "/create-flat")
    public ResponseEntity<Flat> createFlat() {
        return ResponseEntity.ok(flatStorage.addFlat());
    }

    @DeleteMapping(path = "/delete-flat")
    public ResponseEntity<String> deleteFlat(@RequestBody int id) {
        flatStorage.deleteFlat(id);
        return ResponseEntity.ok("Flat with the id: " + id + " deleted successfully");
    }

    @GetMapping(path = "/get-flats")
    public ResponseEntity<List<Flat>> getAllFlats() {
        return ResponseEntity.ok(flatStorage.getFlats());
    }

    @PostMapping(path = "/update-flat")
    public ResponseEntity<String> updateFlat(@RequestBody FlatUpdateRequest flatUpdateRequest) {
        flatStorage.updateFlat(flatUpdateRequest.getId(),flatUpdateRequest.getFlat());
        return ResponseEntity.ok("Flat updated.");
    }

    @PostMapping(path = "/add-to-flat")
    public ResponseEntity<String> getFlatUser(@RequestBody BoughtFlatRequest boughtFlatRequest) {
        Person person = flatUserStorage.getUserById(boughtFlatRequest.getUserId());
        Flat flat = flatStorage.getFlat(boughtFlatRequest.getFlatId());
        flat.setFlatUser(person);
        flatStorage.updateFlat(flat);
        return ResponseEntity.ok("User " + person.getName() + " successfully alligned to flat.");
    }
}
