/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.service;

import br.edu.infnet.krossbyagendamentoapi.client.OpenCepFeignClient;
import br.edu.infnet.krossbyagendamentoapi.client.ViaCepFeignClient;
import br.edu.infnet.krossbyagendamentoapi.domain.dto.EnderecoResponseApi;
import br.edu.infnet.krossbyagendamentoapi.domain.entity.Endereco;
import br.edu.infnet.krossbyagendamentoapi.domain.mapper.EnderecoMapper;
import br.edu.infnet.krossbyagendamentoapi.exception.BusinessException;
import br.edu.infnet.krossbyagendamentoapi.utils.GeralUtils;
import org.springframework.stereotype.Service;

import static br.edu.infnet.krossbyagendamentoapi.utils.MensagemCenter.SOMENTE_NUMEROS;


@Service
public class EnderecoService {
    private static final String CEP_ERROR = "cep não encontrado";
    private final System.Logger logger = System.getLogger(EnderecoService.class.getName());

    private final OpenCepFeignClient openCepFeignClient;
    private final ViaCepFeignClient viaCepFeignClient;
    private final EnderecoMapper mapper;

    public EnderecoService(OpenCepFeignClient openCepFeignClient, ViaCepFeignClient viaCepFeignClient, EnderecoMapper enderecoMapper) {
        this.openCepFeignClient = openCepFeignClient;
        this.viaCepFeignClient = viaCepFeignClient;
        this.mapper = enderecoMapper;
    }

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

    public Endereco buscarCepClient(String cep) {
        this.validarCep(cep);
        EnderecoResponseApi responseApiOpenCep = null;
        EnderecoResponseApi responseApiViaCep = null;
        try {
            responseApiOpenCep = openCepFeignClient.obterCep(cep);
            responseApiViaCep = viaCepFeignClient.obterCep(cep);

        } catch (Exception e) {
            logger.log(System.Logger.Level.ERROR, String.format("%s, %s", CEP_ERROR, e.getMessage()));
        }
        if (responseApiOpenCep != null) {
            return responseApiToEndereco(responseApiOpenCep);
        }
        if (responseApiViaCep != null) {
            return responseApiToEndereco(responseApiViaCep);
        }
        return responseApiToEndereco(responseApiOpenCep);
    }

    private Endereco responseApiToEndereco(EnderecoResponseApi responseApi) {
        if (responseApi == null) {
            return new Endereco();
        }
        return mapper.toEntity(responseApi);
    }
}
