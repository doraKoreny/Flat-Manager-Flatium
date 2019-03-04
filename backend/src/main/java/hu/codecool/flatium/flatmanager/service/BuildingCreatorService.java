package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.supplemetal.Day;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingCreatorService {

    public Building createNewBuilding() {
        Building building = Building.builder()
                .garbageCollectionDay(Day.MONDAY)
                .commonCost(10000)
                .build();
        return building;
    }
}
