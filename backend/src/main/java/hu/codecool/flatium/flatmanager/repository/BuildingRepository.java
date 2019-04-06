package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
