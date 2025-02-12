package br.com.fiap.fase4pedido.services;

import br.com.fiap.fase4pedido.model.PedidoModel;
import br.com.fiap.fase4pedido.repositories.EstoquePedidoGateway;
import br.com.fiap.fase4pedido.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final EstoquePedidoGateway estoquePedidoGateway;

    public PedidoService(PedidoRepository pedidoRepository, EstoquePedidoGateway estoquePedidoGateway) {
        this.pedidoRepository = pedidoRepository;
        this.estoquePedidoGateway = estoquePedidoGateway;
    }

   @Transactional
   public void save(PedidoModel pedidoModel) {
       //pedidoModel.getItens().forEach(i -> this.estoquePedidoGateway.removerEstoque(MessageBuilder.withPayload(new RemoverEstoqueRequest(i.getIdProduct(), i.getQuantidade())).build()));
       this.pedidoRepository.save(pedidoModel);
   }


   public List<PedidoModel> getAll() {
       return this.pedidoRepository.findAll();
   }
}


