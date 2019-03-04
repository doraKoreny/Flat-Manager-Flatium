package hu.codecool.flatium.flatmanager.model.flat.bills;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    private BillType billType;
    private double price;
    private boolean paid = false;

}
