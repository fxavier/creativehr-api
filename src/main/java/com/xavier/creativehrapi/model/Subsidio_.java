package com.xavier.creativehrapi.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subsidio.class)
public abstract class Subsidio_ {

	public static volatile SingularAttribute<Subsidio, Long> codigo;
	public static volatile SingularAttribute<Subsidio, BigDecimal> valor;
	public static volatile SingularAttribute<Subsidio, TipoSubsidio> tipoSubsidio;
	public static volatile SingularAttribute<Subsidio, String> descricao;

}

