package dev.felipegardin.reactiveapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.reactiveapi.model.DocFiscal;

public interface DocFiscalRepo extends JpaRepository<DocFiscal, Long> {

    DocFiscal findByProtocolo(String protocolo);
    
}
