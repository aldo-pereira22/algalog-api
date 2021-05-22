create table entrega(
	id  serial not null,
	cliente_id bigint not null,
	taxa real not null,
	status varchar(20) not null,
	data_pedido time not null,
	data_finalizacao time,
	
	destinatario_nome  varchar(60) not null,
	destinatario_logradouro varchar(255) not null,
	destinatario_numero varchar(30) not null,
	destinatario_complemento varchar(255) not null,
	destinatario_bairro varchar(30) not null,
	
	
	primary key (id)
	
);
 alter table entrega add constraint fk_entrega_cliente foreign key (cliente_id) references cliente (id)
;
