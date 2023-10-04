package com.atacado.presentes.mg.api.dto;

import com.atacado.presentes.mg.api.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @NotNull
    private long idEndereco;
    @NotBlank
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String pontoDeReferencia;

    public Endereco toEndereco(){

        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.localidade);
        endereco.setUf(this.uf);
        endereco.setPontoDeReferencia(this.pontoDeReferencia);

        return endereco;
    }
}
