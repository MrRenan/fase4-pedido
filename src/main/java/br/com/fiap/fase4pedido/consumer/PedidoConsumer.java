package br.com.fiap.fase4pedido.consumer;

import br.com.fiap.fase4pedido.dtos.PedidoRecordDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class PedidoConsumer {

    @RabbitListener(queues = "${fila.pedido}")
    public void receberPedido(PedidoRecordDTO pedidoRecordDTO) {
        System.out.println("Mensagem recebida da fila: " + pedidoRecordDTO);
        // Processar o pedido
    }
}
