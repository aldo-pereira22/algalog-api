package com.dev.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.Entrega;
import com.dev.model.StatusEntrega;
import com.dev.model.exception.NegocioException;
import com.dev.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	public FinalizacaoEntregaService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		entrega.setStatus(StatusEntrega.FINALIZADA);
		
		entregaRepository.save(entrega);
		
	}
}
