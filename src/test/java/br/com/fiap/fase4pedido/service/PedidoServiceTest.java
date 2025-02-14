//package br.com.fiap.fase4pedido.service;
//
//
//import br.com.fiap.fase4pedido.dto.PedidoDto;
//import br.com.fiap.fase4pedido.dto.StatusDto;
//import br.com.fiap.fase4pedido.model.Pedido;
//import br.com.fiap.fase4pedido.model.Status;
//import br.com.fiap.fase4pedido.repository.PedidoRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class PedidoServiceTest {
//
//    @InjectMocks
//    private PedidoService pedidoService;
//
//    @Mock
//    private PedidoRepository pedidoRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    private Pedido pedido;
//    private PedidoDto pedidoDto;
//    private StatusDto statusDto;
//
//    @BeforeEach
//    public void setup() {
//        // Inicialize seus objetos de teste aqui
//        pedido = new Pedido();
//        pedido.setId(1L);
//
//        pedidoDto = new PedidoDto();
//        pedidoDto.setId(1L);
//
//        statusDto = new StatusDto();
//        //statusDto.setStatus(Status.PAGO);
//
//        // Configure o ModelMapper para retornar o que você espera
//        when(modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
//        when(modelMapper.map(pedido, PedidoDto.class)).thenReturn(pedidoDto);
//    }
//
//    @Test
//    void obterTodos_retornaListaDePedidos() {
//        // Arrange
//        when(pedidoRepository.findAll()).thenReturn(Arrays.asList(pedido));
//
//        // Act
//        List<PedidoDto> pedidos = pedidoService.obterTodos();
//
//        // Assert
//        assertThat(pedidos).isNotEmpty().hasSize(1);
//        assertThat(pedidos.get(0).getId()).isEqualTo(1L);
//    }
//
//    @Test
//    void obterPorId_retornaPedidoDto_quandoPedidoExiste() {
//        // Arrange
//        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
//
//        // Act
//        PedidoDto pedidoDtoRetornado = pedidoService.obterPorId(1L);
//
//        // Assert
//        assertThat(pedidoDtoRetornado).isNotNull();
//        assertThat(pedidoDtoRetornado.getId()).isEqualTo(1L);
//    }
//
//    @Test
//    void obterPorId_lancaExcecao_quandoPedidoNaoExiste() {
//        // Arrange
//        when(pedidoRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        assertThatThrownBy(() -> pedidoService.obterPorId(1L))
//                .isInstanceOf(EntityNotFoundException.class);
//    }
//
//    @Test
//    void criarPedido_salvaPedidoComSucesso() {
//        // Arrange
//        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
//
//        // Act
//        PedidoDto pedidoDtoCriado = pedidoService.criarPedido(pedidoDto);
//
//        // Assert
//        assertThat(pedidoDtoCriado).isNotNull();
//        verify(pedidoRepository).save(any(Pedido.class));
//    }
//
//    @Test
//    void atualizaStatus_atualizaStatusComSucesso() {
//        // Arrange
//        when(pedidoRepository.porIdComItens(1L)).thenReturn(pedido);
//
//        // Act
//        PedidoDto pedidoDtoAtualizado = pedidoService.atualizaStatus(1L, statusDto);
//
//        // Assert
//        assertThat(pedidoDtoAtualizado).isNotNull();
//        verify(pedidoRepository).atualizaStatus(statusDto.getStatus(), pedido);
//    }
//
//    @Test
//    void atualizaStatus_lancaExcecao_quandoPedidoNaoExiste() {
//        // Arrange
//        when(pedidoRepository.porIdComItens(1L)).thenReturn(null);
//
//        // Act & Assert
//        assertThatThrownBy(() -> pedidoService.atualizaStatus(1L, statusDto))
//                .isInstanceOf(EntityNotFoundException.class);
//    }
//
//    @Test
//    void aprovaPagamentoPedido_atualizaStatusParaPago_quandoPedidoExiste() {
//        // Arrange
//        when(pedidoRepository.porIdComItens(1L)).thenReturn(pedido);
//
//        // Act
//        pedidoService.aprovaPagamentoPedido(1L);
//
//        // Assert
//        assertThat(pedido.getStatus()).isEqualTo(Status.PAGO);
//    }
//
//    @Test
//    void aprovaPagamentoPedido_lancaExcecao_quandoPedidoNaoExiste() {
//        // Arrange
//        when(pedidoRepository.porIdComItens(1L)).thenReturn(null);
//
//        // Act & Assert
//        assertThatThrownBy(() -> pedidoService.aprovaPagamentoPedido(1L))
//                .isInstanceOf(EntityNotFoundException.class);
//    }
//}
