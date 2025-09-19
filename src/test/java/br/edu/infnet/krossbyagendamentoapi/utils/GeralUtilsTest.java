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
    @DisplayName("Teste contemNumeros Deve retornar false quando paramentro e null")
    void contemNumerosNullTest() {
        assertFalse(GeralUtils.contemNumeros(null), "deve retornar false");
    }
    @Test
    @DisplayName("Teste contemNumeros Deve retornar false quando parametro for vazio")
    void contemNumerosVazioTest() {
        assertFalse(GeralUtils.contemNumeros(""), "deve retornar false");
    }

    @Test
    @DisplayName("Teste contemLetras deve retornar true")
    void contemLetrasTest() {
        assertTrue(GeralUtils.contemLetras("Nome e Sobrenome"), "deve retornar true");
    }
    @Test
    @DisplayName("Teste contemLetras deve retornar false quando paramentro é null")
    void contemLetrasDeveretornarFalseQuandoforNullTest() {
        assertFalse(GeralUtils.contemLetras(null), "deve retornar false");
    }
    @Test
    @DisplayName("Teste contemLetras deve retornar false quando paramentro é vazio")
    void contemLetrasDeveretornarFalseQuandoforVazioTest() {
        assertFalse(GeralUtils.contemLetras(""), "deve retornar false");
    }

    @Test
    @DisplayName("Teste contemNumeros deve retornar false quando paramentro for alfanumérico")
    void contemNumerosFalseTest() {
        assertFalse(GeralUtils.contemNumeros("715$#Sobrenome"), "deve retornar false");
    }

    @Test
    @DisplayName("Teste contemLetras com alfanumericos deve retornar false")
    void contemLetrasFalseTest() {
        assertFalse(GeralUtils.contemLetras("Carlos Suarez6789"), "deve retornar false");
    }

    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar true")
    void verificarNumeroCpfValidoDeveRetornarTrueTest() {
        assertTrue(GeralUtils.verificarNumeroCpfValido("52998224725"), "deve retornar true");
    }
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false quando primeiro digito verificador for errado")
    void verificarNumeroCpfValidoDeveRetornarFalseQuandoPrimeiroDigitoVerificadorTest() {
        assertFalse(GeralUtils.verificarNumeroCpfValido("52998224715"), "deve retornar false");
    }
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false quando segundo digito verificador for errado")
    void verificarNumeroCpfValidoDeveRetornarFalseQuandoSegundoDigitoVerificadorTest() {
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
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false quando for null")
    void verificarNumeroCpfValidoNullTest() {
        assertFalse(GeralUtils.verificarNumeroCpfValido(null), "deve retornar false");
    }
    @Test
    @DisplayName("Teste verificar número CPF valido deve retornar false quando não contem 11 digitos")
    void verificarNumeroCpfValidoSem11DigitosTest() {
        assertFalse(GeralUtils.verificarNumeroCpfValido(""), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("715"), "deve retornar false");
        assertFalse(GeralUtils.verificarNumeroCpfValido("52998224722555"), "deve retornar false");
    }
}