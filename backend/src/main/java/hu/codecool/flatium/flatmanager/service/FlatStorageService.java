package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.Flat;
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

    public void updateFlat(Flat updatedFlat) {
        for (int i = 0; i < flats.size(); i++) {
            if (flats.get(i).getId() == updatedFlat.getId()) {
                flats.set(i, updatedFlat);
            }
        }

    }

    public List<Flat> getFlats() {
        return flats;
    }
}
