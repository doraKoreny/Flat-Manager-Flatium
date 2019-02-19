package hu.codecool.flatium.flatmanager.flat;

import hu.codecool.flatium.flatmanager.flat.bills.Bill;

import java.util.ArrayList;
import java.util.List;

public class Flat {
    private int id;
    private static int idCounter = 0;
    private List<Bill> bills = new ArrayList<>();
    private int squareMeter;
    private int roomNum;
    private FlatUser flatUser;

    public Flat() {
    }

    public Flat(int squareMeter, int roomNum, FlatUser flatUser) {
        this.id = idCounter++;
        this.squareMeter = squareMeter;
        this.roomNum = roomNum;
        this.flatUser = flatUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public FlatUser getFlatUser() {
        return flatUser;
    }

    public void setFlatUser(FlatUser flatUser) {
        this.flatUser = flatUser;
    }
}
