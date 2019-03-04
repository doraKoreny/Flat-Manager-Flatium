package hu.codecool.flatium.flatmanager.model.building;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.supplemetal.Day;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Building {

    @Id
    @GeneratedValue
    private int id;

    @ElementCollection
    @Singular
    @OneToMany(mappedBy = "building", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Flat> flats = new ArrayList<>();

    @ElementCollection
    private List<Person> contactPeople = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Day garbageCollectionDay;

    private double commonCost;
    private LocalDate residentalMeetupDate;

}
