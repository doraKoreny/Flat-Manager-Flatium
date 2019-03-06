package hu.codecool.flatium.flatmanager.model.flat;

import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Enumerated(EnumType.STRING)
    private PersonType type;

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String phoneNumber;
    private String email;

    @OneToOne
    private Flat flat;

}
