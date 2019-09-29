CREATE TABLE produtos (
  id serial NOT NULL ,
  data_exclusao timestamp,
  idCategoria BIGINT NOT NULL,
  produto VARCHAR(255),
  preco double precision,
  quantidade BIGINT NOT NULL ,
  descricao VARCHAR(255),
  foto BYTEA,
  PRIMARY KEY (id)
);