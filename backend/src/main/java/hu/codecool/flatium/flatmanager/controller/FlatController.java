package hu.codecool.flatium.flatmanager.controller;

import hu.codecool.flatium.flatmanager.api.BoughtFlatRequest;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.repository.FlatRepository;
import hu.codecool.flatium.flatmanager.repository.FlatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlatController {

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private FlatUserRepository flatUserRepository;

    @PostMapping(path = "/create-flat")
    public Flat createFlat(@RequestBody Flat flat) {
        flatRepository.save(flat);
        return flat;
    }

    @DeleteMapping(path = "/delete-flat")
    public String deleteFlat(@RequestBody int id) {
        flatRepository.deleteById(id);
        return "Flat with the id: " + id + " deleted successfully";
    }

    @GetMapping(path = "/get-flats")
    public List<Flat> getAllFlats() {
        return flatRepository.findAll();
    }

    @PostMapping(path = "/update-flat")
    public String updateFlat(@RequestBody Flat flat) {
        flatRepository.save(flat);
        return "Flat updated.";
    }

    @PostMapping(path = "/add-to-flat")
    public String addToFlat(@RequestBody BoughtFlatRequest boughtFlatRequest) {
        Person flatUser = flatUserRepository.findById(boughtFlatRequest.getUserId()).orElseThrow(() -> new IllegalStateException("flatUser not found"));
        Flat flat = flatRepository.findById(boughtFlatRequest.getUserId()).orElseThrow(() -> new IllegalStateException("flat not found"));

        flat.setFlatUser(flatUser);
        flatUser.setFlat(flat);

        flatRepository.save(flat);

        return "User " + flatUser.getName() + " successfully alligned to flat.";
    }

    @GetMapping(path = "/get-myflat/{user_id}")
    public Flat getFlatByUserId(@PathVariable("user_id") String userId) {
        return flatRepository.findByFlatUserId(Integer.parseInt(userId));
    }
}
