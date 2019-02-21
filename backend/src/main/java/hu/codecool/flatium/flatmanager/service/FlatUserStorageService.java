package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.flat.FlatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatUserStorageService {

    @Autowired
    private FlatUserCreatorService flatUserCreator;

    private List<FlatUser> flatUserList = new ArrayList<>();

    public List<FlatUser> getFlatUserList() {
        return flatUserList;
    }

    public void addFlatUser(FlatUser flatUser) {
        this.flatUserList.add(flatUser);
    }

    public void deleteFlatUser(int id) {
        this.flatUserList = flatUserList.stream()
                .filter(flatUser -> flatUser.getId() != id)
                .collect(Collectors.toList());
    }

    public void updateFlatUser(FlatUser updatedFlatUser) {
        for (int i = 0; i < flatUserList.size(); i++) {
            if (flatUserList.get(i).getId() == updatedFlatUser.getId()) {
                flatUserList.set(i, updatedFlatUser);
            }
        }
    }


}