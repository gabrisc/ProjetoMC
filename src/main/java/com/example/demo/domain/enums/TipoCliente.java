package com.example.demo.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(100, "Pessoa Fisica"),
	PESSOAJURIDICA(200, "Pessoa Juridica");

	private Integer cod;
	private String descricao;
	
	public static TipoCliente ToEnum(Integer cod) {

			
		if(cod == null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido");
		
			
			
		}
		
	
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	

}
