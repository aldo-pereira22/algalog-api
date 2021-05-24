package com.dev.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.dev.model.StatusEntrega;

public class EntregaDTO {
		private Long id;
		private ClienteResumoDTO cliente;
		private DestinatarioDTO destinatario;
		private BigDecimal taxa;
		private StatusEntrega status;
		private OffsetDateTime dataPedido;
		private OffsetDateTime dataFinalizacao;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		public DestinatarioDTO getDestinatario() {
			return destinatario;
		}
		public void setDestinatario(DestinatarioDTO destinatario) {
			this.destinatario = destinatario;
		}
		public BigDecimal getTaxa() {
			return taxa;
		}
		public void setTaxa(BigDecimal taxa) {
			this.taxa = taxa;
		}
		public StatusEntrega getStatus() {
			return status;
		}
		public void setStatus(StatusEntrega status) {
			this.status = status;
		}
		public OffsetDateTime getDataPedido() {
			return dataPedido;
		}
		public void setDataPedido(OffsetDateTime dataPedido) {
			this.dataPedido = dataPedido;
		}
		public OffsetDateTime getDataFinalizacao() {
			return dataFinalizacao;
		}
		public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
			this.dataFinalizacao = dataFinalizacao;
		}
		public ClienteResumoDTO getCliente() {
			return cliente;
		}
		public void setCliente(ClienteResumoDTO cliente) {
			this.cliente = cliente;
		}
		
		
}
