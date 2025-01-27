CREATE TABLE establishment
(
    id                    INTEGER PRIMARY KEY ,
    name                  VARCHAR(100) NOT NULL,
    cnpj                  VARCHAR(18)  NOT NULL UNIQUE,
    phone                 VARCHAR(15)  NOT NULL,
    vacancies_motorcycles INTEGER      NOT NULL,
    vacancies_car         INTEGER      NOT NULL,
    created_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



