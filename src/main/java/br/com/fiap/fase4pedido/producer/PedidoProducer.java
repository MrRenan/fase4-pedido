//package br.com.fiap.fase4pedido.producer;
//
//import br.com.fiap.fase4pedido.dtos.EmailDto;
//import br.com.fiap.fase4pedido.model.PedidoModel;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//
//public class PedidoProducer {
//
//    final RabbitTemplate rabbitTemplate;
//
//    public PedidoProducer(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Value(value = "${broker.queue.email.name}")
//    private String routingKey;
//
//    public void publishMessageEmail(PedidoModel pedidoModel) {
//        var emailDto = new EmailDto();
//        emailDto.setPedidoId(pedidoModel.getPedidoId());
//        emailDto.setEmailTo(pedidoModel.getEmail());
//        emailDto.setSubject("Cadastro realizado com sucesso!");
//        emailDto.setText(pedidoModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");
//
//        rabbitTemplate.convertAndSend("", routingKey, emailDto);
//    }
//
//}
//
