CREATE TABLE addresses
(
    id           INTEGER PRIMARY KEY,
    establishment_id INTEGER NOT NULL UNIQUE,
    street       VARCHAR(100) NOT NULL,
    number       VARCHAR(10)  NOT NULL,
    complement   VARCHAR(50),
    neighborhood VARCHAR(50)  NOT NULL,
    city         VARCHAR(50)  NOT NULL,
    state        CHAR(2)      NOT NULL,
    postal_code  VARCHAR(10)  NOT NULL,
    country      VARCHAR(50) DEFAULT 'Brasil',
    created_at   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_establishment FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON DELETE CASCADE

);