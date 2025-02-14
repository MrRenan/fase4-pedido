CREATE TABLE item_do_pedido (
                                id BIGSERIAL PRIMARY KEY,
                                descricao VARCHAR(255),  -- Removido DEFAULT NULL, pois é o padrão
                                quantidade INT NOT NULL,
                                pedido_id BIGINT NOT NULL,
                                FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);