package com.xavier.creativehrapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salario")
public class Salario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "data_salario")
	private LocalDate dataSalario;
	
	@Column(name = "desconto_por_hora")
	private BigDecimal descontoPorHora;
	
	@Column(name = "desconto_por_dia")
	private BigDecimal descontoPorDia;
	
	@Column(name = "salario_liquido")
	private BigDecimal salarioLiquido;
	
	@ManyToOne
	@JoinColumn(name = "codigo_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_timesheet")
	private Timesheet timesheet;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataSalario() {
		return dataSalario;
	}

	public void setDataSalario(LocalDate dataSalario) {
		this.dataSalario = dataSalario;
	}

	public BigDecimal getDescontoPorHora() {
		return descontoPorHora;
	}

	public void setDescontoPorHora(BigDecimal descontoPorHora) {
		this.descontoPorHora = descontoPorHora;
	}

	public BigDecimal getDescontoPorDia() {
		return descontoPorDia;
	}

	public void setDescontoPorDia(BigDecimal descontoPorDia) {
		this.descontoPorDia = descontoPorDia;
	}

	public BigDecimal getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(BigDecimal salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
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
		Salario other = (Salario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
