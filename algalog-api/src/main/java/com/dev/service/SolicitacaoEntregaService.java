package com.dev.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.model.Entrega;
import com.dev.model.StatusEntrega;
import com.dev.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		 return entregaRepository.save(entrega);
	}
	
}
