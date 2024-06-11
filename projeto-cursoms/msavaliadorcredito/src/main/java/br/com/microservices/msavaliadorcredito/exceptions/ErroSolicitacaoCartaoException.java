package br.com.microservices.msavaliadorcredito.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException{

    public ErroSolicitacaoCartaoException(String msg){
        super(msg);
    }
}
