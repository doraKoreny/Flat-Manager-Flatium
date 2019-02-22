package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.building.Building;
import hu.codecool.flatium.flatmanager.service.BuildingStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BuildingController {

    @Autowired
    private BuildingStorageService buildingStorage;

    @RequestMapping(
            path = "/create-building",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Building> createBuilding() {
        return ResponseEntity.ok(buildingStorage.addBuilding());
    }

    @RequestMapping(
            path = "/delete-building",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<String> deleteBuilding(@RequestBody int id){
        buildingStorage.deleteBuilding(id);
        return ResponseEntity.ok("Building with the id: " + id + " deleted successfully");
    }

    @RequestMapping(
            path = "get-buildings",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<Building>> getAllBuildings(){
        return ResponseEntity.ok(buildingStorage.getBuildings());
    }
}
