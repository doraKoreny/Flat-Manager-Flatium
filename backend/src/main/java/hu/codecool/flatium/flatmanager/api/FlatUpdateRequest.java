package hu.codecool.flatium.flatmanager.api;

import hu.codecool.flatium.flatmanager.flat.Flat;

public class FlatUpdateRequest {
    private int id;
    private Flat flat;

    public FlatUpdateRequest() {
    }

    public FlatUpdateRequest(int id, Flat flat) {
        this.id = id;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
