package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatStorageService {

    @Autowired
    private FlatCreatorService flatCreator;

    private List<Flat> flats = new ArrayList<>();

    public Flat addFlat() {
        Flat flat = flatCreator.createNewFlat(2, 42);
        this.flats.add(flat);
        return flat;
    }

    public void deleteFlat(int id) {
        this.flats = flats.stream()
                .filter(flat -> flat.getId() != id)
                .collect(Collectors.toList());
    }

    public void updateFlat(Flat updatedFlat){
        for (int i = 0; i < flats.size() ; i++) {
            if(flats.get(i).getId() == updatedFlat.getId()){
                flats.set(i,updatedFlat);
            }
        }
    }

    public void updateFlat(int id,Flat updatedFlat) {
        for (int i = 0; i < flats.size(); i++) {
            if (flats.get(i).getId() == id) {
                Flat flat = flats.get(i);
                flat.setBills(updatedFlat.getBills());
                flat.setFlatUser(updatedFlat.getFlatUser());
                flat.setRoomNum(updatedFlat.getRoomNum());
                flat.setSquareMeter(updatedFlat.getSquareMeter());
                flats.set(i, updatedFlat);
            }
        }

    }

    public Flat getFlat(int id){
        for (Flat flat : flats) {
            if (flat.getId() == id) {
                return flat;
            }
        }
        return null;
    }

    public List<Flat> getFlats() {
        return flats;
    }
}
