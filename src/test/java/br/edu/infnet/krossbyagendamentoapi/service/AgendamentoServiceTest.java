package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AgendamentoServiceTest {

    private AgendamentoService service = new AgendamentoService();
    private Agendamento agendamento;


    @BeforeEach
    void setUp() {
        this.agendamento = new Agendamento();
    }

    @Test
    @DisplayName("Teste validar nome deve conter somente letras")
    void validarNomeTest() {
        agendamento.setNome("Krossby");
        assertTrue(service.validarNome(agendamento.getNome()), "ao validar nome deve retornar true");
    }
    @Test
    @DisplayName("Teste ao validar nome deve lançar BusinessException")
    void validarNomeDeveLancarBusinnessExceptionTest() {
        agendamento.setNome("#Krossby$");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().contains("deve conter apenas letras"), "deve retornar mensagem correta");
    }

    @Test
    @DisplayName("Teste validar sobrenome deve conter somente letras")
    void validarSobrenomeTest() {
        agendamento.setSobrenome("Carvalho Costa");
        assertTrue(service.validarSobrenome(agendamento.getSobrenome()), "ao validar sobrenome deve retornar true");
    }
    @Test
    @DisplayName("Teste ao validar sobrenome deve lançar BusinesException")
    void validarSobreNomeDeveLancarBusinnessExceptionTest() {
        agendamento.setSobrenome("Carvalh$ Co$ta");
        assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarNome(agendamento.getNome()));
        assertTrue(businessException.getMessage().contains("deve conter apenas letras"), "deve retornar mensagem correta");
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
        assertEquals("deve conter 11 digitos", businessException.getMessage(), "deve retornar mensagem correta");
    }
    @Test
    @DisplayName("Teste validar CPF deve lançar Business Exception por não ser número válido")
    void validarCpfContem11DigitosTest() {
        agendamento.setCpf("24343829080");
        assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()), "deve lançar BusinessException");
        BusinessException businessException = assertThrows(BusinessException.class, () -> service.validarCpf(agendamento.getCpf()));
        assertEquals("número CPF é invalido", businessException.getMessage(), "deve retornar mensagem correta");
    }

}