package com.dev.dto.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaInput {


	private ClienteIdInput cliente;
	

	private DestinatarioInput destinatario;
	
	private BigDecimal taxa;

	public ClienteIdInput getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}

	public DestinatarioInput getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioInput destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
}
