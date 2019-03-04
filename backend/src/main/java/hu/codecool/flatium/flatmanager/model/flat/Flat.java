package hu.codecool.flatium.flatmanager.model.flat;

import hu.codecool.flatium.flatmanager.model.flat.bills.Bill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flat {
    private int id;
    private static int idCounter = 0;
    private List<Bill> bills = new ArrayList<>();
    private int squareMeter;
    private int roomNum;
    private Person person;

}
