package br.com.fiap.fase4pedido.application.usecases;

import br.com.fiap.fase4pedido.domain.entities.ItemPedidoEntity;
import br.com.fiap.fase4pedido.domain.repositories.ItemPedidoRepository;
import br.com.fiap.fase4pedido.interfaceadapters.dtos.ItemPedidoRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarItemPedidoUseCase {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoEntity executar(ItemPedidoRecordDTO itemPedidoDTO) {
        ItemPedidoEntity itemPedido = new ItemPedidoEntity();
        //TODO: Setar os valores do DTO para a entidade
        return itemPedidoRepository.save(itemPedido);
    }

}
