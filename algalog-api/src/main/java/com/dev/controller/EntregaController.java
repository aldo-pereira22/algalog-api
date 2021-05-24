package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.DestinatarioDTO;
import com.dev.dto.EntregaDTO;
import com.dev.model.Entrega;
import com.dev.repository.EntregaRepository;
import com.dev.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitarEntrega(@RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar(){
		return entregaRepository.findAll();
	}
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
		.map( entrega -> {
			EntregaDTO entregaDTO = new EntregaDTO();
			entregaDTO.setId(entrega.getId());
			entregaDTO.setNomeCliente(entrega.getCliente().getNome());
			entregaDTO.setDestinatario(new DestinatarioDTO());
			entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
			entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
			entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
			entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
			entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
			entregaDTO.setTaxa(entrega.getTaxa());
			entrega.setStatus(entrega.getStatus());
			entrega.setDataPedido(entrega.getDataPedido());
			entrega.setDataFinalizacao(entrega.getDataFinalizacao());
			return ResponseEntity.ok(entregaDTO);
		})
		.orElse(ResponseEntity.notFound().build());
			
	}
}
