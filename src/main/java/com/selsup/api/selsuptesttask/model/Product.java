package com.selsup.api.selsuptesttask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certificate_document")
    private String certificateDocument;

    @Column(name = "certificate_document_date")
    private LocalDate certificateDocumentDate;

    @Column(name = "certificate_document_number")
    private String certificateDocumentNumber;

    @Column(name = "owner_inn")
    private String ownerInn;

    @Column(name = "producer_inn")
    private String producerInn;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "tnved_code")
    private String tnvedCode;

    @Column(name = "uit_code")
    private String uitCode;

    @Column(name = "uitu_code")
    private String uituCode;
}
