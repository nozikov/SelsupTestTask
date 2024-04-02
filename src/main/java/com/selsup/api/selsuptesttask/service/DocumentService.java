package com.selsup.api.selsuptesttask.service;

import com.selsup.api.selsuptesttask.model.Document;
import com.selsup.api.selsuptesttask.repository.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentService {

    private final DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public void createDocument(Document document) {

        // Do some logic ...

        repository.save(document);
        log.info("Document was saved");
    }
}
