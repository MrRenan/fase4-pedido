package br.com.fiap.fase4pedido.producers;

import br.com.fiap.fase4pedido.dtos.EmailDto;
import br.com.fiap.fase4pedido.model.Pedido;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {
    final RabbitTemplate rabbitTemplate;

    public PedidoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(Pedido pedido) {
        var emailDto = new EmailDto();
        emailDto.setPedidoId(pedido.getPedidoId());
        emailDto.setEmailTo(pedido.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(pedido.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}

