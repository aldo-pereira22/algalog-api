package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.OcorrenciaDTO;
import com.dev.dto.input.OcorrenciaInput;
import com.dev.mapper.OcorrenciaMapper;
import com.dev.model.Entrega;
import com.dev.model.Ocorrencia;
import com.dev.service.BuscaEntregaService;
import com.dev.service.RegistroOcrrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private RegistroOcrrenciaService registroOcrrenciaService;
	
	@Autowired
	BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private OcorrenciaMapper ocorrenciaMapper;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId, @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada =  registroOcrrenciaService
				.registrar(entregaId,ocorrenciaInput.getDescricao());
		
		return ocorrenciaMapper.toMoMapper(ocorrenciaRegistrada);
		
	}
	
	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
	}
	
	
}
