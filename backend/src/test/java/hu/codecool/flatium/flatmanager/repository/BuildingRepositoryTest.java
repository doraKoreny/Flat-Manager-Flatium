package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.supplemetal.Day;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class BuildingRepositoryTest {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Test
    public void saveOneBuilding() {
        Building building = Building.builder()
                .residentalMeetupDate(LocalDate.of(2019, 04, 15))
                .garbageCollectionDay(Day.MONDAY)
                .commonCost(10000)
                .build();

        buildingRepository.save(building);

        List<Building> buildings = buildingRepository.findAll();
        assertThat(buildings).hasSize(1);
    }

    @Test
    public void flatsArePersistentWithBuilding() {
        List<Flat> flats = IntStream.range(1,11)
                .boxed()
                .map(integer -> Flat.builder().roomNum(2).squareMeter(42).build())
                .collect(Collectors.toList());

        Building building = Building.builder()
                .commonCost(15000)
                .garbageCollectionDay(Day.MONDAY)
                .flats(flats)
                .build();

        buildingRepository.save(building);
        assertThat(flatRepository.findAll())
                .hasSize(10);

    }

    @Test
    public void flatsAreDeletedWithBuildings() {
        List<Flat> flats = IntStream.range(1,11)
                .boxed()
                .map(integer -> Flat.builder().squareMeter(42).roomNum(2).build())
                .collect(Collectors.toList());

        Building building = Building.builder()
                .commonCost(10000)
                .garbageCollectionDay(Day.MONDAY)
                .flats(flats)
                .build();

        buildingRepository.save(building);
        buildingRepository.deleteAll();

        assertThat(flatRepository.findAll())
                .hasSize(0);
    }



}