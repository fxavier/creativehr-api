package com.xavier.creativehrapi.model;

public enum Sexo {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
