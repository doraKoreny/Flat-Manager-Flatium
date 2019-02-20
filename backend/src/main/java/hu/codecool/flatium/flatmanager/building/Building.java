package hu.codecool.flatium.flatmanager.building;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.contacts.ContactPerson;
import hu.codecool.flatium.supplemetal.Day;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int id;

    private static int idCounter = 0;

    private List<Flat> flats = new ArrayList<>();
    private List<ContactPerson> contactPeople = new ArrayList<>();
    private Day day;
    private double commonCost;
    private String residentalMeetupDate;
    public Building() {
    }

    public Building(List<Flat> flats, Day day, double commonCost) {
        this.flats = flats;
        this.day = day;
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


    public Day getDay() {
        return day;
    }

    public void setGarbageCollectingTime(Day day) {
        this.day = day;
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
