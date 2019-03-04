package hu.codecool.flatium.flatmanager.model.flat;

import hu.codecool.flatium.flatmanager.model.building.Building;
import hu.codecool.flatium.flatmanager.model.flat.bills.Bill;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flat {
    @Id
    @GeneratedValue
    private int id;

    @ElementCollection
    @Singular
    @OneToMany(mappedBy = "flat", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Bill> bills = new ArrayList<>();

    private int squareMeter;
    private int roomNum;

    @OneToOne(mappedBy = "flat", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Person flatUser;

    @ManyToOne
    private Building building;

}
