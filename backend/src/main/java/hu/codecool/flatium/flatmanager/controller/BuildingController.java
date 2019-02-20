package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.building.Building;
import hu.codecool.flatium.flatmanager.service.BuildingStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BuildingController {

    @Autowired
    private BuildingStorageService buildingStorage;

    @RequestMapping(
        path = "/create-building",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Building> createBuilding(){
        return ResponseEntity.ok(buildingStorage.addBuilding());
    }
}
