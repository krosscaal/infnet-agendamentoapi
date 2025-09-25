/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.client;

import br.edu.infnet.krossbyagendamentoapi.domain.dto.EnderecoResponseApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(
        name = "open-cep-feign-client",
        url = "${api.opencep.url}")
public interface OpenCepFeignClient {

    @GetMapping("/{cep}")
    EnderecoResponseApi obterCep(@RequestParam("cep") String cep);
}
