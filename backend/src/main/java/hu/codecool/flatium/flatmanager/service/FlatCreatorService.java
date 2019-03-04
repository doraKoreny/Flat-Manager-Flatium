package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.bills.Bill;
import hu.codecool.flatium.flatmanager.model.flat.bills.BillType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlatCreatorService {

    public Flat createNewFlat(int roomNum, int squareMeter) {
        List<Bill> bills = new ArrayList<>();
        bills.add(Bill.builder()
                .billType(BillType.INTERNET)
                .price(5000)
                .build());
        Flat flat = Flat.builder()
                .roomNum(roomNum)
                .squareMeter(squareMeter)
                .bills(bills)
                .build();
        return flat;
    }
}
