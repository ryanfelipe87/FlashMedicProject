package com.start.flashmedicproject.repositories;

import com.start.flashmedicproject.models.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
}
