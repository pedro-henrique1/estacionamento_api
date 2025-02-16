package backend.apiestacionamento.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EstablishmentDto {
    private Long id;
    private String name;
    private String cnpj;
    private String phone;
    private int vacancies_motorcycles;
    private int vacancies_car;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}

