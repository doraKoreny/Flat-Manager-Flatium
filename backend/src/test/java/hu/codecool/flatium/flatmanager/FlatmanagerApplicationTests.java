package hu.codecool.flatium.flatmanager;

import hu.codecool.flatium.flatmanager.auth.AuthConfig;
import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.service.FlatCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = AuthConfig.class)
public class FlatmanagerApplicationTests {

    @Autowired
    private FlatCreatorService flatCreatorService;

    @Test
    public void contextLoads() {

        Flat newFlat = flatCreatorService.createNewFlat(2, 42);
        assertThat(newFlat.getRoomNum()).isEqualTo(2);
    }

}
