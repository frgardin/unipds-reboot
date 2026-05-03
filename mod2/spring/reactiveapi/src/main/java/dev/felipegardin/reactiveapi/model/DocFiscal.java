package dev.felipegardin.reactiveapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_doc_fiscal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DocFiscal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "protocolo", length = 50, nullable = false)
    private String protocolo;

    @Column(name = "documento", columnDefinition = "TEXT")
    private String documento;
}
