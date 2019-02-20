package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.service.FlatStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlatController {

    @Autowired
    private FlatStorageService flatStorage;

    @RequestMapping(
            path = "/create-flat",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Flat> createFlat() {
        return ResponseEntity.ok(flatStorage.addFlat());
    }

}
