INSERT INTO usuario (ID, senha, username, contaExpirada, acessoExpirado, credencialExpirada, ativo,acesso_expirado,conta_expirada,credencial_expirada,login)
  
VALUES (1, /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha','adminapi', FALSE, FALSE, FALSE, TRUE,FALSE,FALSE,FALSE,'adminapi');



INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('brasilprev_user_only_read', 'resource-server-rest-api',
 /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha',
 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);
INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('brasilprev_user_all_permission', 'resource-server-rest-api',
 /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha',
 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);