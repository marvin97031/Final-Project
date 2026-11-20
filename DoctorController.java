package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private TokenService tokenService; 

    // Endpoint GET z dynamicznymi parametrami (np. specialty)
    @GetMapping
    public ResponseEntity<?> getDoctors(@RequestHeader(value = "Authorization", required = false) String token, 
                                        @RequestParam(required = false) String specialty) {
        
        // Walidacja tokenu
        if (token == null || !tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid or missing token"));
        }

        // Logika pobierania lekarzy (uproszczona na potrzeby zadania)
        List<Doctor> doctors = List.of(); 
        return ResponseEntity.ok(doctors);
    }
}