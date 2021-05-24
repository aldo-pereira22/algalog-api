package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.Entrega;
import com.dev.model.exception.EntidadeNaoEncontradaException;
import com.dev.model.exception.NegocioException;
import com.dev.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	@Autowired
	EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		 return entregaRepository.findById(entregaId)
		.orElseThrow( ()-> new EntidadeNaoEncontradaException("Cliente não encontrado"));	
	}
}
