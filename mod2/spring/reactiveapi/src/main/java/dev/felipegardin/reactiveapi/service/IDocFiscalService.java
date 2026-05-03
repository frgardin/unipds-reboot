package dev.felipegardin.reactiveapi.service;

import dev.felipegardin.reactiveapi.model.DocFiscal;

public interface IDocFiscalService {

    public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo);
    public DocFiscal consultarPorProtocolo(String protocolo);
}
