package hu.codecool.flatium.flatmanager.model.building;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.supplemetal.Day;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building {
    private int id;

    private static int idCounter = 0;

    @Singular
    private List<Flat> flats = new ArrayList<>();

    private List<Person> contactPeople = new ArrayList<>();

    private Day garbageCollectionDay;
    private double commonCost;
    private String residentalMeetupDate;


}
