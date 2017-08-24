    # Apagar o banco de dados
    DROP DATABASE IF EXISTS minha_garagem;

    # Criar o Banco de Dados
    CREATE DATABASE IF NOT EXISTS minha_garagem;

    # SELECIONANDO O BANCO DE DADOS
    USE minha_garagem;

    DROP TABLE IF EXISTS carros;

    CREATE TABLE IF NOT EXISTS carros (
        id INTEGER PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(150),
        cor VARCHAR(100),
        fabricante VARCHAR(225),
        placa VARCHAR(8),
        chassi VARCHAR(50),
        quilometragem FLOAT,
        potencia FLOAT,
        data_compra DATE,
        esta_funcionando BOOLEAN,
        permitida_circulacao BOOLEAN,
        quantidade_portas TINYINT,
        quantidade_batidas TINYINT,
        ano_fabricacao SMALLINT,
        ano_lancamento SMALLINT,
        tipo_pneu SMALLINT,
        renavam INT,
        descricao TEXT
    );

    DROP TABLE IF EXISTS categorias;

    CREATE TABLE IF NOT EXISTS categorias(
        id INTEGER PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(150) UNIQUE NOT NULL #não permite vazio e é único,
        descricao TEXT,
        ativo BOOLEAN DEFAULT FALSE #vai conter o valor false caso não for passado nada  no insert
    );

    INSERT INTO categoria (nome) VALUE('Executiva');
    INSERT INTO categoria (nome,descricao) VALUE('Média','Texto 2');
