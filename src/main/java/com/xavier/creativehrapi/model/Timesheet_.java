package com.xavier.creativehrapi.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Timesheet.class)
public abstract class Timesheet_ {

	public static volatile SingularAttribute<Timesheet, Integer> horas;
	public static volatile SingularAttribute<Timesheet, Long> codigo;
	public static volatile SingularAttribute<Timesheet, LocalDate> data;
	public static volatile SingularAttribute<Timesheet, Integer> diasFerias;
	public static volatile SingularAttribute<Timesheet, Funcionario> funcionario;

}

