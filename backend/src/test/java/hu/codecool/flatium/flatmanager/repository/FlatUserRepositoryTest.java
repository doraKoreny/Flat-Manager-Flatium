package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.Person;
import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class FlatUserRepositoryTest {

    @Autowired
    private FlatUserRepository flatUserRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void saveOneFlatUser() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .birthDate(LocalDate.of(1985, 7, 2))
                .phoneNumber("06307894561")
                .name("Kovács Ernő")
                .email("erno.kovacs@flat.com")
                .build();

        flatUserRepository.save(kovácsErnő);
        assertThat(flatUserRepository.findAll())
                .hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void nameShouldNotBeNull() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .phoneNumber("06307894561")
                .email("erno.kovacs@flat.com")
                .build();

        flatUserRepository.saveAndFlush(kovácsErnő);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void emailShouldNotBeNull() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .phoneNumber("06307894561")
                .name("Kovács Ernő")
                .build();

        flatUserRepository.saveAndFlush(kovácsErnő);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void phoneNumberShouldNotBeNull() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .email("erno.kovacs@flat.com")
                .name("Kovács Ernő")
                .build();

        flatUserRepository.saveAndFlush(kovácsErnő);
    }

    @Test
    public void transientIsNotPersistent() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .email("erno.kovacs@flat.com")
                .name("Kovács Ernő")
                .birthDate(LocalDate.of(1987, 05, 12))
                .build();

        kovácsErnő.calculateAge();
        assertThat(kovácsErnő.getAge()).isGreaterThanOrEqualTo(31);

        flatUserRepository.save(kovácsErnő);
        entityManager.clear();

        assertThat(flatUserRepository.findAll())
                .allMatch(person -> person.getAge() == 0);

    }

    @Test
    public void flatUserIsPersistentWithFlat() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .birthDate(LocalDate.of(1987, 05, 12))
                .email("erno.kovacs@flat.com")
                .name("Kovács Ernő")
                .phoneNumber("06307894561")
                .build();

        Flat flat = Flat.builder()
                .roomNum(2)
                .squareMeter(42)
                .flatUser(kovácsErnő)
                .build();

        flatRepository.save(flat);
        assertThat(flatUserRepository.findAll())
                .anyMatch(person -> person.getName().equals("Kovács Ernő"));
    }

    @Test
    public void flatUserIsDeletedWithFlat() {
        Person kovácsErnő = Person.builder()
                .type(PersonType.FLATUSER)
                .birthDate(LocalDate.of(1987, 05, 12))
                .email("erno.kovacs@flat.com")
                .name("Kovács Ernő")
                .phoneNumber("06307894561")
                .build();

        Flat flat = Flat.builder()
                .roomNum(2)
                .squareMeter(42)
                .flatUser(kovácsErnő)
                .build();

        flatRepository.save(flat);
        assertThat(flatUserRepository.findAll()).hasSize(1);

        flatRepository.deleteAll();
        assertThat(flatUserRepository.findAll()).hasSize(0);
    }
}