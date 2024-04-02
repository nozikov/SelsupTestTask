package com.selsup.api.selsuptesttask.api;

import com.selsup.api.selsuptesttask.dto.DocumentDto;
import com.selsup.api.selsuptesttask.mapper.DocumentMapper;
import com.selsup.api.selsuptesttask.service.DocumentService;
import com.selsup.api.selsuptesttask.service.SignatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v3/lk/documents")
public class CrptApi {

    private final DocumentService documentService;
    private final SignatureService signatureService;
    private final DocumentMapper mapper;
    private final Semaphore semaphore;
    private final long requestInterval;

    public CrptApi(DocumentService documentService,
                   SignatureService signatureService,
                   DocumentMapper mapper,
                   Semaphore semaphore,
                   long requestInterval) {
        this.documentService = documentService;
        this.signatureService = signatureService;
        this.mapper = mapper;
        this.semaphore = semaphore;
        this.requestInterval = requestInterval;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDocument(@RequestBody DocumentDto document,
                                               @RequestHeader("Signature")String signature) {
        boolean acquired = false;
        try {
            acquired = semaphore.tryAcquire(requestInterval, TimeUnit.MILLISECONDS);
            if (!acquired) {
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                        .body("Request limit exceeded, please try again later.");
            }

            if (!signatureService.isValidSignature(signature)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid signature");
            }

            documentService.createDocument(mapper.mapDtoDocumentToEntity(document));

            return ResponseEntity.ok("Document processed successfully");

        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Request processing was interrupted");
        } finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }

}
