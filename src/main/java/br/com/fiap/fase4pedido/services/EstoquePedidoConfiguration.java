package br.com.fiap.fase4pedido.services;

//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.dsl.IntegrationFlow;
////import org.springframework.messaging.MessageChannel;
//

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

import static java.lang.Math.log;

public class EstoquePedidoConfiguration {

    private Object Http;

    @Bean
    public MessageChannel estoque() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow estoqueFlow() {
        return IntegrationFlow.from("estoque")
                //.handle(
                        //Http.outboundGateway("http://localhost:8081/api/remova-estoque")

                                //.httpMethod(HttpMethod.POST))
                .log().bridge()
                .get();
    }
}

