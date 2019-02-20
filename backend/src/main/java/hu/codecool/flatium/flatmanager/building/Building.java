package hu.codecool.flatium.flatmanager.building;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.contacts.ContactPerson;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int id;

    private static int idCounter = 0;

    private List<Flat> flats = new ArrayList<>();
    private List<ContactPerson> contactPeople = new ArrayList<>();
    private String garbageCollectingTime;
    private double commonCost;
    private String residentalMeetupDate;
    public Building() {
    }

    public Building(List<Flat> flats, String garbageCollectingTime, double commonCost) {
        this.flats = flats;
        this.garbageCollectingTime = garbageCollectingTime;
        this.commonCost = commonCost;
    }

    public int getId() {
        return id;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }


    public String getGarbageCollectingTime() {
        return garbageCollectingTime;
    }

    public void setGarbageCollectingTime(String garbageCollectingTime) {
        this.garbageCollectingTime = garbageCollectingTime;
    }

    public double getCommonCost() {
        return commonCost;
    }

    public void setCommonCost(double commonCost) {
        this.commonCost = commonCost;
    }

    public String getResidentalMeetupDate() {
        return residentalMeetupDate;
    }

    public void setResidentalMeetupDate(String residentalMeetupDate) {
        this.residentalMeetupDate = residentalMeetupDate;
    }
}
