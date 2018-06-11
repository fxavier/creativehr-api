package com.xavier.creativehrapi.model;

public enum DocumentoIdentificacao {
	
	BI("BI"),
	DIRE("DIRE"),
	PASSAPORTE("Passaporte");
	
	private String descricao;
	
	DocumentoIdentificacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
