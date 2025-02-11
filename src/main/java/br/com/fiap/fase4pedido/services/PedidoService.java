package br.com.fiap.fase4pedido.services;

import br.com.fiap.fase4pedido.model.Pedido;
import br.com.fiap.fase4pedido.producers.PedidoProducer;
import br.com.fiap.fase4pedido.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

      final PedidoRepository pedidoRepository;
        final PedidoProducer pedidoProducer;

      public PedidoService(PedidoRepository pedidoRepository, PedidoProducer userProducer){
          this.pedidoRepository = pedidoRepository;
          this.pedidoProducer = userProducer;

      }


      @Transactional
    public Pedido save(Pedido pedido) {
          pedido = pedidoRepository.save(pedido);
          pedidoProducer.publishMessageEmail(pedido);
          return pedido;
      }
}
