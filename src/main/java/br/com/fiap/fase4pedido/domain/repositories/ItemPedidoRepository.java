package br.com.fiap.fase4pedido.domain.repositories;

import br.com.fiap.fase4pedido.domain.entities.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {
}
