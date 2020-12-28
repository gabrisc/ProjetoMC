package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import com.example.demo.domain.enums.EstadoPagamento;

//A segunda anotação serve para o JPA identificar uma herança no caso de pagamento com pagamentoComBoleto e cartao
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	//Essa variavel recebe o mesmo id da classe Pedido
	@Id
	private Integer id;
	
	private EstadoPagamento estadoPagamento;
	
	//Pagamento não possui id proprio, por isso necessita mapear o id do pedido
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	//Construtor Vazio
	public Pagamento(){}
	//Construtor com paramentos, mas sem listas ou conjuntos
	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.pedido = pedido;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EstadoPagamento getEstadoPagamento() {
		return estadoPagamento;
	}
	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
