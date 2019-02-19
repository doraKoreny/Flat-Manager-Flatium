package hu.codecool.flatium.flatmanager.building;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.contacts.ContactPerson;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private int id;
    private static int idCounter = 0;
    private List<Flat> flats = new ArrayList<>();
    private ContactPerson landLord;
    private ContactPerson janitor;
    private ContactPerson doctor;
    private ContactPerson notary;
    private String garbageCollectingTime;
    private double commonCost;
    private String residentalMeetupDate;

    public Building() {
    }

    public Building(List<Flat> flats, ContactPerson landLord, ContactPerson janitor, ContactPerson doctor, ContactPerson notary, String garbageCollectingTime, double commonCost) {
        this.flats = flats;
        this.landLord = landLord;
        this.janitor = janitor;
        this.doctor = doctor;
        this.notary = notary;
        this.garbageCollectingTime = garbageCollectingTime;
        this.commonCost = commonCost;
    }
}
