package br.com.fiap.fase4pedido.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.UUID;

public record PedidoRecordDTO(@NotBlank Long Id, @NotBlank Long ClienteId,
                              @NotBlank String item) {
}
