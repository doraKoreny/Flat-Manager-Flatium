package hu.codecool.flatium.flatmanager.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FlatCreatorServiceTest {

    @Autowired
    FlatStorageService flatStorageService;

    @Test
    public void testCreatedFlatSuccessfully() {
        int roomNum = 2;
        int squareMeter = 40;

        FlatCreatorService flatCreatorService = new FlatCreatorService();
        Assert.assertNotEquals(flatCreatorService.createNewFlat(roomNum, squareMeter), null);
    }

}