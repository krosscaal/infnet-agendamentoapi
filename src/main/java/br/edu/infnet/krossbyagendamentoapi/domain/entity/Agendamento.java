/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_agendamento")
public class Agendamento extends EntidadeBase{
    private String nome;
    private String sobrenome;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Long unidadeDaVisita;
    private Long idMoradorSolicitante;
    private LocalDate dataVisita;
    private String observacao;


    @Override
    public String toString() {
        return "Agendamento{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco.toString() +
                ", unidadeDaVisita=" + unidadeDaVisita +
                ", idMoradorSolicitante=" + idMoradorSolicitante +
                ", dataVisita=" + dataVisita +
                ", observacao='" + observacao + '\'' +
                '}';
    }

}
