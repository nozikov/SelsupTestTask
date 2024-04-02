package com.selsup.api.selsuptesttask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doc_id")
    private String docId;

    @Column(name = "doc_status")
    private String docStatus;

    @Column(name = "doc_type")
    private String docType;

    @Column(name = "import_request")
    private boolean importRequest;

    @Column(name = "owner_inn")
    private String ownerInn;

    @Column(name = "participant_inn")
    private String participantInn;

    @Column(name = "producer_inn")
    private String producerInn;

    @Column(name = "production_date")
    @Temporal(TemporalType.DATE)
    private LocalDate productionDate;

    @Column(name = "production_type")
    private String productionType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "document_products",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private LocalDate regDate;

    @Column(name = "reg_number")
    private String regNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id")
    private Description description;
}

