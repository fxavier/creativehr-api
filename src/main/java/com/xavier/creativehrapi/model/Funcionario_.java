package com.xavier.creativehrapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile SingularAttribute<Funcionario, Long> numeroInterno;
	public static volatile SingularAttribute<Funcionario, Funcao> funcao;
	public static volatile SingularAttribute<Funcionario, Long> nuit;
	public static volatile SingularAttribute<Funcionario, String> telefone;
	public static volatile SingularAttribute<Funcionario, String> apelido;
	public static volatile SingularAttribute<Funcionario, Long> numeroBeneficiario;
	public static volatile SingularAttribute<Funcionario, String> nib;
	public static volatile SingularAttribute<Funcionario, String> conta;
	public static volatile SingularAttribute<Funcionario, BigDecimal> salarioBase;
	public static volatile SingularAttribute<Funcionario, BigDecimal> valorSegurancaSocial;
	public static volatile SingularAttribute<Funcionario, PostoTrabalho> postoTrabalho;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataEmissao;
	public static volatile SingularAttribute<Funcionario, BigDecimal> salarioDiario;
	public static volatile SingularAttribute<Funcionario, Subsidio> subsidio;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataValidade;
	public static volatile SingularAttribute<Funcionario, String> celular;
	public static volatile SingularAttribute<Funcionario, TipoContrato> tipoContrato;
	public static volatile SingularAttribute<Funcionario, String> sobrenome;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataNascimento;
	public static volatile SingularAttribute<Funcionario, IRPS> irps;
	public static volatile SingularAttribute<Funcionario, RegimeHorario> regimeHorario;
	public static volatile SingularAttribute<Funcionario, String> morada;
	public static volatile SingularAttribute<Funcionario, Long> codigo;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataInicioContrato;
	public static volatile SingularAttribute<Funcionario, String> numeroIdentificacao;
	public static volatile SingularAttribute<Funcionario, Profissao> profissao;
	public static volatile SingularAttribute<Funcionario, Banco> banco;
	public static volatile SingularAttribute<Funcionario, String> nome;
	public static volatile SingularAttribute<Funcionario, String> caixaPostal;
	public static volatile SingularAttribute<Funcionario, EstadoCivil> estadoCivil;
	public static volatile SingularAttribute<Funcionario, StatusFuncionario> statusFuncionario;
	public static volatile SingularAttribute<Funcionario, Pais> pais;
	public static volatile SingularAttribute<Funcionario, BigDecimal> subsidioTurno;
	public static volatile SingularAttribute<Funcionario, LocalDate> dataFimContrato;
	public static volatile SingularAttribute<Funcionario, Estabelecimento> estabelecimento;
	public static volatile SingularAttribute<Funcionario, Long> numeroDependentes;
	public static volatile SingularAttribute<Funcionario, DocumentoIdentificacao> documentoIdentificacao;
	public static volatile SingularAttribute<Funcionario, Sexo> sexo;
	public static volatile SingularAttribute<Funcionario, HabilitacoesAcademicas> habilitacoesAcademicas;

}

