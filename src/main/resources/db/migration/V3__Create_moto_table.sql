CREATE TABLE moto (
    id BIGSERIAL PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(7) NOT NULL,
    status_moto VARCHAR(20) NOT NULL,
    usuario_id BIGINT REFERENCES usuario(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE moto
ADD CONSTRAINT moto_placa_length CHECK (LENGTH(placa) = 7),
ADD CONSTRAINT moto_placa_pattern CHECK (placa ~ '^[A-Z0-9]{7}$'),
ADD CONSTRAINT moto_status_check CHECK (status_moto IN ('DISPONIVEL', 'PARADA', 'QUEBRADA', 'ALUGADA'));

-- Índice único para placa
CREATE UNIQUE INDEX moto_placa_unique ON moto (placa);