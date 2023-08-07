package com.start.flashmedicproject.repositories;

import com.start.flashmedicproject.models.Paciente;
import com.start.flashmedicproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByUser(User user);
    boolean existsByNumberFicha(String fichaAtendimento);
}
