/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.loader;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.domain.entity.Endereco;
import br.edu.infnet.krossbyagendamentoapi.service.AgendamentoService;
import br.edu.infnet.krossbyagendamentoapi.service.EnderecoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;



@Component
public class AgendamentoLoader implements ApplicationRunner {
    private final AgendamentoService agendamentoService;
    private final EnderecoService enderecoService;
    Logger log = Logger.getLogger(AgendamentoLoader.class.getName());

    public AgendamentoLoader(AgendamentoService agendamentoService, EnderecoService enderecoService) {
        this.agendamentoService = agendamentoService;
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (FileReader arquivoFonte = new FileReader("agendamento.txt")) {
            BufferedReader lerArquivo = new BufferedReader(arquivoFonte);
            String linha = lerArquivo.readLine();
            String[] campos = null;

            while (linha != null) {
                campos = linha.split(";");

                Agendamento agendamento = criarAgendamento(campos);
                String cepConsulta = campos[3];

                Endereco enderecoResponseApi = enderecoService.buscarCepClient(cepConsulta);
                agendamento.setEndereco(enderecoResponseApi);

                this.salvarAgendamento(agendamento);
                linha = lerArquivo.readLine();
            }
        } catch (Exception e) {
            log.log(Level.WARNING, "Erro ao ler arquivo fonte agendamento.txt", e);
        }

    }
    private Agendamento criarAgendamento(String[] campos) {
        String nome = campos[0];
        String sobrenome = campos[1];
        String cpf = campos[2];
        Long unidadeDaVisita = Long.valueOf(campos[4]);
        Long idMoradorSolicitante = Long.valueOf(campos[5]);
        LocalDate dataVisita = LocalDate.parse(campos[6]);
        String observacao = campos[7];

        Agendamento agendamento = new Agendamento();
        agendamento.setNome(nome);
        agendamento.setSobrenome(sobrenome);
        agendamento.setCpf(cpf);
        agendamento.setUnidadeDaVisita(unidadeDaVisita);
        agendamento.setIdMoradorSolicitante(idMoradorSolicitante);
        agendamento.setDataVisita(dataVisita);
        agendamento.setObservacao(observacao);

        return agendamento;
    }
    private void salvarAgendamento(Agendamento agendamento) {
        try {
            Agendamento agendamentoPersisted = this.agendamentoService.incluir(agendamento);
            log.log(Level.INFO, "Agendamento incluido: {0}", agendamentoPersisted);
        } catch (Exception e) {
            log.log(Level.WARNING, "Erro na persistencia", e);
        }
    }
}
