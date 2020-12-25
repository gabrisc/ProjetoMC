package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.example.demo.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;
	public PagamentoComBoleto(){}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,Date datVencimento, Date datPagamento) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento=datPagamento;
		this.dataVencimento=datVencimento;
		// TODO Auto-generated constructor stub
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

	
	
}
