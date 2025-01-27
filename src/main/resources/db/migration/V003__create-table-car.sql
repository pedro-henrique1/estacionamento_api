CREATE TABLE vehicle
(
    id               INTEGER PRIMARY KEY NOT NULL,
    Mark             VARCHAR(50)         NOT NULL,
    Model            VARCHAR(100)        NOT NULL,
    Color            VARCHAR(50)         NOT NULL,
    Plate            VARCHAR(10)         NOT NULL,
    Type             VARCHAR(50)         NOT NULL,
    establishment_id INTEGER             NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_establishment FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON DELETE CASCADE

)