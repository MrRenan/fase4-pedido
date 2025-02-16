package br.com.fiap.fase4pedido.service;

import br.com.fiap.fase4pedido.dto.PedidoDto;
import br.com.fiap.fase4pedido.dto.StatusDto;
import br.com.fiap.fase4pedido.model.Pedido;
import br.com.fiap.fase4pedido.model.Status;
import br.com.fiap.fase4pedido.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PedidoService service;

    @Test
    public void obterTodos_DeveRetornarListaDePedidosDto() {
        // Arrange
        Pedido pedido1 = new Pedido();
        pedido1.setId(1L);
        pedido1.setDataHora(LocalDateTime.now());
        pedido1.setStatus(Status.REALIZADO);

        Pedido pedido2 = new Pedido();
        pedido2.setId(2L);
        pedido2.setDataHora(LocalDateTime.now());
        pedido2.setStatus(Status.PAGO);

        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

        PedidoDto pedidoDto1 = new PedidoDto();
        pedidoDto1.setId(1L);
        pedidoDto1.setStatus(Status.REALIZADO);

        PedidoDto pedidoDto2 = new PedidoDto();
        pedidoDto2.setId(2L);
        pedidoDto2.setStatus(Status.PAGO);

        when(repository.findAll()).thenReturn(pedidos);
        when(modelMapper.map(pedido1, PedidoDto.class)).thenReturn(pedidoDto1);
        when(modelMapper.map(pedido2, PedidoDto.class)).thenReturn(pedidoDto2);

        // Act
        List<PedidoDto> resultado = service.obterTodos();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals(pedidoDto1.getId(), resultado.get(0).getId());
        assertEquals(pedidoDto2.getStatus(), resultado.get(1).getStatus());
    }

    @Test
    public void obterPorId_DeveRetornarPedidoDtoQuandoEncontrado() {
        // Arrange
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.REALIZADO);

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(id);
        pedidoDto.setStatus(Status.REALIZADO);

        when(repository.findById(id)).thenReturn(Optional.of(pedido));
        when(modelMapper.map(pedido, PedidoDto.class)).thenReturn(pedidoDto);

        // Act
        PedidoDto resultado = service.obterPorId(id);

        // Assert
        assertEquals(id, resultado.getId());
        assertEquals(Status.REALIZADO, resultado.getStatus());
    }

    @Test
    public void obterPorId_DeveLancarEntityNotFoundExceptionQuandoNaoEncontrado() {
        // Arrange
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> service.obterPorId(id));
    }

    @Test
    public void criarPedido_DeveSalvarPedidoERetornarPedidoDto() {
        // Arrange
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(1L);
        pedidoDto.setStatus(Status.REALIZADO);

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setStatus(Status.REALIZADO);
        pedido.setDataHora(LocalDateTime.now());

        when(modelMapper.map(pedidoDto, Pedido.class)).thenReturn(pedido);
        when(repository.save(any(Pedido.class))).thenReturn(pedido); // Captura qualquer Pedido para simular o save
        when(modelMapper.map(pedido, PedidoDto.class)).thenReturn(pedidoDto);

        // Act
        PedidoDto resultado = service.criarPedido(pedidoDto);

        // Assert
        assertNotNull(resultado);
        assertEquals(pedidoDto.getId(), resultado.getId());
        verify(repository, times(1)).save(any(Pedido.class)); // Verifica se o método save foi chamado uma vez
    }

    @Test
    public void atualizaStatus_DeveAtualizarStatusERetornarPedidoDto() {
        // Arrange
        Long id = 1L;
        StatusDto statusDto = new StatusDto();
        statusDto.setStatus(Status.PAGO);

        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setStatus(Status.REALIZADO);
        pedido.setDataHora(LocalDateTime.now());

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(id);
        pedidoDto.setStatus(Status.PAGO);


        when(repository.porIdComItens(id)).thenReturn(pedido);
        when(modelMapper.map(pedido, PedidoDto.class)).thenReturn(pedidoDto);

        // Act
        PedidoDto resultado = service.atualizaStatus(id, statusDto);

        // Assert
        assertEquals(Status.PAGO, resultado.getStatus());
        verify(repository, times(1)).atualizaStatus(Status.PAGO, pedido); // Verificando se o método atualizaStatus foi chamado
    }

    @Test
    public void atualizaStatus_DeveLancarEntityNotFoundExceptionQuandoPedidoNaoEncontrado() {
        // Arrange
        Long id = 1L;
        StatusDto statusDto = new StatusDto();
        statusDto.setStatus(Status.PAGO);

        when(repository.porIdComItens(id)).thenReturn(null);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> service.atualizaStatus(id, statusDto));
    }

    @Test
    public void aprovaPagamentoPedido_DeveAtualizarStatusParaPago() {
        // Arrange
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setStatus(Status.REALIZADO);
        pedido.setDataHora(LocalDateTime.now());

        when(repository.porIdComItens(id)).thenReturn(pedido);

        // Act
        service.aprovaPagamentoPedido(id);

        // Assert
        assertEquals(Status.PAGO, pedido.getStatus());
        verify(repository, times(1)).atualizaStatus(Status.PAGO, pedido);
    }

    @Test
    public void aprovaPagamentoPedido_DeveLancarEntityNotFoundExceptionQuandoPedidoNaoEncontrado() {
        // Arrange
        Long id = 1L;
        when(repository.porIdComItens(id)).thenReturn(null);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> service.aprovaPagamentoPedido(id));
    }
}