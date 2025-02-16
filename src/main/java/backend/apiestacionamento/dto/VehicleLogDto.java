package backend.apiestacionamento.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleLogDto {
    private Long id;
    private Long establishment;
    private Long vehicle;
    private LocalDateTime entry_time;
    private LocalDateTime exit_time;
}
