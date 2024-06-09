package br.com.microservices.mscartoes.services;

import br.com.microservices.mscartoes.domain.Cartao;
import br.com.microservices.mscartoes.repositories.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao save(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Transactional
    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
