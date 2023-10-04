package com.atacado.presentes.mg.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Column(length = 10)
    @Pattern(regexp = "^[0-9]{2}\\.[0-9]{3}-[0-9]{3}$", message = "cep tem que seguir o padrão XX.XXX-XXX")
    private String cep;

    @Column(length = 255)
    private String logradouro;
    @Column(length = 10)
    private String numero;
    @Column(length = 50)
    private String complemento;
    @Column(length = 50)
    private String bairro;
    @Column(length = 50)
    private String cidade;
    @Column(length = 2)
    private String uf;
    @Column(length = 255)
    private String pontoDeReferencia;
}
