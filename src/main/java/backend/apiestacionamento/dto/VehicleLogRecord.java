package backend.apiestacionamento.dto;



import java.time.LocalDateTime;

public record VehicleLogRecord(
        Long id,
        Long establishment,
        Long vehicle,
        LocalDateTime entryTime,
        LocalDateTime exitTime
        ) {
}
