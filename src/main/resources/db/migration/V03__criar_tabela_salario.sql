CREATE TABLE timesheet(
codigo BIGSERIAL NOT NULL,
data DATE,
horas INTEGER,
dias_ferias INTEGER,
codigo_funcionario BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_timesheet_funcionario
  FOREIGN KEY(codigo_funcionario) REFERENCES funcionario(codigo)

);

CREATE TABLE salario(
codigo BIGSERIAL NOT NULL,
data_salario DATE,
desconto_por_hora DECIMAL(10,2),
desconto_por_dia DECIMAL(10,2),
salario_liquido DECIMAL(10,2),
codigo_funcionario BIGINT,
codigo_timesheet BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_salario_funcionario
  FOREIGN KEY(codigo_funcionario) REFERENCES funcionario(codigo),
CONSTRAINT fk_salario_timesheet 
  FOREIGN KEY(codigo_timesheet) REFERENCES timesheet(codigo)

);