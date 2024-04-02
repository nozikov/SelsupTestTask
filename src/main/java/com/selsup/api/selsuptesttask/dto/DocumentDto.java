package com.selsup.api.selsuptesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DocumentDto {
    @JsonProperty("doc_id")
    private String docId;
    @JsonProperty("doc_status")
    private String docStatus;
    @JsonProperty("doc_type")
    private String docType;
    private boolean importRequest;
    @JsonProperty("owner_inn")
    private String ownerInn;
    @JsonProperty("participant_inn")
    private String participantInn;
    @JsonProperty("producer_inn")
    private String producerInn;
    @JsonProperty("production_date")
    private String productionDate;
    @JsonProperty("production_type")
    private String productionType;
    private List<ProductDto> products;
    @JsonProperty("reg_date")
    private String regDate;
    @JsonProperty("reg_number")
    private String regNumber;
    private DescriptionDto description;
}
