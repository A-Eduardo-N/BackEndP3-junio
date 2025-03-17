CREATE TABLE tb_payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    moment TIMESTAMP NOT NULL,
    order_id BIGINT UNIQUE NOT NULL,
    FOREIGN KEY (order_id) REFERENCES tb_order(id)
);