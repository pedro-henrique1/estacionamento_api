package backend.apiestacionamento.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EstablishmentDto {
    private Long id;
    private String name;
    private String cnpj;
    private String phone;
    private int vacancies_motorcycles;
    private int vacancies_car;

}

