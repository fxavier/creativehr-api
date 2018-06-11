package com.xavier.creativehrapi.model;

public enum TipoFuncionario {
	
	NORMAL("Normal"),
	SUPERVISOR("Supervisor");
	
	private String descricao;
	
	TipoFuncionario(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
