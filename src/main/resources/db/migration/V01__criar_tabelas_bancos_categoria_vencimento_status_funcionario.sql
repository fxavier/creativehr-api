CREATE TABLE banco(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE tipo_contrato(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
dias_aviso_previo INTEGER,
duracao BIGINT,
PRIMARY KEY(codigo)
);

CREATE TABLE habilitacoes_academicas(
codigo BIGSERIAL NOT NULL,
curso VARCHAR(200) NOT NULL,
designacao VARCHAR(200),
PRIMARY KEY(codigo)
);

-- Tipo percentual ou valor fixo
CREATE TABLE tipo_subsidio(
codigo BIGSERIAL NOT NULL,
descricao VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE subsidio(
codigo BIGSERIAL NOT NULL,
descricao VARCHAR(50) NOT NULL,
codigo_tipo_subsidio BIGINT,
valor DECIMAL(10,2) NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_subsidio_tipo_subsidio
  FOREIGN KEY(codigo_tipo_subsidio) REFERENCES tipo_subsidio(codigo)
);

CREATE TABLE pais(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE status_funcionario(
codigo BIGSERIAL NOT NULL,
descricao VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE departamento(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE funcao(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
codigo_departamento BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_funcao_departamento
  FOREIGN KEY(codigo_departamento) REFERENCES departamento(codigo)
);

CREATE TABLE posto_trabalho(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE estabelecimento(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
morada VARCHAR(200),
PRIMARY KEY(codigo)
);

CREATE TABLE irps(
codigo BIGSERIAL NOT NULL,
indice VARCHAR(100) NOT NULL,
taxa_percentual DECIMAL(10,2) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE profissao(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE funcionario(
codigo BIGSERIAL NOT NULL,
numero_interno BIGINT NOT NULL,
codigo_status BIGINT NOT NULL,
morada TEXT NOT NULL,
codigo_pais BIGINT NOT NULL,
caixa_postal VARCHAR(50),
codigo_estabelecimento BIGINT NOT NULL,
nuit BIGINT NOT NULL,
numero_dependentes INTEGER,
numero_beneficiario BIGINT NOT NULL,
documento_identificacao VARCHAR(20) NOT NULL,
numero_identificacao VARCHAR(50),
data_emissao DATE NOT NULL,
local_emissao VARCHAR(50) NOT NULL,
data_validade DATE NOT NULL,
telefone VARCHAR(50),
telemovel VARCHAR(50),
data_nascimento DATE NOT NULL,
sexo VARCHAR(20) NOT NULL,
estado_civil VARCHAR(20) NOT NULL,
regime_horario VARCHAR(50),
codigo_posto BIGINT NOT NULL,
salario_base DECIMAL(10,2) NOT NULL,
salario_diario DECIMAL(10,2),
subsidio_turno DECIMAL(10,2),
codigo_subsidio BIGINT NOT NULL,
codigo_irps BIGINT NOT NULL,
valor_seguranca_social DECIMAL(10,2),
codigo_tipo_contrato BIGINT,
codigo_habilitacoes_academicas BIGINT,
codigo_funcao BIGINT,
codigo_profissao BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_funcionario_status
  FOREIGN KEY(codigo_status) REFERENCES status_funcionario(codigo),
CONSTRAINT fk_funcionario_pais
  FOREIGN KEY(codigo_pais) REFERENCES pais(codigo),
CONSTRAINT fk_funcionario_estabelecimento
  FOREIGN KEY(codigo_estabelecimento) REFERENCES estabelecimento(codigo),
CONSTRAINT fk_funcionario_subsidio
  FOREIGN KEY(codigo_subsidio) REFERENCES subsidio(codigo),
CONSTRAINT fk_funcionario_irps
  FOREIGN KEY(codigo_irps) REFERENCES irps(codigo),
CONSTRAINT fk_funcionario_tipo_contrato
  FOREIGN KEY(codigo_tipo_contrato) REFERENCES tipo_contrato(codigo),
CONSTRAINT fk_funcionario_habilitacoes
  FOREIGN KEY(codigo_habilitacoes_academicas) REFERENCES habilitacoes_academicas(codigo),
CONSTRAINT fk_funcionario_funcao
  FOREIGN KEY(codigo_funcao) REFERENCES funcao(codigo),  
CONSTRAINT fk_funcionario_profissao
  FOREIGN KEY(codigo_profissao) REFERENCES profissao(codigo) 
);


