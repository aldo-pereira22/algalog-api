package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.EntregaDTO;
import com.dev.dto.input.EntregaInput;
import com.dev.mapper.EntregaMapper;
import com.dev.model.Entrega;
import com.dev.repository.EntregaRepository;
import com.dev.service.FinalizacaoEntregaService;
import com.dev.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@Autowired
	FinalizacaoEntregaService finalizacaoEntregaService;
	
	
	@Autowired
	private EntregaMapper entregaMapper;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitarEntrega(@RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
		
		return entregaMapper.toModel(solicitacaoEntregaService.solicitar(novaEntrega));
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
	
	@GetMapping
	public List<EntregaDTO> listar(){
		return entregaMapper.toCollectionModel( entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
		.map( entrega-> ResponseEntity.ok(entregaMapper.toModel(entrega))		)
		.orElse(ResponseEntity.notFound().build());
			
	}
	
}
