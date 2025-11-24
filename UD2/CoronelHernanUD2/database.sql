drop database if exists companhia;
CREATE DATABASE IF NOT EXISTS companhia;
USE companhia;


-- Tabela de persoas empregadas
CREATE TABLE persoas_empregadas (
    id_persoa INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    nivel INT NOT NULL
);

-- Tabela de proxectos
CREATE TABLE proxectos (
    id_proxecto INT PRIMARY KEY AUTO_INCREMENT,
    denominacion VARCHAR(255) NOT NULL,
    nivel_minimo INT NOT NULL,
    estado ENUM('creado', 'iniciado', 'finalizado') DEFAULT 'creado',
    orzamento DECIMAL(15,2) NOT NULL CHECK (orzamento > 0)
);

-- Tabela de relación entre persoas e proxectos N:N
CREATE TABLE persoas_proxectos (
    id_persoa INT,
    id_proxecto INT,
    PRIMARY KEY (id_persoa, id_proxecto),
    FOREIGN KEY (id_persoa) REFERENCES companhia.persoas_empregadas(id_persoa)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_proxecto) REFERENCES companhia.proxectos(id_proxecto)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

--- Verificación do resultado

describe companhia.persoas_empregadas;
describe companhia.proxectos;
describe companhia.persoas_proxectos;

-- Anexouse outro arquivo con SQL para inserción dos datos de proba
--- SQL para inserción de datos de exemplo
--- Emprega os que consideres necesario
-- SQL para inserción de datos de exemplo
-- Emprega os que consideres necesario


-- Inserir persoas empregadas
INSERT INTO persoas_empregadas (email, nivel) VALUES
('maria.garcia@companhia.gal', 3),
('carlos.rodriguez@companhia.gal', 1),
('ana.lopez@companhia.gal', 4),
('pedro.martinez@companhia.gal', 1),
('laura.santos@companhia.gal', 2),
('david.fernandez@companhia.gal', 2),
('sara.gomez@companhia.gal', 2),
('javier.vazquez@companhia.gal', 4);

-- Inserir proxectos

INSERT INTO proxectos (denominacion, nivel_minimo, estado, orzamento) VALUES
('Sistema de Xestión Interna', 3, 'iniciado', 50000.00),
('App Móbil Cliente', 2, 'creado', 25000.00),
('Migración á Nube', 4, 'iniciado', 75000.00),
('Portal Web Corporativo', 2, 'finalizado', 30000.00),
('Análise de Datos de Vendas', 3, 'iniciado', 45000.00);

-- Inserir asignacións de persoas a proxectos
-- Modifica os valores dos id's en función dos que haxa nas túas tabelas anteriore

INSERT INTO persoas_proxectos (id_persoa, id_proxecto) VALUES
(1, 1),  -- María no Sistema de Xestión Interna
(1, 3),  -- María na Migración á Nube
(2, 2),  -- Carlos na App Móbil Cliente
(2, 4),  -- Carlos no Portal Web Corporativo
(3, 3),  -- Ana na Migración á Nube
(3, 5),  -- Ana na Análise de Datos
(4, 2),  -- Pedro na App Móbil Cliente
(5, 1),  -- Laura no Sistema de Xestión Interna
(5, 5),  -- Laura na Análise de Datos
(6, 4),  -- David no Portal Web Corporativo
(7, 1),  -- Sara no Sistema de Xestión Interna
(7, 3),  -- Sara na Migración á Nube
(8, 3),  -- Javier na Migración á Nube
(8, 5);  -- Javier na Análise de Datos

-- Comprobacións
select * from companhia.persoas_empregadas;
select * from companhia.proxectos;

-- Consulta de proba entre as tabelas
select pe.email, pe.nivel, p.denominacion, p.nivel_minimo, p.estado, p.orzamento from companhia.persoas_empregadas pe
inner join companhia.persoas_proxectos pp
inner join companhia.proxectos p
on pp.id_persoa = pe.id_persoa and pp.id_proxecto = p.id_proxecto
order by p.id_proxecto, pe.email;