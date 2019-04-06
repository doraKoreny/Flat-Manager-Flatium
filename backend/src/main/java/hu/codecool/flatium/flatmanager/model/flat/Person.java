package hu.codecool.flatium.flatmanager.model.flat;

import hu.codecool.flatium.flatmanager.model.flat.contacts.PersonType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private PersonType type;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @OneToOne
    private Flat flat;

    @Transient
    private long age;

    public void calculateAge() {
        if (birthDate != null) {
            age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        }
    }
}
