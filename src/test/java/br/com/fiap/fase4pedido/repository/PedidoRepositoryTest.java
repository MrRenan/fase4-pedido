package br.com.fiap.fase4pedido.repository;

import br.com.fiap.fase4pedido.model.ItemDoPedido;
import br.com.fiap.fase4pedido.model.Pedido;
import br.com.fiap.fase4pedido.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Configura um ambiente de teste para JPA
public class PedidoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager; // Ajuda a persistir e buscar entidades no banco de dados de teste

    @Autowired
    private PedidoRepository pedidoRepository;

    private Pedido pedido;

    @BeforeEach
    public void setup() {
        // Cria um pedido base para usar nos testes
        pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.REALIZADO);

        // Persiste o pedido no banco de dados de teste
        entityManager.persist(pedido);
        entityManager.flush(); // Garante que a persistência seja imediata
    }

    @Test
    public void atualizaStatus_DeveAtualizarOStatusDoPedido() {
        // Arrange
        Status novoStatus = Status.PAGO;

        // Act
        pedidoRepository.atualizaStatus(novoStatus, pedido);
        entityManager.flush(); // Garante que a atualização seja refletida

        // Assert
        Pedido pedidoAtualizado = entityManager.find(Pedido.class, pedido.getId()); // Busca o pedido atualizado do banco
        assertNotNull(pedidoAtualizado);
        assertEquals(novoStatus, pedidoAtualizado.getStatus());
    }

    @Test
    public void porIdComItens_DeveRetornarPedidoComItens() {
        // Arrange
        ItemDoPedido item1 = new ItemDoPedido();
        item1.setDescricao("Item 1");
        item1.setQuantidade(2);
        item1.setPedido(pedido);

        ItemDoPedido item2 = new ItemDoPedido();
        item2.setDescricao("Item 2");
        item2.setQuantidade(1);
        item2.setPedido(pedido);

        entityManager.persist(item1);
        entityManager.persist(item2);
        entityManager.flush();

        pedido.setItens(Arrays.asList(item1, item2)); // Importante: atualizar o pedido com os itens criados
        entityManager.persist(pedido);
        entityManager.flush();


        // Act
        Pedido pedidoComItens = pedidoRepository.porIdComItens(pedido.getId());

        // Assert
        assertNotNull(pedidoComItens);
        assertNotNull(pedidoComItens.getItens());
        assertEquals(2, pedidoComItens.getItens().size());
        assertTrue(pedidoComItens.getItens().stream().anyMatch(item -> item.getDescricao().equals("Item 1")));
        assertTrue(pedidoComItens.getItens().stream().anyMatch(item -> item.getDescricao().equals("Item 2")));
    }

    @Test
    public void porIdComItens_DeveRetornarPedidoSemItensSeNaoHouverItens() {
        // Act
        Pedido pedidoComItens = pedidoRepository.porIdComItens(pedido.getId());

        // Assert
        assertNotNull(pedidoComItens);
        assertNotNull(pedidoComItens.getItens());
        assertTrue(pedidoComItens.getItens().isEmpty());
    }

    @Test
    public void testeHerancaJpaRepository(){
        Pedido pedidoSalvo = pedidoRepository.save(new Pedido());
        assertNotNull(pedidoSalvo);

        Pedido pedidoEncontrado = pedidoRepository.findById(pedidoSalvo.getId()).get();
        assertNotNull(pedidoEncontrado);
    }
}