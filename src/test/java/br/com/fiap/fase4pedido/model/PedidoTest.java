package br.com.fiap.fase4pedido.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {


        private static Validator validator;

        @BeforeAll
        public static void setupValidator() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
        }

        @Test
        public void pedidoValido() {
            // Arrange
            Pedido pedido = new Pedido();
            pedido.setDataHora(LocalDateTime.now());
            pedido.setStatus(Status.REALIZADO);

            // Act
            Set<ConstraintViolation<Pedido>> violations = validator.validate(pedido);

            // Assert
            assertTrue(violations.isEmpty());
        }

        @Test
        public void pedidoComDataHoraNula() {
            // Arrange
            Pedido pedido = new Pedido();
            pedido.setStatus(Status.REALIZADO);

            // Act
            Set<ConstraintViolation<Pedido>> violations = validator.validate(pedido);

            // Assert
            assertEquals(1, violations.size());
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("dataHora") &&
                    v.getMessage().equals("must not be null")));
        }

        @Test
        public void pedidoComStatusNulo() {
            // Arrange
            Pedido pedido = new Pedido();
            pedido.setDataHora(LocalDateTime.now());

            // Act
            Set<ConstraintViolation<Pedido>> violations = validator.validate(pedido);

            // Assert
            assertEquals(1, violations.size());
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("status") &&
                    v.getMessage().equals("must not be null")));
        }

        @Test
        public void testItensListInitialization() {
            // Arrange & Act
            Pedido pedido = new Pedido();

            // Assert
            assertNotNull(pedido.getItens());  // Garante que a lista 'itens' foi inicializada
            assertTrue(pedido.getItens().isEmpty()); // Garante que a lista 'itens' está vazia inicialmente
        }
    }

