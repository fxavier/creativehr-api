package com.xavier.creativehrapi.repository.filter;

import java.time.LocalDate;

import com.xavier.creativehrapi.model.Departamento;

public class FuncionarioFilter {
	
	private String numeroInterno;
	
	private String nome;
	
	private String sobrenome;
	
	private String apelido;
	
	private Departamento departamento;
	
	
	private LocalDate dataInicioContrato;
	
	private LocalDate dataFimContrato;

	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public LocalDate getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(LocalDate dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}
	
	

}
