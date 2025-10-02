CREATE TABLE garagem (
    id BIGSERIAL PRIMARY KEY,
    responsavel VARCHAR(50) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    usuario_id BIGINT REFERENCES usuario(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE garagem
ADD CONSTRAINT garagem_endereco_min_length
CHECK (LENGTH(endereco) >= 10);