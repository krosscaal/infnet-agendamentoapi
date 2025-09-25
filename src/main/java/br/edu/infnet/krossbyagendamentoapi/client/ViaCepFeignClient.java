/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.client;

import br.edu.infnet.krossbyagendamentoapi.domain.dto.EnderecoResponseApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(
        name = "via-cep-feign-client",
        url = "${api.viacep.url}")
public interface ViaCepFeignClient {

    @GetMapping("/{cep}/json/")
    EnderecoResponseApi obterCep(@PathVariable("cep") String cep);
}
