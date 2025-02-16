package br.com.fiap.fase4pedido.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @Test
    public void testEnumValues() {
        // Assert
        assertEquals(Status.REALIZADO.toString(), "REALIZADO");
        assertEquals(Status.CANCELADO.toString(), "CANCELADO");
        assertEquals(Status.PAGO.toString(), "PAGO");
        assertEquals(Status.NAO_AUTORIZADO.toString(), "NAO_AUTORIZADO");
        assertEquals(Status.CONFIRMADO.toString(), "CONFIRMADO");
        assertEquals(Status.PRONTO.toString(), "PRONTO");
        assertEquals(Status.SAIU_PARA_ENTREGA.toString(), "SAIU_PARA_ENTREGA");
        assertEquals(Status.ENTREGUE.toString(), "ENTREGUE");
    }
}