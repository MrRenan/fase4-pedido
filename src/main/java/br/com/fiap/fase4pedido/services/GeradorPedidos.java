package br.com.fiap.fase4pedido.services;

import br.com.fiap.fase4pedido.model.PedidoModel;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GeradorPedidos {

    private final PedidoService pedidoService;

    public GeradorPedidos(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

//    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
//    public void crieFakePedido() {
//        final List<AbstractReadWriteAccess.Item> itens = List.of(new AbstractReadWriteAccess.Item(1L, BigDecimal.valueOf(2L)));
//        this.pedidoService.save(new PedidoModel(UUID.randomUUID(), UUID.randomUUID(), itens));
    }


