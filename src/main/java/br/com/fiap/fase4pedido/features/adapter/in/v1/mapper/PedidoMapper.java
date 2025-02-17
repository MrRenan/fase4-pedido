package br.com.fiap.fase4pedido.features.adapter.in.v1.mapper;

import br.com.fiap.fase4pedido.features.domain.entity.Pedido;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoRequest;
import br.com.fiap.fase4pedido.infra.restapi.v1.model.PedidoResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterInMapperPedidoMapperImpl")
)
public interface PedidoMapper {
    PedidoResponse paraPedidoResponse(Pedido pedido);

    Pedido paraPedido(PedidoRequest pedidoRequest);
}
