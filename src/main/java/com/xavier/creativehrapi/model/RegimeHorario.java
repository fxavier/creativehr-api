package com.xavier.creativehrapi.model;

public enum RegimeHorario {
	
	TEMPO_INTEIRO("Tempo inteiro"),
	TEMPO_PARCIAL("Tempo parcial");
	
	private String descricao;
	
	RegimeHorario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
