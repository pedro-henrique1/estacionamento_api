package backend.apiestacionamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public record VehicleRecord(
        Integer id,
        String mark,
        String model,
        String color,
        String plate,
        String type,
        Long establishment,
        LocalDateTime created_at,
        LocalDateTime updated_at
        ) {
}
