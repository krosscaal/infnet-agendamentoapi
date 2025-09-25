/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import br.edu.infnet.krossbyagendamentoapi.repository.AgendamentoRepository;
import br.edu.infnet.krossbyagendamentoapi.utils.GeralUtils;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static br.edu.infnet.krossbyagendamentoapi.utils.MensagemCenter.*;

@Service
public class AgendamentoService {
    private final System.Logger log = System.getLogger(AgendamentoService.class.getName());
    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public Boolean validarNome(String nome) {
        if (nome == null) {
            throw new BusinessException("nome ".concat(NAO_NULO));
        }
        if (nome.trim().isEmpty()) {
            throw new BusinessException("nome ".concat(NAO_VAZIO));
        }
        if (GeralUtils.contemLetras(nome).equals(Boolean.FALSE)) {
            throw new BusinessException(SOMENTE_LETRAS);
        }
        return true;
    }
    public Boolean validarSobrenome(String sobrenome) {
        if (sobrenome == null) {
            throw new BusinessException("sobrenome ".concat(NAO_NULO));
        }
        if (sobrenome.trim().isEmpty()) {
            throw new BusinessException("sobrenome ".concat(NAO_VAZIO));
        }
        if (GeralUtils.contemLetras(sobrenome).equals(Boolean.FALSE)) {
            throw new BusinessException(SOMENTE_LETRAS);
        }
        return true;
    }
    public Boolean validarCpf(String cpf) {
        if (cpf == null) {
            throw new BusinessException("cpf ".concat(NAO_NULO));
        }
        if (cpf.length() != 11) {
            throw  new BusinessException("cpf deve conter 11 digitos");
        }
        if (GeralUtils.verificarNumeroCpfValido(cpf).equals(Boolean.FALSE)) {
            throw new BusinessException("número cpf é invalido");
        }
        return GeralUtils.verificarNumeroCpfValido(cpf);
    }
    public Agendamento incluir(Agendamento agendamento) {
        this.validarNome(agendamento.getNome());
        this.validarSobrenome(agendamento.getSobrenome());
        this.validarCpf(agendamento.getCpf());
        return repository.save(agendamento);
    }
    public List<Agendamento> buscarAgendamentosPorData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataBusca = LocalDate.parse(data, formatter);
        return repository.findByDataVisita(dataBusca);
    }
}
