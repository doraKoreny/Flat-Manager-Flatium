package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.model.flat.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatUserStorageService {

    @Autowired
    private FlatUserCreatorService flatUserCreator;

    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void addFlatUser(Person person) {
        this.personList.add(person);
    }

    public void deleteFlatUser(int id) {
        this.personList = personList.stream()
                .filter(flatUser -> flatUser.getId() != id)
                .collect(Collectors.toList());
    }

    public void updateFlatUser(int updateId, Person updatedPerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == updateId) {
                Person currentPerson = personList.get(i);
                currentPerson.setName(updatedPerson.getName());
                currentPerson.setEmail(updatedPerson.getEmail());
                currentPerson.setPhoneNumber(updatedPerson.getPhoneNumber());
                personList.set(i, currentPerson);
            }
        }
    }

    public Person getUserById(int id){
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
