package com.selsup.api.selsuptesttask.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SignatureService {

    @Value("${document.signature}")
    private String trueSignature;

    public boolean isValidSignature(String signature) {
        return trueSignature.equals(signature);
    }
}
