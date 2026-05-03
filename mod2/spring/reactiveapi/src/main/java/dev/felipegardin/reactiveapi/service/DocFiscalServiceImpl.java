package dev.felipegardin.reactiveapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import dev.felipegardin.reactiveapi.model.DocFiscal;
import dev.felipegardin.reactiveapi.repo.DocFiscalRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocFiscalServiceImpl implements IDocFiscalService{

    private final DocFiscalRepo repo;
    private WebClient webClient;

    @Override
    public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo) {
        // TODO Auto-generated method stub
        webClient   .get()
                    .uri("https://localhost:8080/api/vi/autorizacao/"+idCliente+"?servico="+idServico)
                    .retrieve();
        //TODO: FINISH THIS METHOD
    }

    @Override
    public DocFiscal consultarPorProtocolo(String protocolo) {
        return repo.findByProtocolo(protocolo);
    }
    
}
