package backend.apiestacionamento.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddresseDto {
    private Long id;
    private int number;
    private String complement;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private String postal_code;
    private String country;
    private Long establishmentId;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
