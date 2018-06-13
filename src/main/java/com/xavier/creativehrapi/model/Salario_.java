package com.xavier.creativehrapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Salario.class)
public abstract class Salario_ {

	public static volatile SingularAttribute<Salario, BigDecimal> salarioLiquido;
	public static volatile SingularAttribute<Salario, Timesheet> timesheet;
	public static volatile SingularAttribute<Salario, Long> codigo;
	public static volatile SingularAttribute<Salario, LocalDate> dataSalario;
	public static volatile SingularAttribute<Salario, BigDecimal> descontoPorDia;
	public static volatile SingularAttribute<Salario, BigDecimal> descontoPorHora;
	public static volatile SingularAttribute<Salario, Funcionario> funcionario;

}

