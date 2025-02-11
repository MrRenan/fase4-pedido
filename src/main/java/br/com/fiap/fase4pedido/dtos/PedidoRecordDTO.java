package br.com.fiap.fase4pedido.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PedidoRecordDTO(@NotBlank String name,
                              @NotBlank @Email String email) {
}
