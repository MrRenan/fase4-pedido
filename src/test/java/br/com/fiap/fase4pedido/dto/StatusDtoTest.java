package br.com.fiap.fase4pedido.dto;

import br.com.fiap.fase4pedido.model.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusDtoTest {

    @Test
    public void testStatusDtoGettersAndSetters() {
        // Arrange
        StatusDto statusDto = new StatusDto();
        Status status = Status.PAGO;

        // Act
        statusDto.setStatus(status);

        // Assert
        assertEquals(status, statusDto.getStatus());
    }

    @Test
    public void testStatusDtoConstructor() {
        // Arrange
        Status status = Status.REALIZADO;

        // Act
        StatusDto statusDto = new StatusDto(status);

        // Assert
        assertEquals(status, statusDto.getStatus());
    }
}