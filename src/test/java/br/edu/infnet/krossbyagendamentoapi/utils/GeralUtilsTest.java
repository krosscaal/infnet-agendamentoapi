package br.edu.infnet.krossbyagendamentoapi.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GeralUtilsTest {

    @Test
    @DisplayName("Teste contemNumeros Deve retornar true")
    void contemNumerosTest() {
        assertTrue(GeralUtils.contemNumeros("123456789"));
    }

    @Test
    @DisplayName("Teste contemLetras deve retornar true")
    void contemLetrasTest() {
        assertTrue(GeralUtils.contemLetras("Nome e Sobrenome"));
    }
    @Test
    @DisplayName("Teste contemNumeros deve retornar false")
    void contemNumerosFalseTest() {
        assertFalse(GeralUtils.contemNumeros("Nome e Sobrenome"));
    }
    @Test
    @DisplayName("Teste contemLetras deve retornar false")
    void contemLetrasFalseTest() {
        assertFalse(GeralUtils.contemLetras("123456789"));
    }
}