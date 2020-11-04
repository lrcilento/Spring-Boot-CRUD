CREATE DATABASE `Frameworks` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `Aluno` (
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Trabalho` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `percentual` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Alocacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idTrabalho` int DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Alocacao_1_idx` (`idTrabalho`),
  KEY `fk_Alocacao_2_idx` (`username`),
  CONSTRAINT `fk_Alocacao_1` FOREIGN KEY (`idTrabalho`) REFERENCES `Trabalho` (`id`),
  CONSTRAINT `fk_Alocacao_2` FOREIGN KEY (`username`) REFERENCES `Aluno` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
