package br.com.fiap.fase4pedido.infra.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoPublisher {

    private final StreamBridge streamBridge;


    public void enviarPedidoPago(String pedidoId) {
        boolean enviado = streamBridge.send("pedidoPago-out-0", pedidoId);
        if (enviado) {
            System.out.println("Pedido enviado com sucesso: " + pedidoId);
        } else {
            System.out.println("Falha ao enviar o pedido: " + pedidoId);
        }
    }
}