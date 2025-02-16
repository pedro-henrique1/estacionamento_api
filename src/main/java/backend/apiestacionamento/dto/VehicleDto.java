package backend.apiestacionamento.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleDto {
    private Long id;
    private String Mark;
    private String Model;
    private String Color;
    private String Plate;
    private String Type;
    private Long establishment;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
