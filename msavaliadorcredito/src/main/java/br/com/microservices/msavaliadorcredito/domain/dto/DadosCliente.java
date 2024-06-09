package br.com.microservices.msavaliadorcredito.domain.dto;

import lombok.Data;

@Data
public class DadosCliente {

    private Long id;
    private String nome;
    private Integer idade;
}
