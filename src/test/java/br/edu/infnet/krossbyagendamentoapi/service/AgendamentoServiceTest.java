package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AgendamentoServiceTest {

    private final AgendamentoService service = new AgendamentoService();
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
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("deve conter apenas letras"), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por conter mais de um espaçamento entre letras")
    void validarNomeDeveLancarBusinnessExceptionMaisdeUmEspacamentoTest() {
        agendamento.setNome("Krossby       A    C");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertEquals("somente é permitido um espaçamento para separação entre letras", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por ser null")
    void validarNomeDeveLancarBusinnessExceptionNullTest() {
        agendamento.setNome(null);
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertEquals("nome não pode ser nulo", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException por ser vazio")
    void validarNomeDeveLancarBusinnessExceptionVazioTest() {
        agendamento.setNome("");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("nome não pode ser vazio"), "deve retornar mensagem correta");
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
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("deve conter apenas letras"), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException com mais de um espaçamento para separação entre letras")
    void validarSobreNomeDeveLancarBusinnessExceptionEspacamentoTest() {
        agendamento.setSobrenome("Carvalho    Costa    A");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("somente é permitido um espaçamento para separação entre letras"), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException por ser null")
    void validarSobreNomeDeveLancarBusinnessNullTest() {
        agendamento.setSobrenome(null);
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertEquals("sobrenome não pode ser nulo", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException por ser vazio")
    void validarSobreNomeDeveLancarBusinnessVazioTest() {
        agendamento.setSobrenome("");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertEquals("sobrenome não pode ser vazio", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
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
        assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertEquals("deve conter 11 digitos", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar BusinessException por não ser número válido")
    void validarCpfContem11DigitosTest() {
        agendamento.setCpf("24343829080");
        assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertTrue(businessException.getMessage().toLowerCase(Locale.ROOT).contains("número CPF é invalido"), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar BusinessException por ser nulo")
    void validarCpfNullTest() {
        agendamento.setCpf(null);
        assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertEquals("cpf não pode ser nulo", businessException.getMessage().toLowerCase(Locale.ROOT), "deve retornar mensagem correta");
    }

}