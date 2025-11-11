CREATE DATABASE IF NOT EXISTS dados_db;
USE dados_db;
CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100),
                          email VARCHAR(100)
);