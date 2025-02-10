package br.com.fiap.fase4pedido.domain.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}