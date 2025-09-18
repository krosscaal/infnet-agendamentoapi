package br.edu.infnet.krossbyagendamentoapi.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GeralUtilsTest {

    @Test
    @DisplayName("Teste contemNumeros Deve retornar true")
    void contemNumerosTest() {
        assertTrue(GeralUtils.contemNumeros("123456789"), "deve retornar true");
    }

    @Test
    @DisplayName("Teste contemLetras deve retornar true")
    void contemLetrasTest() {
        assertTrue(GeralUtils.contemLetras("Nome e Sobrenome"), "deve retornar true");
    }

    @Test
    @DisplayName("Teste contemLetras deve retornar true")
    void contemLetrasComUmEspacamentoTest() {
        assertTrue(GeralUtils.contemLetras("Nome e Sobrenome"), "deve retornar true");
    }

    @Test
    @DisplayName("Teste contemNumeros deve retornar false")
    void contemNumerosFalseTest() {
        assertFalse(GeralUtils.contemNumeros("715$#Sobrenome"), "deve retornar false");
    }

    @Test
    @DisplayName("Teste contemLetras deve retornar false")
    void contemLetrasFalseTest() {
        assertFalse(GeralUtils.contemLetras("Carlos Suarez6789"), "deve retornar false");
    }

    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar true")
    void verificarNumeroCpfValidoDeveRetornarTrueTest() {
        assertTrue(GeralUtils.VerificarNumeroCpfValido("91716788080"), "deve retornar true");
    }
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false")
    void verificarNumeroCpfValidoDeveRetornarFalseTest() {
        assertFalse(GeralUtils.VerificarNumeroCpfValido("91716788080"), "deve retornar false");
    }
}