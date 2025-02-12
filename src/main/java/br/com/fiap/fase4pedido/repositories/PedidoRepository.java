package br.com.fiap.fase4pedido.repositories;




import br.com.fiap.fase4pedido.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {

}