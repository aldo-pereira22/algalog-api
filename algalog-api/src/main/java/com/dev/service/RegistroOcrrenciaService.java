package com.dev.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.Entrega;
import com.dev.model.Ocorrencia;
import com.dev.model.exception.NegocioException;
import com.dev.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcrrenciaService {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega =  buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
		

	}
}
