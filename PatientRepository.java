package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Metoda pobierająca pacjenta po e-mailu (pochodna)
    Patient findByEmail(String email);

    // Metoda pobierająca pacjenta po e-mailu lub numerze telefonu (niestandardowa z @Query)
    @Query("SELECT p FROM Patient p WHERE p.email = :identifier OR p.phone = :identifier")
    Patient findByEmailOrPhone(@Param("identifier") String identifier);
}