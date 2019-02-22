package hu.codecool.flatium.flatmanager;

import hu.codecool.flatium.flatmanager.flat.Flat;
import hu.codecool.flatium.flatmanager.service.FlatCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlatmanagerApplicationTests {

    @Autowired
    private FlatCreatorService flatCreatorService;

    @Test
    public void contextLoads() {

        Flat newFlat = flatCreatorService.createNewFlat(2, 42);
        assertThat(newFlat.getRoomNum()).isEqualTo(2);
    }

}
