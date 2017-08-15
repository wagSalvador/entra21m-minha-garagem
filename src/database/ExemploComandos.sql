
# Seleciona todas as colunas da tebela de carros
SELECT * FROM carros;


# COUNT Retorna quantidade de Registros
SELECT COUNT(*) FROM carros;

# Passando quais paramentros 
# serão apresentados na tabela
SELECT nome, fabricante, 
		cor AS 'Cor',
		quantidade_portas AS 'Quantidade de Portas'
FROM carros;
# AS passa um "apelido" de como
# queremos mostrar o dado na tabela


# Exemplo de INSERT na Tabela de carros 
# informando as colunas desejadas
INSERT INTO carros
(id, nome, cor, fabricante, placa, chassi,
quilometragem, potencia, data_compra, esta_funcionando,
permitida_circulacao,quantidade_portas, quantidade_batidas,
ano_fabricacao,  ano_lacamento,tipo_pneu ,  renavam , descricao)

# Transmite os valores dos paramentros passados anteriormente
VALUE
(1,"Gol", "Azul Bebê", "VW", "ABC-2000",
"2asadsadRI484",29134741,85,'2017-08-07',
TRUE, FALSE, 4, 0, 2017, 2016, 175, 841516874,"TESTE");


# Passando alguns paramentros 
INSERT INTO carros
( nome, cor, fabricante,  
potencia, data_compra)

VALUE
("Palio", "Preto", "Fiat", 65, '2013-04-29');

# LIMPAR OS DADOS DA TABELA DE CARROS POR COMPLETO
TRUNCATE carros;

# Mais um Exemplo
INSERT INTO carros
( nome, cor, fabricante,  
potencia, data_compra, placa)


VALUES
("Golf", "Prata", "VW", 80, '2015-06-01', "LYQ-6225"),
("Cross Fox", "Amarelo", "VW",100, '2015-04-29', "HYQ-6200");



# Especie de IF
SELECT id, nome, quantidade_batidas FROM carros
WHERE id > 4;

SELECT id, nome, quantidade_batidas FROM carros
WHERE id >= 4;

SELECT id, nome, quantidade_batidas FROM carros
WHERE id < 4;

SELECT id, nome, quantidade_batidas FROM carros
WHERE id <= 4;

SELECT id, nome, quantidade_batidas FROM carros
WHERE id <> 4;



# Ordenar nome em ordem alfabetica 
SELECT * FROM carros ORDER  BY nome ASC;

# Ordenar em ordem alfabeitaca de tras para frente
SELECT * FROM carros ORDER  BY nome DESC;



# Agrupa as mesmas cores e conta quanta tem
SELECT cor, COUNT(cor) FROM carros
GROUP BY cor

 # Ordena pela maior quantidade
ORDER BY COUNT(cor) DESC




		