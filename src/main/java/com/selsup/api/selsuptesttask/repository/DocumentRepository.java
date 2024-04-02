package com.selsup.api.selsuptesttask.repository;

import com.selsup.api.selsuptesttask.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
