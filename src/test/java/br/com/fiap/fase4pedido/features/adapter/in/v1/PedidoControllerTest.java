package br.com.fiap.fase4pedido.features.adapter.in.v1;

import br.com.fiap.fase4pedido.features.adapter.in.v1.mapper.PedidoMapper;
import br.com.fiap.fase4pedido.features.application.usecase.PedidoUseCase;
import br.com.fiap.fase4pedido.features.domain.entity.Cliente;
import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.features.domain.entity.Produto;
import br.com.fiap.fase4pedido.features.domain.entity.Status;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PedidoController.class) // Configura o teste para o PedidoController
public class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injeta o MockMvc para simular requisições HTTP

    @Autowired
    private ObjectMapper objectMapper; // Injeta o ObjectMapper para serializar/deserializar JSON

    @MockBean
    private PedidoUseCase pedidoUseCase; // Mock do PedidoUseCase

    @MockBean
    @Qualifier("pedidoInputMapper") // Especifica qual implementação do PedidoMapper deve ser mockada
    private PedidoMapper pedidoMapper;

    @Test
    public void testCriarPedido() throws Exception {
        // Arrange
        PedidoRequest pedidoRequest = new PedidoRequest(
                "1",
                Collections.singletonList(new PedidoRequest.ProdutoRequest("1", 2))
        );

        Pedido pedido = new Pedido(
                new Cliente("1", "João"),
                Collections.singletonList(new Produto("1", "Produto A", BigDecimal.valueOf(100), 2)),
                LocalDate.now(),
                Status.CRIADO,
                BigDecimal.valueOf(200)
        );

        PedidoResponse pedidoResponse = new PedidoResponse(
                new PedidoResponse.Cliente("1", "João"),
                Collections.singletonList(new PedidoResponse.Produto("1", "Produto A", BigDecimal.valueOf(100), 2)),
                LocalDate.now(),
                br.com.fiap.fase4pedido.infra.restapi.v1.model.Status.CRIADO,
                BigDecimal.valueOf(200)
        );

        when(pedidoUseCase.criarPedido(any(Pedido.class))).thenReturn(pedido); // Configura o mock do PedidoUseCase
        when(pedidoMapper.paraPedidoResponse(any(Pedido.class))).thenReturn(pedidoResponse); // Configura o mock do PedidoMapper

        // Act & Assert
        mockMvc.perform(post("/v1/pedido") // Simula uma requisição POST
                        .contentType(MediaType.APPLICATION_JSON) // Define o tipo de conteúdo como JSON
                        .content(objectMapper.writeValueAsString(pedidoRequest))) // Converte o PedidoRequest para JSON
                .andExpect(status().isCreated()) // Verifica se o status da resposta é 201 (Created)
                .andExpect(jsonPath("$.cliente.id").value("1")) // Verifica o ID do cliente na resposta
                .andExpect(jsonPath("$.cliente.nome").value("João")) // Verifica o nome do cliente na resposta
                .andExpect(jsonPath("$.produtos[0].id").value("1")) // Verifica o ID do produto na resposta
                .andExpect(jsonPath("$.produtos[0].nomeProduto").value("Produto A")) // Verifica o nome do produto na resposta
                .andExpect(jsonPath("$.produtos[0].preco").value(100)) // Verifica o preço do produto na resposta
                .andExpect(jsonPath("$.produtos[0].quantidade").value(2)) // Verifica a quantidade do produto na resposta
                .andExpect(jsonPath("$.dataCriacao").isNotEmpty()) // Verifica se a data de criação está presente
                .andExpect(jsonPath("$.status").value("CRIADO")) // Verifica o status do pedido na resposta
                .andExpect(jsonPath("$.total").value(200)); // Verifica o total do pedido na resposta
    }
}