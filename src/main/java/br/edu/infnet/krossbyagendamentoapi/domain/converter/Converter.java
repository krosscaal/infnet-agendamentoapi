package br.edu.infnet.krossbyagendamentoapi.domain.converter;

public interface Converter<E, D> {
    D toDTO(E entity);
    E toEntity(D dto);
}
