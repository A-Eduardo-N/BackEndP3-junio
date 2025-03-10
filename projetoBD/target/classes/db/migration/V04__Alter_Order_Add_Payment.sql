ALTER TABLE tb_order
ADD COLUMN payment_id BIGINT;

ALTER TABLE tb_order
ADD CONSTRAINT fk_order_payment
FOREIGN KEY (payment_id) REFERENCES tb_payment(id);