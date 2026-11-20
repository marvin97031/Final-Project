package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    // Metoda rezerwacji wizyty
    public Appointment bookAppointment(Appointment appointment) {
        // Zapis do bazy (mock)
        return appointment;
    }

    // Metoda pobierania wizyt lekarza na dany dzień
    public List<Appointment> getAppointmentsForDoctorByDate(Long doctorId, LocalDate date) {
        // Logika pobierania z bazy (mock)
        return List.of();
    }
}