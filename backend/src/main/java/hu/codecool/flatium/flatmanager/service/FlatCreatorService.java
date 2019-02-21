package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.bills.Bill;
import hu.codecool.flatium.flatmanager.flat.bills.BillType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlatCreatorService {

    public Flat createNewFlat(int roomNum, int squareMeter) {
        Flat flat = new Flat();
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill(BillType.INTERNET, 5000));
        flat.setRoomNum(roomNum);
        flat.setSquareMeter(squareMeter);
        flat.setBills(bills);
        return flat;
    }

}
