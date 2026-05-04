package dev.felipegardin.reactiveapi.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.felipegardin.reactiveapi.dto.ProtocoloDTO;
import dev.felipegardin.reactiveapi.dto.RequisicaoDTO;
import dev.felipegardin.reactiveapi.model.DocFiscal;
import dev.felipegardin.reactiveapi.service.IDocFiscalService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DocFiscalController {

    
    private final IDocFiscalService service;

    @GetMapping("/consultar/{protocolo}")
    public ResponseEntity<DocFiscal> consultar(@PathVariable String protocolo) {
        return ResponseEntity.ok(service.consultarPorProtocolo(protocolo));
    }

    @PostMapping("/solicitar")
    public Mono<ResponseEntity<ProtocoloDTO>> solicitar(@RequestBody RequisicaoDTO req) {
        String idProtocolo = UUID.randomUUID().toString();
        service.realizarAutorizacaoAPIExterna(req.idCliente(), req.idServico(), idProtocolo);
        return Mono.just(ResponseEntity.accepted().body(new ProtocoloDTO(idProtocolo)));
    }
}
