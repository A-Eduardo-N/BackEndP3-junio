CREATE TABLE tb_order_item (
    order_id BIGINT,  -- FK para tb_order
    product_id BIGINT, -- FK para tb_product
    quantity INT,
    price DOUBLE,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES tb_order(id),
    FOREIGN KEY (product_id) REFERENCES tb_product(id)
);