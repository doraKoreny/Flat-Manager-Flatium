package hu.codecool.flatium.flatmanager.api;

import hu.codecool.flatium.flatmanager.model.flat.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlatUserUpdateRequest {
    private int flatUserId;
    private Person person;
}
