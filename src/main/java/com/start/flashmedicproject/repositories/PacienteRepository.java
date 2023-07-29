package com.start.flashmedicproject.repositories;

import com.start.flashmedicproject.models.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}
