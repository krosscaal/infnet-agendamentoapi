package br.edu.infnet.krossbyagendamentoapi.resource;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import br.edu.infnet.krossbyagendamentoapi.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<List<Agendamento>> buscarAgendamentosPorData(@RequestParam(value = "data") String data) {
        return ResponseEntity.ok().body(service.buscarAgendamentosPorData(data));
    }
}
