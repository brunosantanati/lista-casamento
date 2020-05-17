INSERT INTO user(name, email, password) VALUES(
	'Bruno',
	'bruno@gmail.com',
	'$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK'
);

INSERT INTO `role` VALUES ('ROLE_ADMIN'),('ROLE_USER');
INSERT INTO `usuario_authorities` VALUES (1,'ROLE_ADMIN');
