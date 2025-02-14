//import br.com.fiap.fase4pedido.repository.PedidoRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@ActiveProfiles("test") // Garante que está usando um banco de dados de teste
//class PedidoRepositoryTest {
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    private Pedido pedido;
//    private Status statusInicial;
//
//    @BeforeEach
//    void setUp() {
//        // Cria um pedido para usar nos testes
//        statusInicial = Status.PENDENTE;
//        pedido = new Pedido();
//        pedido.setStatus(statusInicial);
//
//        // Cria alguns itens para o pedido
//        ItemPedido item1 = new ItemPedido();
//        item1.setQuantidade(2);
//        item1.setPrecoUnitario(BigDecimal.TEN);
//        item1.setPedido(pedido); // Define a relação
//        Produto produto1 = new Produto("Produto 1", BigDecimal.TEN);
//        item1.setProduto(produto1);
//
//        ItemPedido item2 = new ItemPedido();
//        item2.setQuantidade(1);
//        item2.setPrecoUnitario(BigDecimal.valueOf(25));
//        item2.setPedido(pedido); // Define a relação
//        Produto produto2 = new Produto("Produto 2", BigDecimal.valueOf(25));
//        item2.setProduto(produto2);
//
//        List<ItemPedido> itens = new ArrayList<>();
//        itens.add(item1);
//        itens.add(item2);
//        pedido.setItens(itens);
//
//        entityManager.persist(produto1);
//        entityManager.persist(produto2);
//        pedido = entityManager.persist(pedido);
//        entityManager.flush();  // Força a persistência antes dos testes
//    }
//
//
//    @Test
//    void atualizaStatus_deveAtualizarOStatusDoPedido() {
//        // Arrange
//        Status novoStatus = Status.ENTREGUE;
//
//        // Act
//        pedidoRepository.atualizaStatus(novoStatus, pedido);
//        entityManager.flush(); // Sincroniza as mudanças com o banco de dados
//        entityManager.clear(); // Limpa o cache para forçar a busca no banco
//
//        // Assert
//        Optional<Pedido> pedidoAtualizadoOptional = pedidoRepository.findById(pedido.getId());
//        assertTrue(pedidoAtualizadoOptional.isPresent());
//
//        Pedido pedidoAtualizado = pedidoAtualizadoOptional.get();
//        assertEquals(novoStatus, pedidoAtualizado.getStatus());
//    }
//
//    @Test
//    void porIdComItens_deveRetornarPedidoComItensCarregados() {
//        // Act
//        Pedido pedidoComItens = pedidoRepository.porIdComItens(pedido.getId());
//
//        // Assert
//        assertNotNull(pedidoComItens);
//        assertEquals(pedido.getId(), pedidoComItens.getId());
//        assertNotNull(pedidoComItens.getItens());
//        assertEquals(2, pedidoComItens.getItens().size()); // Verifica se os itens foram carregados
//
//        // Verificando se a consulta eager join fetch realmente funciona:
//        pedidoComItens.getItens().forEach(item -> {
//            assertNotNull(item.getProduto()); // Garante que o produto de cada item também foi carregado
//        });
//    }
//
//    @Test
//    void porIdComItens_deveRetornarNullSePedidoNaoExiste() {
//        // Arrange
//        Long idInexistente = 9999L;
//
//        // Act
//        Pedido pedidoComItens = pedidoRepository.porIdComItens(idInexistente);
//
//        // Assert
//        assertNull(pedidoComItens);
//    }
//
//    @Test
//    void findById_deveRetornarPedidoSemItensCarregados() {
//        // Act
//        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedido.getId());
//
//        // Assert
//        assertTrue(pedidoOptional.isPresent());
//        Pedido pedidoRetornado = pedidoOptional.get();
//        assertNotNull(pedidoRetornado);
//        assertEquals(pedido.getId(), pedidoRetornado.getId());
//        assertNotNull(pedidoRetornado.getStatus());
//        assertEquals(statusInicial, pedidoRetornado.getStatus());
//
//        // Garante que os itens NÃO foram carregados (lazy loading)
//        assertNull(pedidoRetornado.getItens()); // Verificando o lazy loading
//    }
//
//    // Classes de apoio (simulando as entidades)
//    public enum Status {
//        PENDENTE,
//        PROCESSANDO,
//        ENVIADO,
//        ENTREGUE,
//        CANCELADO
//    }
//
//    public static class Pedido {
//        private Long id;
//        private Status status;
//        private List<ItemPedido> itens;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public Status getStatus() {
//            return status;
//        }
//
//        public void setStatus(Status status) {
//            this.status = status;
//        }
//
//        public List<ItemPedido> getItens() {
//            return itens;
//        }
//
//        public void setItens(List<ItemPedido> itens) {
//            this.itens = itens;
//        }
//    }
//
//    public static class ItemPedido {
//        private Long id;
//        private Integer quantidade;
//        private BigDecimal precoUnitario;
//        private Pedido pedido;
//        private Produto produto;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public Integer getQuantidade() {
//            return quantidade;
//        }
//
//        public void setQuantidade(Integer quantidade) {
//            this.quantidade = quantidade;
//        }
//
//        public BigDecimal getPrecoUnitario() {
//            return precoUnitario;
//        }
//
//        public void setPrecoUnitario(BigDecimal precoUnitario) {
//            this.precoUnitario = precoUnitario;
//        }
//
//        public Pedido getPedido() {
//            return pedido;
//        }
//
//        public void setPedido(Pedido pedido) {
//            this.pedido = pedido;
//        }
//
//        public Produto getProduto() {
//            return produto;
//        }
//
//        public void setProduto(Produto produto) {
//            this.produto = produto;
//        }
//    }
//
//    public static class Produto {
//        private Long id;
//        private String nome;
//        private BigDecimal preco;
//
//        public Produto(String nome, BigDecimal preco) {
//            this.nome = nome;
//            this.preco = preco;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        public BigDecimal getPreco() {
//            return preco;
//        }
//
//        public void setPreco(BigDecimal preco) {
//            this.preco = preco;
//        }
//    }
//}