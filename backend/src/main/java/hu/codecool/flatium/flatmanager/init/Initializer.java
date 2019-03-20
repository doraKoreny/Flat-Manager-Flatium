package hu.codecool.flatium.flatmanager.init;

import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.flat.bills.Bill;
import hu.codecool.flatium.flatmanager.model.flat.bills.BillType;
import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import hu.codecool.flatium.flatmanager.model.supplemetal.Day;
import hu.codecool.flatium.flatmanager.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Initializer {

    @Autowired
    private BuildingRepository buildingRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {


            Bill bill = Bill.builder()
                    .price(12000)
                    .billType(BillType.ELECTRICITY)
                    .build();

            Flat flat = Flat.builder()
                    .squareMeter(42)
                    .roomNum(2)
                    .bill(bill)
                    .build();

            Person doraUser = Person.builder()
                    .email("dorello@codecool.hu")
                    .type(PersonType.FLATUSER)
                    .name("Dóra")
                    .phoneNumber("373626211")
                    .flat(flat)
                    .build();

            Building building = Building.builder()
                    .commonCost(10000)
                    .garbageCollectionDay(Day.MONDAY)
                    .residentalMeetupDate(LocalDate.of(2020, 12, 29))
                    .flat(flat)
                    .build();

            flat.setFlatUser(doraUser);
            bill.setFlat(flat);
            flat.setBuilding(building);
            buildingRepository.save(building);


        };
    }
}
