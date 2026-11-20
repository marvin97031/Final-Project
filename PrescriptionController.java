package com.project.back_end.controllers;

import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> createPrescription(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> prescriptionBody) {
        // Walidacja tokenu
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Unauthorized"));
        }

        // Walidacja ciała żądania
        if (!prescriptionBody.containsKey("medication") || !prescriptionBody.containsKey("dosage")) {
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid prescription data"));
        }

        return ResponseEntity.ok(Map.of("message", "Prescription created successfully"));
    }
}