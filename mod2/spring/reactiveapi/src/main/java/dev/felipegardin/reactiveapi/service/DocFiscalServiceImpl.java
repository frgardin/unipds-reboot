package dev.felipegardin.reactiveapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import dev.felipegardin.reactiveapi.model.DocFiscal;
import dev.felipegardin.reactiveapi.repo.DocFiscalRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocFiscalServiceImpl implements IDocFiscalService {

    private final DocFiscalRepo repo;
    private final WebClient webClient;

    @Override
    public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo) {
        webClient.get()
                .uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> {
                    System.out.println("Deu certo");
                    DocFiscal doc = new DocFiscal();
                    doc.setProtocolo(protocolo);
                    doc.setDocumento(response);
                    repo.save(doc);
                })
                .doOnError(error -> {
                    System.out.println(error);
                });
    }

    @Override
    public DocFiscal consultarPorProtocolo(String protocolo) {
        return repo.findByProtocolo(protocolo);
    }
}
