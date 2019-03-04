package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.AssignToBuildingRequest;
import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.service.BuildingStorageService;
import hu.codecool.flatium.flatmanager.service.FlatStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BuildingController {

    @Autowired
    private BuildingStorageService buildingStorage;

    @Autowired
    private FlatStorageService flatStorage;

    @PutMapping(path = "/create-building")
    public ResponseEntity<Building> createBuilding() {
        return ResponseEntity.ok(buildingStorage.addBuilding());
    }

    @DeleteMapping(path = "/delete-building")
    public ResponseEntity<String> deleteBuilding(@RequestBody int id) {
        buildingStorage.deleteBuilding(id);
        return ResponseEntity.ok("Building with the id: " + id + " deleted successfully");
    }

    @GetMapping(path = "/get-buildings")
    public ResponseEntity<List<Building>> getAllBuildings() {
        return ResponseEntity.ok(buildingStorage.getBuildings());
    }

    @PutMapping(path = "/add-flat")
    public Flat assignFlatToBuilding(@RequestBody AssignToBuildingRequest chosenBuilding) {
        Flat flat = flatStorage.getFlat(chosenBuilding.getFlatId());
        return buildingStorage.assignFlatToBuilding(flat, chosenBuilding.getBuildingId());
    }

    @PostMapping(path = "/update-building")
    public Building updateBuilding(@RequestBody Building building) {
        buildingStorage.updateBuilding(building);
        return building;
    }

}
