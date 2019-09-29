/** OAUTH CLIENTES AUTENTICACAO**/
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(256), authentication bytea
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);

/** FIM DA CRIACAO DO  AUTH**/







CREATE TABLE  categorias (
  id serial NOT NULL ,
  data_exclusao timestamp,
  categoria VARCHAR(50),
 
 
  PRIMARY KEY (id)
) ;


CREATE TABLE  clientes (
  id serial NOT NULL ,
  data_exclusao timestamp,
  nome VARCHAR(50),
  email VARCHAR(255),
  senha VARCHAR(255),
  
  rua VARCHAR(255),
  cidade VARCHAR(255),
  bairro VARCHAR(255),
  cep VARCHAR(255),
  estado VARCHAR(255),
  PRIMARY KEY (id)
) ;


CREATE TABLE  pedidos (
  id serial NOT NULL,
  data_exclusao timestamp,
  data timestamp,
  idCliente BIGINT NOT NULL,
  status  VARCHAR(50),
  sessao VARCHAR(255),
 
  PRIMARY KEY (id)
) ;



CREATE TABLE  pedidoItens (
  id serial NOT NULL,
  data_exclusao timestamp,
  idPedido BIGINT NOT NULL,
  idProduto BIGINT NOT NULL,
  produto varchar(50),
  quantidade INTEGER,
  valor double precision,
  subtotal double precision,
  PRIMARY KEY (id)
) ;
  

/** CRIACAO DE TABELA DE USUARIOS **/


CREATE TABLE autorizacao (

   ID serial NOT NULL,
   data_exclusao timestamp,
   nome VARCHAR(255),
   PRIMARY KEY (ID)
);

ALTER TABLE autorizacao ADD CONSTRAINT nome UNIQUE(nome);


CREATE TABLE usuario (
  ID serial NOT NULL,
  data_exclusao timestamp,
  senha VARCHAR(255),
  username VARCHAR(255),
  contaExpirada BOOLEAN,
  acessoExpirado BOOLEAN,
  credencialExpirada BOOLEAN,
  ativo BOOLEAN,
  acesso_expirado BOOLEAN ,
  conta_expirada BOOLEAN ,
  credencial_expirada boolean,
  login VARCHAR(255),
  
  PRIMARY KEY (ID)
);


CREATE TABLE USUARIOS_AUTORIZACAO (
   usuario_id serial NOT NULL,
   autorizacao_id BIGINT NOT NULL,
   PRIMARY KEY (usuario_id, autorizacao_id)
);



   ALTER TABLE USUARIOS_AUTORIZACAO ADD CONSTRAINT USUARIOS_AUTORIZACAO_AUTORIZACAO
   FOREIGN KEY (autorizacao_id) REFERENCES autorizacao(ID);

   ALTER TABLE USUARIOS_AUTORIZACAO ADD CONSTRAINT USUARIOS_AUTORIZACAO_USUARIO_
   FOREIGN KEY (usuario_id) REFERENCES usuario(id);
   
   


   
   
   ALTER TABLE produtos ADD CONSTRAINT FK_PRODUTOS_CATEGORIA
   FOREIGN KEY (idCategoria) REFERENCES categorias(id);
 
   
   ALTER TABLE pedidoItens ADD CONSTRAINT FK_PEDIDO_PRODUTOS
   FOREIGN KEY (idProduto) REFERENCES produtos(id);
   
   ALTER TABLE pedidoItens ADD CONSTRAINT FK_PEDIDO_ITENS_PEDIDOS
   FOREIGN KEY (idPedido) REFERENCES pedidos(id);
   
   ALTER TABLE pedidos ADD CONSTRAINT FK_Pedidos_Cliente
   FOREIGN KEY (idCliente) REFERENCES clientes(id);