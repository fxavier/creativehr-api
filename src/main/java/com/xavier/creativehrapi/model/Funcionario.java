package com.xavier.creativehrapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "numero_interno")
	private Long numeroInterno;
	
	private String nome;
	
	private String sobrenome;
	
	private String apelido;
	
	@Column(name = "data_inicio_contrato")
	private LocalDate dataInicioContrato;
	
	@Column(name = "data_fim_contrato")
	private LocalDate dataFimContrato;
	
	@ManyToOne
	@JoinColumn(name = "codigo_status")
	private StatusFuncionario statusFuncionario;
	
	@NotNull
	private String morada;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pais")
	private Pais pais;
	
	@Column(name = "caixa_postal")
	private String caixaPostal;
	
	@ManyToOne
	@JoinColumn(name = "codigo_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@NotNull
	private Long nuit;
	
	@NotNull
	@Column(name = "numero_dependentes")
	private Long numeroDependentes;
	
	@NotNull
	@Column(name = "numero_beneficiario")
	private Long numeroBeneficiario;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "documento_identificacao")
	private DocumentoIdentificacao documentoIdentificacao;
	
	@Column(name = "numero_identificacao")
	private String numeroIdentificacao;
	
	@NotNull
	@Column(name = "data_emissao")
	private LocalDate dataEmissao;
	
	@Column(name = "data_validade")
	private LocalDate dataValidade;
	
	private String telefone;
	
	private String celular;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private EstadoCivil  estadoCivil;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "regime_horario")
	private RegimeHorario regimeHorario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_posto")
	private PostoTrabalho postoTrabalho;
	
	@Column(name = "supervisor")
	private Boolean eSupervisor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_seu_supervisor")
	private Funcionario supervisor;
	
	@OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
	private List<Funcionario> funcionarioNormal = new ArrayList<>();
	
	@Column(name = "salario_base")
	private BigDecimal salarioBase;
	
	@Column(name = "salario_diario")
	private BigDecimal salarioDiario;
	
	@Column(name = "subsidio_turno")
	private BigDecimal subsidioTurno;
	
	@ManyToOne
	@JoinColumn(name = "codigo_subsidio")
	private Subsidio subsidio;
	
	@ManyToOne
	@JoinColumn(name = "codigo_irps")
	private IRPS irps;
	
	@Column(name = "valor_seguranca_social")
	private BigDecimal valorSegurancaSocial;
	
	@ManyToOne
	@JoinColumn(name = "codigo_tipo_contrato")
	private TipoContrato tipoContrato;
	
	@ManyToOne
	@JoinColumn(name = "codigo_habilitacoes_academicas")
	private HabilitacoesAcademicas  habilitacoesAcademicas;
	
	@ManyToOne
	@JoinColumn(name = "codigo_funcao")
	private Funcao funcao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_profissao")
	private Profissao profissao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_banco")
	private Banco banco;
	
	private String conta;
	
	private String nib;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(Long numeroInterno) {
		this.numeroInterno = numeroInterno;
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

	public StatusFuncionario getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(StatusFuncionario statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getCaixaPostal() {
		return caixaPostal;
	}

	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Long getNuit() {
		return nuit;
	}

	public void setNuit(Long nuit) {
		this.nuit = nuit;
	}

	public Long getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(Long numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public Long getNumeroBeneficiario() {
		return numeroBeneficiario;
	}

	public void setNumeroBeneficiario(Long numeroBeneficiario) {
		this.numeroBeneficiario = numeroBeneficiario;
	}

	public DocumentoIdentificacao getDocumentoIdentificacao() {
		return documentoIdentificacao;
	}

	public void setDocumentoIdentificacao(DocumentoIdentificacao documentoIdentificacao) {
		this.documentoIdentificacao = documentoIdentificacao;
	}

	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public RegimeHorario getRegimeHorario() {
		return regimeHorario;
	}

	public void setRegimeHorario(RegimeHorario regimeHorario) {
		this.regimeHorario = regimeHorario;
	}

	public PostoTrabalho getPostoTrabalho() {
		return postoTrabalho;
	}

	public void setPostoTrabalho(PostoTrabalho postoTrabalho) {
		this.postoTrabalho = postoTrabalho;
	}


	public Boolean geteSupervisor() {
		return eSupervisor;
	}

	public void seteSupervisor(Boolean eSupervisor) {
		this.eSupervisor = eSupervisor;
	}

	public Funcionario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}

	public List<Funcionario> getFuncionarioNormal() {
		return funcionarioNormal;
	}

	public void setFuncionarioNormal(List<Funcionario> funcionarioNormal) {
		this.funcionarioNormal = funcionarioNormal;
	}

	public BigDecimal getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
	}

	public BigDecimal getSalarioDiario() {
		return salarioDiario;
	}

	public void setSalarioDiario(BigDecimal salarioDiario) {
		this.salarioDiario = salarioDiario;
	}

	public BigDecimal getSubsidioTurno() {
		return subsidioTurno;
	}

	public void setSubsidioTurno(BigDecimal subsidioTurno) {
		this.subsidioTurno = subsidioTurno;
	}

	public Subsidio getSubsidio() {
		return subsidio;
	}

	public void setSubsidio(Subsidio subsidio) {
		this.subsidio = subsidio;
	}

	public IRPS getIrps() {
		return irps;
	}

	public void setIrps(IRPS irps) {
		this.irps = irps;
	}

	public BigDecimal getValorSegurancaSocial() {
		return valorSegurancaSocial;
	}

	public void setValorSegurancaSocial(BigDecimal valorSegurancaSocial) {
		this.valorSegurancaSocial = valorSegurancaSocial;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public HabilitacoesAcademicas getHabilitacoesAcademicas() {
		return habilitacoesAcademicas;
	}

	public void setHabilitacoesAcademicas(HabilitacoesAcademicas habilitacoesAcademicas) {
		this.habilitacoesAcademicas = habilitacoesAcademicas;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getNib() {
		return nib;
	}

	public void setNib(String nib) {
		this.nib = nib;
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
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
