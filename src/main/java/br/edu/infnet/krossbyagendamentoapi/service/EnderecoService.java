/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import br.edu.infnet.krossbyagendamentoapi.utils.GeralUtils;
import org.springframework.stereotype.Service;

import static br.edu.infnet.krossbyagendamentoapi.utils.MensagemCenter.SOMENTE_NUMEROS;


@Service
public class EnderecoService {
    public Boolean validarCep(String cep) {
        if (cep == null ) {
            throw new BusinessException("cep invalido, deve conter 8 digitos");
        }
        if (cep.length() != 8) {
            throw new BusinessException("cep deve conter 8 digitos");
        }
        if (GeralUtils.contemNumeros(cep).equals(Boolean.FALSE)) {
            throw new BusinessException("cep ".concat(SOMENTE_NUMEROS));
        }
        return true;
    }
}
