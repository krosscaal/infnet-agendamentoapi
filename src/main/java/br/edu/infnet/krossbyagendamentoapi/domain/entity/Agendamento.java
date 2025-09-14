/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.domain.entity;

import java.time.LocalDate;

public class Agendamento {
    private String nome;
    private String sobrenome;
    private String cpf;
    private Endereco endereco;
    private Long unidadeDaVisita;
    private Long idMoradorSolicitante;
    private LocalDate dataVisita;
    private String observacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getUnidadeDaVisita() {
        return unidadeDaVisita;
    }

    public void setUnidadeDaVisita(Long unidadeDaVisita) {
        this.unidadeDaVisita = unidadeDaVisita;
    }

    public Long getIdMoradorSolicitante() {
        return idMoradorSolicitante;
    }

    public void setIdMoradorSolicitante(Long idMoradorSolicitante) {
        this.idMoradorSolicitante = idMoradorSolicitante;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
