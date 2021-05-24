package com.dev.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.dto.OcorrenciaDTO;
import com.dev.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toMoMapper(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	
	public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream()
				.map(this::toMoMapper)
				.collect(Collectors.toList());
	}


}
