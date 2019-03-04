package hu.codecool.flatium.flatmanager.model.flat;

import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private PersonType type;
    private int id;
    private static int idCounter = 0;
    private String name;
    private String phoneNumber;
    private String email;
}
