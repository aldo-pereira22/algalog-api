package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
		
}
