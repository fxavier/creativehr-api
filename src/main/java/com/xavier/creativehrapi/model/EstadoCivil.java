package com.xavier.creativehrapi.model;

public enum EstadoCivil {
	
	CASADO("Casado"),
	DIVORCIADO("Divorciado"),
	SOLTEIRO("Solteiro");
	
	private String descricao;
	
	EstadoCivil(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
