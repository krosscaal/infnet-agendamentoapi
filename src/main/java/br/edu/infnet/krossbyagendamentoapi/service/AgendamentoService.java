/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import br.edu.infnet.krossbyagendamentoapi.utils.GeralUtils;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    public Boolean validarNome(String nome) {
        if (nome == null) {
            throw new BusinessException("nome não pode ser nulo");
        }
        if (nome.trim().isEmpty()) {
            throw new BusinessException("nome não pode ser vazio");
        }
        if (GeralUtils.contemLetras(nome).equals(Boolean.FALSE)) {
            throw new BusinessException("deve conter apenas letras");
        }
        return true;
    }
    public Boolean validarSobrenome(String sobrenome) {
        if (sobrenome == null) {
            throw new BusinessException("sobrenome não pode ser nulo");
        }
        if (sobrenome.trim().isEmpty()) {
            throw new BusinessException("sobrenome não pode ser vazio");
        }
        if (GeralUtils.contemLetras(sobrenome).equals(Boolean.FALSE)) {
            throw new BusinessException("deve conter apenas letras");
        }
        return true;
    }
    public Boolean validarCpf(String cpf) {
        if (cpf == null) {
            throw new BusinessException("cpf não pode ser nulo");
        }
        if (cpf.length() != 11) {
            throw  new BusinessException("deve conter 11 digitos");
        }
        if (GeralUtils.verificarNumeroCpfValido(cpf).equals(Boolean.FALSE)) {
            throw new BusinessException("número cpf é invalido");
        }
        return GeralUtils.verificarNumeroCpfValido(cpf);
    }
}
