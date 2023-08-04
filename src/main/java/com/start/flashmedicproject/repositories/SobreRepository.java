package com.start.flashmedicproject.repositories;

import com.start.flashmedicproject.models.Sobre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreRepository extends JpaRepository<Sobre, Long> {
}
