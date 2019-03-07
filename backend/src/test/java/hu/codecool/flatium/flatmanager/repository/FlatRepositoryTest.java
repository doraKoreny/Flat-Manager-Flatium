package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class FlatRepositoryTest {

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    FlatUserRepository flatUserRepository;

    @Test
    public void saveOneSimple() {
        Flat flat = Flat.builder()
                .roomNum(2)
                .squareMeter(42)
                .build();

        flatRepository.saveAndFlush(flat);
        assertThat(flatRepository.findAll().size()).isEqualTo(1);

    }

    @Test
    public void flatPersistWithFlatUser() {
        Flat flat = Flat.builder()
                .squareMeter(42)
                .roomNum(2)
                .build();

        Person person = Person.builder()
                .name("Alka")
                .email("alka@codecool.hu")
                .phoneNumber("36303456712")
                .birthDate(LocalDate.of(1987, 5, 12))
                .type(PersonType.FLATUSER)
                .build();

        flat.setFlatUser(person);

        flatRepository.saveAndFlush(flat);
        flatUserRepository.saveAndFlush(person);
        List<Flat> flatList = flatRepository.findAll();

        assertThat(flatList)
                .hasSize(1)
                .anyMatch(flat1 -> flat1.getId() > 0L);

    }

}