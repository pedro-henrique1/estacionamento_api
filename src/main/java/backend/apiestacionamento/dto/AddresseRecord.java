package backend.apiestacionamento.dto;

import java.time.LocalDateTime;

public record AddresseRecord(
        Integer id,
        int number,
        String complement,
        String street,
        String neighborhood,
        String city,
        String state,
        String postal_code,
        String country,
        Long establishment,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

