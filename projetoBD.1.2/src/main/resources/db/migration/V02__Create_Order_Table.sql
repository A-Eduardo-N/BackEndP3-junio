CREATE TABLE tb_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    moment TIMESTAMP NOT NULL,
    status INT NOT NULL,
    client_id BIGINT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES tb_user(id)
);