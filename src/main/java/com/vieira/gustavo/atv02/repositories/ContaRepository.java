package com.vieira.gustavo.atv02.repositories;

import com.vieira.gustavo.atv02.entities.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
}
