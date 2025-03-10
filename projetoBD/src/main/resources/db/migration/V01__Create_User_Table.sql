CREATE TABLE tb_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    birth_date DATE,
    password VARCHAR(255) NOT NULL
);