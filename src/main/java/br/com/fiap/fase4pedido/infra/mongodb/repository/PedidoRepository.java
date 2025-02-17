package br.com.fiap.fase4pedido.infra.mongodb.repository;

import br.com.fiap.fase4pedido.infra.mongodb.document.PedidoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<PedidoDocument, String> {
}
