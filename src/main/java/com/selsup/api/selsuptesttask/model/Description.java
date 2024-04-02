package com.selsup.api.selsuptesttask.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "descriptions")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_inn")
    private String participantInn;
}