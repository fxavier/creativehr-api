package com.xavier.creativehrapi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class IRPS implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String indice;
	
	private BigDecimal taxaPercentual;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public BigDecimal getTaxaPercentual() {
		return taxaPercentual;
	}

	public void setTaxaPercentual(BigDecimal taxaPercentual) {
		this.taxaPercentual = taxaPercentual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		IRPS other = (IRPS) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
