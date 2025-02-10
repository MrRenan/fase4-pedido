package br.com.fiap.fase4pedido.domain.repositories;

import br.com.fiap.fase4pedido.domain.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}