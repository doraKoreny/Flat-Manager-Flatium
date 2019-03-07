package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class FlatRepositoryTest {

    @Autowired
    FlatRepository flatRepository;

    @Test
    public void saveOneSimple() {
        Flat flat = Flat.builder()
                .roomNum(2)
                .squareMeter(42)
                .build();

        flatRepository.saveAndFlush(flat);
        assertThat(flatRepository.findAll().size()).isEqualTo(1);

    }

}