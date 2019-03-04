package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatUserRepository extends JpaRepository<Person, Integer> {
}
