package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class EnderecoServiceTest {
    private EnderecoService service = new EnderecoService();

    @Test
    @DisplayName("Teste validar CEP")
    void validarCepTest() {
        assertTrue(service.validarCep("83025335"), "ao validar cep deve retornar true");
    }
    @Test
    @DisplayName("Teste validar CEP deve lançar Business Exception deve conter somente números")
    void validarCepDeveLançarExceptionSomenteNumerosTest() {
        assertThrows(BusinessException.class, () -> service.validarCep("8302533A"));
    }
    @Test
    @DisplayName("Teste validar CEP deve lançar Business Exception deve conter 8 digitos")
    void validarCepDeveLançarExceptionDeveConter8Test() {
        assertThrows(BusinessException.class, () -> service.validarCep("8302533A"));
    }
}