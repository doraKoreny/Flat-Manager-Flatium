package hu.codecool.flatium.flatmanager.model.flat.bills;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bill {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private BillType billType;

    private double price;
    private boolean paid = false;

    @ManyToOne
    private Flat flat;

}
