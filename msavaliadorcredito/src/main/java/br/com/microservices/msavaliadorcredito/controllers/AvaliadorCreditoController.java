package br.com.microservices.msavaliadorcredito.controllers;

import br.com.microservices.msavaliadorcredito.domain.dto.DadosAvaliacao;
import br.com.microservices.msavaliadorcredito.domain.dto.RetornoAvaliacaoCliente;
import br.com.microservices.msavaliadorcredito.domain.dto.SituacaoCliente;
import br.com.microservices.msavaliadorcredito.exceptions.DadosClienteNotFoundException;
import br.com.microservices.msavaliadorcredito.exceptions.ErroComunicacaoMicroServicesException;
import br.com.microservices.msavaliadorcredito.services.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        }
        catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        catch (ErroComunicacaoMicroServicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dados){
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        }
        catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        catch (ErroComunicacaoMicroServicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
}
