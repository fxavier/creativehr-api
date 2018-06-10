ALTER TABLE funcionario
ADD COLUMN conta VARCHAR(20),
ADD COLUMN nib VARCHAR(50),
ADD COLUMN codigo_banco BIGINT,
ADD CONSTRAINT fk_funcionario_banco
   FOREIGN KEY(codigo_banco) REFERENCES banco(codigo);