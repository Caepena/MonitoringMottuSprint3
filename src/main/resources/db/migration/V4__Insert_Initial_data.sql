
INSERT INTO usuario (name, email, avatar_url) VALUES
('João Silva', 'joao.silva@email.com', 'https://avatar.com/joao.jpg'),
('Maria Santos', 'maria.santos@email.com', 'https://avatar.com/maria.jpg'),
('Pedro Oliveira', 'pedro.oliveira@email.com', 'https://avatar.com/pedro.jpg');


INSERT INTO garagem (responsavel, endereco, usuario_id) VALUES
('Carlos Andrade', 'Rua das Flores, 123 - Centro - São Paulo/SP', 1),
('Ana Costa', 'Avenida Brasil, 456 - Jardins - Rio de Janeiro/RJ', 2),
('Roberto Lima', 'Praça da Liberdade, 789 - Savassi - Belo Horizonte/MG', 3);


INSERT INTO moto (modelo, placa, status_moto, usuario_id) VALUES
('Honda CG 160', 'ABC1D23', 'DISPONIVEL', 1),
('Yamaha Factor 150', 'DEF4G56', 'ALUGADA', 2),
('Honda Biz 125', 'GHI7J89', 'QUEBRADA', 1),
('Yamaha NMax', 'JKL0M12', 'PARADA', 3),
('Honda PCX', 'MNO3P45', 'DISPONIVEL', 2);