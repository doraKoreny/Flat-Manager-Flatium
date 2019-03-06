package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.AssignToBuildingRequest;
import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.repository.BuildingRepository;
import hu.codecool.flatium.flatmanager.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private FlatRepository flatRepository;

    @PostMapping(path = "/create-building")
    public Building createBuilding(@RequestBody Building building) {
        buildingRepository.save(building);
        return building;
    }

    @DeleteMapping(path = "/delete-building")
    public String deleteBuilding(@RequestBody int id) {
        buildingRepository.deleteById(id);
        return "Building with the id: " + id + " deleted successfully";
    }

    @GetMapping(path = "/get-buildings")
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @PostMapping(path = "get-building")
    public Building getBuilding(@RequestBody int id){
        return buildingRepository.findById(id).orElseThrow(()->new IllegalStateException("Building not found"));
    }

    @PostMapping(path = "/add-flat")
    public String assignFlatToBuilding(@RequestBody AssignToBuildingRequest chosenBuilding) {

        Flat flat = flatRepository.findById(chosenBuilding.getFlatId()).orElseThrow(()-> new IllegalStateException("flat not found"));
        Building building = buildingRepository.findById(chosenBuilding.getBuildingId()).orElseThrow(()-> new IllegalStateException("building not found"));

        building.allignFlat(flat);
        flat.setBuilding(building);
        buildingRepository.save(building);

        return "flat alligned";
    }

    @PostMapping(path = "/update-building")
    public Building updateBuilding(@RequestBody Building building) {
        buildingRepository.save(building);
        return building;
    }

}
