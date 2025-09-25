package br.edu.infnet.krossbyagendamentoapi.domain.mapper;

import br.edu.infnet.krossbyagendamentoapi.domain.converter.AbstractConverter;
import br.edu.infnet.krossbyagendamentoapi.domain.dto.EnderecoResponseApi;
import br.edu.infnet.krossbyagendamentoapi.domain.entity.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper extends AbstractConverter<Endereco, EnderecoResponseApi> {
    public EnderecoMapper(ModelMapper modelMapper) {
        super(modelMapper, Endereco.class, EnderecoResponseApi.class);
        configureMapping();
    }

    @Override
    protected void configureMapping() {
        /*DTO -> Entity */
        modelMapper.typeMap(EnderecoResponseApi.class, Endereco.class)
                .addMappings(m -> {
                    m.map(EnderecoResponseApi::getCep, Endereco::setCep);
                    m.map(EnderecoResponseApi::getLogradouro, Endereco::setLogradouro);
                    m.map(EnderecoResponseApi::getNumero, Endereco::setNumero);
                    m.map(EnderecoResponseApi::getComplemento, Endereco::setComplemento);
                    m.map(EnderecoResponseApi::getBairro, Endereco::setBairro);
                    m.map(EnderecoResponseApi::getLocalidade, Endereco::setLocalidade);
                    m.map(EnderecoResponseApi::getEstado, Endereco::setEstado);
                    m.map(EnderecoResponseApi::getUf, Endereco::setUf);
                });

        /* Entity -> DTO */
        modelMapper.typeMap(Endereco.class, EnderecoResponseApi.class)
                .addMappings(m -> {
                    m.map(Endereco::getCep, EnderecoResponseApi::setCep);
                    m.map(Endereco::getLogradouro, EnderecoResponseApi::setLogradouro);
                    m.map(Endereco::getNumero, EnderecoResponseApi::setNumero);
                    m.map(Endereco::getComplemento, EnderecoResponseApi::setComplemento);
                    m.map(Endereco::getBairro, EnderecoResponseApi::setBairro);
                    m.map(Endereco::getLocalidade, EnderecoResponseApi::setLocalidade);
                    m.map(Endereco::getEstado, EnderecoResponseApi::setEstado);
                    m.map(Endereco::getUf, EnderecoResponseApi::setUf);
                });
    }
}
