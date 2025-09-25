package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static br.edu.infnet.krossbyagendamentoapi.utils.MensagemCenter.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AgendamentoServiceTest {
    @InjectMocks
    private AgendamentoService service;
    private Agendamento agendamento;


    @BeforeEach
    void setUp() {
        this.agendamento = new Agendamento();
    }

    @Test
    @DisplayName("Teste validar nome deve conter somente letras")
    void validarNomeTest() {
        agendamento.setNome("Krossby A Costa");
        assertTrue(service.validarNome(agendamento.getNome()), "ao validar nome deve retornar true");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por ser alfanumérico")
    void validarNomeDeveLancarBusinnessExceptionTest() {
        agendamento.setNome("#Krossby$");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains(SOMENTE_LETRAS), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por ser null")
    void validarNomeDeveLancarBusinnessExceptionNullTest() {
        agendamento.setNome(null);
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertEquals("nome ".concat(NAO_NULO), businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por ser vazio")
    void validarNomeDeveLancarBusinnessExceptionVazioTest() {
        agendamento.setNome("");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("nome ".concat(NAO_VAZIO)), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste validar sobrenome deve conter somente letras")
    void validarSobrenomeTest() {
        agendamento.setSobrenome("Carvalho Costa");
        assertTrue(service.validarSobrenome(agendamento.getSobrenome()), "ao validar sobrenome deve retornar true");
    }
    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException por ser alfanumérico")
    void validarSobreNomeDeveLancarBusinnessExceptionTest() {
        agendamento.setSobrenome("Carvalh$ Co$ta");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarSobrenome(agendamento.getSobrenome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains(SOMENTE_LETRAS), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException por ser null")
    void validarSobreNomeDeveLancarBusinnessNullTest() {
        agendamento.setSobrenome(null);
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarSobrenome(agendamento.getSobrenome()));
        assertEquals("sobrenome ".concat(NAO_NULO), businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException por ser vazio")
    void validarSobreNomeDeveLancarBusinnessVazioTest() {
        agendamento.setSobrenome("");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarSobrenome(agendamento.getSobrenome()));
        assertEquals("sobrenome ".concat(NAO_VAZIO), businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste validar CPF deve ser um número válido")
    void validarCpfTest() {
        agendamento.setCpf("24343829081");
        assertTrue(service.validarCpf(agendamento.getCpf()), "ao validar cpf deve retornar true");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar BusinessException por não conter 11 digitos")
    void validarCpfDeveLancarBusinnessExceptionPorNaoConter11DigitosTest() {
        agendamento.setCpf("243");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertEquals("cpf deve conter 11 digitos", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar BusinessException por não ser número válido")
    void validarCpfContem11DigitosTest() {
        agendamento.setCpf("24343829080");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("número cpf é invalido"), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar BusinessException por ser nulo")
    void validarCpfNullTest() {
        agendamento.setCpf(null);
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertEquals("cpf ".concat(NAO_NULO), businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

}