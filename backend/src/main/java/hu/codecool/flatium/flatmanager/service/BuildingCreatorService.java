package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.building.Building;
import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.supplemetal.Day;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingCreatorService {

    public Building createNewBuilding() {
        Building building = new Building();
        List<Flat> flats = new ArrayList<>();
        for (int i = 0; i < 16; i++) flats.add(new Flat());
        building.setFlats(flats);
        building.setGarbageCollectingTime(Day.MONDAY);
        building.setCommonCost(10000);
        return building;
    }
}
