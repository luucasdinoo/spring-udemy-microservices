package br.com.microservices.msavaliadorcredito.domain.dto;

import lombok.Data;

@Data
public class DadosAvaliacao {

    private String cpf;
    private Long renda;
}
