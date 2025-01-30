package backend.apiestacionamento.dto;

import lombok.Data;

@Data
public class VehicleDto {
    private Long id;
    private String Mark;
    private String Model;
    private String Color;
    private String Plate;
    private String Type;
}
