package com.start.flashmedicproject.repositories;

import com.start.flashmedicproject.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByEmail(String email);

    Paciente findByName(String name);
}
