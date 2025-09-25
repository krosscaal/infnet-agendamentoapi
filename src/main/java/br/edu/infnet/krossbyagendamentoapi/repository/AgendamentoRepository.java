package br.edu.infnet.krossbyagendamentoapi.repository;

import br.edu.infnet.krossbyagendamentoapi.domain.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByDataVisita(LocalDate dataAgendamento);
}
