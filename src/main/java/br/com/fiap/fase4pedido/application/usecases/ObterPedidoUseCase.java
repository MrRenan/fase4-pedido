package br.com.fiap.fase4pedido.application.usecases;

import br.com.fiap.fase4pedido.domain.entities.PedidoEntity;
import br.com.fiap.fase4pedido.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ObterPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoEntity executar(Long id) {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(id);
        return pedido.orElse(null);
    }
}
