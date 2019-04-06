package hu.codecool.flatium.flatmanager.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignToBuildingRequest {
    private int buildingId;
    private int flatId;
}
