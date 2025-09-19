package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class EnderecoServiceTest {
    private final EnderecoService service = new EnderecoService();

    @Test
    @DisplayName("Teste validar CEP deve retornar true")
    void validarCepTest() {
        assertTrue(service.validarCep("83025335"), "ao validar cep deve retornar true");
    }

    @Test
    @DisplayName("Teste validar CEP deve lançar BusinessException deve conter somente números")
    void validarCepDeveLançarExceptionSomenteNumerosTest() {
        assertThrows(BusinessException.class, () -> service.validarCep("8302533A"), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCep("8302533A"));
        assertEquals("cep deve conter somente números", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste validar CEP deve lançar BusinessException quando não contem 8 digitos")
    void validarCepDeveLançarExceptionDeveConter8digitosTest() {
        assertThrows(BusinessException.class, () -> service.validarCep("8302"), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCep("8302"));
        assertEquals("cep deve conter 8 digitos", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste validar CEP deve lançar BusinessException quando for null")
    void validarCepDeveLançarExceptionNullTest() {
        assertThrows(BusinessException.class, () -> service.validarCep(null), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCep(null));
        assertEquals("cep invalido, deve conter 8 digitos", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
}