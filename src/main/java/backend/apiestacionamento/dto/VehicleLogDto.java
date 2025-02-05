package backend.apiestacionamento.dto;


import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.Vehicle;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleLogDto {
    private Long establishment;
    private Long vehicle;
    private LocalDateTime entry_time;
    private LocalDateTime exit_time;
}
