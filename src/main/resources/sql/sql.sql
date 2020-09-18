DROP DATABASE IF EXISTS webshop;
CREATE DATABASE webshop;

USE webshop;

CREATE TABLE users(
	username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
    );
    
CREATE TABLE authorities(
	username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
		FOREIGN KEY (username)
        REFERENCES users (username)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
	);

CREATE TABLE product(
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	name VARCHAR(30)   NOT NULL,
    price double    NOT NULL,
    description VARCHAR(30) NOT NULL
    );
    
INSERT INTO product VALUES 
(DEFAULT,'Kaffe', 45.0,'Lækker kaffe'),
(DEFAULT,'Te', 30.0,'Super te fra Kina'),
(DEFAULT,'Is', 22.0,'Kølig Magnum'),
(DEFAULT,'Lakridspibe', 5.0,'Skippers Lakridspibe'),
(DEFAULT,'Bolcherne', 47.5,'Lækre bolcher fra Køge Nord'),
(DEFAULT,'Pepsi Max', 5.0,'Nul kalorier og god smag');

INSERT INTO users
(username, password, enabled)
VALUES
("admin", "admin", TRUE);

INSERT INTO authorities
(username, authority)
VALUES
("admin", "ROLE_ADMIN");