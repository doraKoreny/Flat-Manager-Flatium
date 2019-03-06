package hu.codecool.flatium.flatmanager.repository;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import hu.codecool.flatium.flatmanager.model.flat.bills.Bill;
import hu.codecool.flatium.flatmanager.model.flat.bills.BillType;
import org.h2.store.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Test
    public void saveOneBill() {
        Bill bill = Bill.builder()
                .billType(BillType.ELECTRICITY)
                .price(8000)
                .build();

        billRepository.save(bill);
        List<Bill> bills = billRepository.findAll();
        assertThat(bills).hasSize(1);
    }


    @Test
    public void billIsPersistentWithFlat() {
        Bill bill = Bill.builder()
                .billType(BillType.ELECTRICITY)
                .price(8000)
                .build();

        Flat flat = Flat.builder()
                .roomNum(2)
                .squareMeter(42)
                .bill(bill)
                .build();

        flatRepository.save(flat);
        assertThat(billRepository.findAll())
                .hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void billTypeShouldBeNotNull() {
        Bill bill = Bill.builder()
                .price(15000)
                .build();

        Flat flat = Flat.builder()
                .squareMeter(42)
                .roomNum(2)
                .bill(bill)
                .build();

        flatRepository.save(flat);
    }
}