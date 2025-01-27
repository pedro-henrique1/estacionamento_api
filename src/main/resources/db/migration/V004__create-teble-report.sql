CREATE TABLE vehicle_log
(
    id               INTEGER PRIMARY KEY,
    vehicle_id       INTEGER NOT NULL,
    establishment_id INTEGER NOT NULL,
    entry_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    exit_time        TIMESTAMP,
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle (id) ON DELETE CASCADE,
    CONSTRAINT fk_establishment FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON DELETE CASCADE
);
