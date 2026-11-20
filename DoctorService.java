package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {

    // Metoda zwracająca dostępne sloty dla lekarza na dany dzień
    public List<String> getAvailableSlots(Long doctorId, LocalDate date) {
        // Logika mockowa - w rzeczywistości zapytanie do bazy
        return List.of("09:00", "10:00", "11:00");
    }

    // Metoda logowania lekarza
    public boolean login(String email, String password) {
        // Logika mockowa walidacji
        return email != null && password != null;
    }
}