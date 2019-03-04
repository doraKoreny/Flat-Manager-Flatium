package hu.codecool.flatium.flatmanager.api;

import hu.codecool.flatium.flatmanager.model.flat.Flat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlatUpdateRequest {
    private int id;
    private Flat flat;
}
