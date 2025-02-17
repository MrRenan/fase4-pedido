package br.com.fiap.fase4pedido;

import br.com.fiap.fase4pedido.features.adapter.in.v1.PedidoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PedidoApplicationTests {

    @Autowired
    private PedidoController pedidoController; // Injeta o controller para verificar se o contexto foi carregado

    @Test
    void contextLoads() {
        assertNotNull(pedidoController); // Verifica se o controller foi carregado corretamente
    }
}