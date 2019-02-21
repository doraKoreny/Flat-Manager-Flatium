package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.FlatUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

class FlatStorageServiceTest {

    @Test
    void testCreatedFlatSuccessfully() {
        int roomNum = 2;
        int squareMeter = 40;

        FlatCreatorService flatCreatorService = new FlatCreatorService();
        Assert.assertNotEquals(flatCreatorService.createNewFlat(roomNum, squareMeter), null);
    }






}