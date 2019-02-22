package hu.codecool.flatium.flatmanager.service;

import hu.codecool.flatium.flatmanager.flat.Flat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlatStorageServiceTest {


    @Test
    public void testAddFlatToList() {
        FlatStorageService flatStorageService = new FlatStorageService();

        Flat flat = new Flat();
        int flatListSize = flatStorageService.getFlats().size();

        FlatCreatorService flatCreatorServiceMock = Mockito.mock(FlatCreatorService.class);
        when(flatCreatorServiceMock.createNewFlat(2,42))
                .thenReturn(flat);

        flatStorageService.addFlat();
        int listSize = flatStorageService.getFlats().size();
        Assert.assertEquals(flatListSize + 1, listSize );
    }

}