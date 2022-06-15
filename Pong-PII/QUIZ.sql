CREATE DATABASE dbquiz;
USE dbquiz;	

CREATE TABLE LOGIN (
ID INT NOT NULL PRIMARY KEY,
Nome VARCHAR(30) NOT NULL,
Senha VARCHAR(20) NOT NULL
);

CREATE TABLE Quiz (
idPerguntas INT PRIMARY KEY,
Perguntas VARCHAR (100),
Alternativa1 VARCHAR (250),
Alternativa2 VARCHAR (250),
Alternativa3 VARCHAR (250),
Resposta INT (1));

CREATE TABLE RANKING (
ID INT NOT NULL PRIMARY KEY,
NumeroDepontos INT,
ID_LOGIN INT
);
ALTER TABLE RANKING ADD CONSTRAINT FOREIGN KEY (ID_LOGIN) REFERENCES LOGIN (ID);

INSERT INTO Quiz (idPerguntas, Perguntas, Alternativa1, Alternativa2, Alternativa3, Resposta) VALUES 
(1, 'Quais são os elementos de um fluxograma?', 'Entrada, processamento, saída', 'saída, processamento, entrada', 'entrada, saída, processamento', 1),
(2, 'Explique a funcionalide da variável Int', 'Representar um número inteiro', 'Representar uma letra', 'Representar uma frase', 1),
(3, 'Explique a funcionalidade da variável double', 'Representar valores decimais', 'Representar valores ordinais', 'Representar uma frase', 1),
(4, 'Explique o que é IF', 'O IF condiciona um comando a uma condição qualquer, executando-o apenas se ela for verdadeira', 'O IF condiciona um comando específico, executando-o apenas se ele for verdadeiro', 'O IF condiciona um comando a uma condição qualquer, execuntando-o apenas se ela for falsa', 3),
(5, 'Explique o que é else', 'O else é um caminho alternativo do if, ele vai ser executado quando a condição for falsa', 'O else é um comando a uma condição qualquer, executando-o apenas se ela for falsa', 'O else é um caminho alternaativo do double, que vai ser executado quando a condição for falsa', 1),
(6, 'Qual a diferença entre String e int', 'String é usado para representar palavras, já a variável int é usada para representar números inteiros', 'String é usado para representar palavras, já a variavel int representa números decimais', 'String é usado para representar condições apenas verdadeiras, e a variável int representa apenas condições falsas', 1),
(7, 'Qual tipo de dado é usado para criar uma variável que armazena texto?', 'Double', 'Integer', 'String', 3),
(8, 'O que significa a sigla JDK?', 'Java Development Kit', 'Java Database Kit', 'Java D', 1),
(9, 'O que significa a sigla JVM?', 'Java', 'Java Virtual Machine', 'Java Runtime Edition', 2),
(10, 'O que significa a sigla JRE', 'Java Runtime Edition', 'Java Virtual Machine', 'Java', 1),
(11, 'Como deve ser escrita uma classe em Java?', 'Caixa baixa', 'Caixa alta', 'Não existem regras', 2),
(12, 'Qual é a sintaxe correta para saída ser: "Hello World" em Java?', 'System.out.println("Hello World")', 'print ("Hello World")', 'WriteLine ("Hello World")', 1),
(13, 'Java é a abreviação de JavaScript?', 'Verdadeiro', 'Falso','****', 2),
(14, 'Como inserir comentários no java?', '//', '#', '/*', 1),
(15, 'Como criar uma variável com o valor numérico 5?', 'int x = 5', 'int = 5', 'x = 5', 1),
(16, 'Como criar uma variável com o valor flutuante?', 'float x = 2.8f;', 'x = 2.8f;', 'int x = 2.8f;', 1),
(17, 'O que é um loop', 'Um segmento de código que pode ser executado apenas uma vez', 'Um segmento de código que irá ser executado infinitas vezes', 'Um segmento de código que irá ser executado com uma determinada quantidade de vezes', 3),
(18, 'Qual o tamanho de um Char em java?', '16 bits', '7 bits', '4 bits', 1),
(19, 'Qual a palavra usada em Java para criar um objeto?', 'New', 'This', 'Sync', 1);

INSERT INTO LOGIN VALUES (1, 'admin', 'admin'), (2, 'teste_player', ''),  (3, 'teste_player2', '');

INSERT INTO RANKING VALUES (1, 0, 1), (2, 0, 2), (3, 0, 3);