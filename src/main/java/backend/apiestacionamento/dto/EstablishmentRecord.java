package backend.apiestacionamento.dto;

import java.time.LocalDateTime;


public record EstablishmentRecord(Long id, String name, String cnpj, String phone, int vacancies_motorcycles,
                                  int vacancies_car, LocalDateTime created_at, LocalDateTime updated_at

) {
}

