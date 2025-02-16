package br.com.fiap.fase4pedido.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

    public class ItemDoPedidoTest {

        private static Validator validator;

        @BeforeAll
        public static void setupValidator() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
        }

        @Test
        public void itemDoPedidoValido() {
            // Arrange
            ItemDoPedido item = new ItemDoPedido();
            item.setQuantidade(1);
            item.setDescricao("Item de Teste");
            item.setPedido(new Pedido()); // Necessário para passar na validação de @ManyToOne

            // Act
            Set<ConstraintViolation<ItemDoPedido>> violations = validator.validate(item);

            // Assert
            assertTrue(violations.isEmpty()); // Garante que não há violações
        }

        @Test
        public void itemDoPedidoComQuantidadeNula() {
            // Arrange
            ItemDoPedido item = new ItemDoPedido();
            item.setDescricao("Item de Teste");
            item.setPedido(new Pedido()); // Necessário para passar na validação de @ManyToOne

            // Act
            Set<ConstraintViolation<ItemDoPedido>> violations = validator.validate(item);

            // Assert
            assertEquals(1, violations.size()); // Espera uma violação
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("quantidade") &&
                    v.getMessage().equals("must not be null"))); // Verifica a mensagem de erro
        }

        @Test
        public void itemDoPedidoComQuantidadeNegativa() {
            // Arrange
            ItemDoPedido item = new ItemDoPedido();
            item.setQuantidade(-1);
            item.setDescricao("Item de Teste");
            item.setPedido(new Pedido()); // Necessário para passar na validação de @ManyToOne

            // Act
            Set<ConstraintViolation<ItemDoPedido>> violations = validator.validate(item);

            // Assert
            assertEquals(1, violations.size()); // Espera uma violação
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("quantidade") &&
                    v.getMessage().equals("must be greater than 0"))); // Verifica a mensagem de erro
        }

        @Test
        public void itemDoPedidoComPedidoNulo() {
            // Arrange
            ItemDoPedido item = new ItemDoPedido();
            item.setQuantidade(1);
            item.setDescricao("Item de Teste");

            // Act
            Set<ConstraintViolation<ItemDoPedido>> violations = validator.validate(item);

            // Assert
            assertEquals(1, violations.size()); // Espera uma violação
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("pedido") &&
                    v.getMessage().equals("must not be null"))); // Verifica a mensagem de erro
        }

        // Você pode adicionar mais testes para cobrir outros cenários, se necessário
    }

