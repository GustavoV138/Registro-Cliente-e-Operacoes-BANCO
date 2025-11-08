package com.vieira.gustavo.atv02.repositories;

import com.vieira.gustavo.atv02.entities.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoEntity, Long> {

    public List<OperacaoEntity> findByContaId(Long id);
}
