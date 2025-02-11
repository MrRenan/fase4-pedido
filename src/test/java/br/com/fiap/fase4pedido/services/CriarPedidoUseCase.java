//package br.com.fiap.fase4pedido.application.usecases;
//
//import br.com.fiap.fase4pedido.domain.entities.PedidoEntity;
//import br.com.fiap.fase4pedido.domain.repositories.PedidoRepository;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.when;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
//
//public class CriarPedidoUseCase {
//
//    @Mock
//    private PedidoRepository pedidoRepository;
//
//    @InjectMocks
//    private CriarPedidoUseCase criarPedidoUseCase;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);// Inicializa os mocks
//    }
//
//    @Test
//
//        public void setCriarPedidoUseCase() {
//        // 1. Preparação (Arrange)
//        PedidoEntity pedidoEntityasercriado = new PedidoEntity();
//        pedidoEntityasercriado.setClienteEntity("ExemploCliente");
//        pedidoEntityasercriado.setValorTotal(100.0);
//
//
//        PedidoEntity pedidoCriado = new PedidoEntity();
//        pedidoEntityCriado.setId(1L); // ID gerado pelo banco
//        pedidoEntityCriado.setClienteEntity("Cliente Exemplo");
//        pedidoEntityCriado.setValorTotal(100.0);
//
//        when(pedidoRepository.save(pedidoASerCriado)).thenReturn(pedidoCriado);
//
//        // 2. Ação (Act)
//        PedidoEntity resultado = criarPedidoUseCase.criarPedidoUseCase(pedidoASerCriado);
//
//        // 3. Verificação (Assert)
//        assertEquals(1L, resultado.getId());
//        assertEquals("Cliente Exemplo", resultado.getClienteEntity());
//        assertEquals(100.0, resultado.getValorTotal());
//    }


