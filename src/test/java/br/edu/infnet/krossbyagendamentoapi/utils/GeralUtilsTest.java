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
        assertTrue(GeralUtils.verificarNumeroCpfValido("52998224725"), "deve retornar true");
    }
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false")
    void verificarNumeroCpfValidoDeveRetornarFalseTest() {
        assertFalse(GeralUtils.verificarNumeroCpfValido("52998224722"), "deve retornar false");
    }
    @Test
    @DisplayName("Teste verificar número CPF deve retornar false quando cpf for uma seguencia repetida do mesmo digito como 11111111111")
    void verificarNumeroCpfDeveRetornarFalseQuandoCpfForSequenciaRepetidaTest() {
        assertFalse(GeralUtils.verificarNumeroCpfValido("11111111111"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("22222222222"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("33333333333"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("44444444444"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("55555555555"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("66666666666"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("77777777777"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("88888888888"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("99999999999"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("00000000000"), "deve retornar false");
    }
}