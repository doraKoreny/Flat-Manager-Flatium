package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingStorageService {

    @Autowired
    private BuildingCreatorService buildingCreator;

    private List<Building> buildings = new ArrayList<>();

    public Building addBuilding(){
        Building building = buildingCreator.createNewBuilding();
        this.buildings.add(building);
        return building;
    }

    public void deleteBuilding(int id){
        this.buildings = buildings.stream()
                                .filter(building -> building.getId() != id)
                                .collect(Collectors.toList());
    }

    public void updateBuilding(Building updatedBuilding){
        for (int i = 0; i < buildings.size() ; i++) {
            if(buildings.get(i).getId() == updatedBuilding.getId()){
                buildings.set(i,updatedBuilding);
            }
        }
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Flat assignFlatToBuilding(Flat flat, int buildingId) {
        Building buildingToAssign = buildings.stream()
                .filter(building -> building.getId() == buildingId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such building."));
        buildingToAssign.setFlats(Collections.singletonList(flat));
        return flat;
    }
}
