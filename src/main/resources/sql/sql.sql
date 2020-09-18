DROP DATABASE IF EXISTS webshop;
CREATE DATABASE webshop;

USE webshop;

CREATE TABLE users(
	username VARCHAR(50) PRIMARY KEY NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled TINYINT(1) NOT NULL DEFAULT 1
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
    
CREATE TABLE company(
	id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100) NOT NULL
	);
    
CREATE TABLE category(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
	);

CREATE TABLE product(
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	name VARCHAR(30)   NOT NULL,
    price double    NOT NULL,
    description VARCHAR(30) NOT NULL,
    company_id INT,
	category_id INT,
        CONSTRAINT fk_product_company
			FOREIGN KEY (company_id)
			REFERENCES company (id)
			ON DELETE NO ACTION
			ON UPDATE NO ACTION,
		CONSTRAINT fk_product_category
			FOREIGN KEY (category_id)
			REFERENCES category (id)
			ON DELETE NO ACTION
			ON UPDATE NO ACTION
    );

INSERT INTO users
(username, password, enabled)
VALUES
("admin", "admin", TRUE);

INSERT INTO authorities
(username, authority)
VALUES
("admin", "ROLE_ADMIN");

INSERT INTO company VALUES
(DEFAULT,'Pepsi'),
(DEFAULT,'Meyers'),
(DEFAULT,'Nestlé'),
(DEFAULT,'Merrild'),
(DEFAULT,'Coop'),
(DEFAULT,'Skipper');
    
INSERT INTO category VALUES
(DEFAULT,'Drikkevarer'),
(DEFAULT,'Slik'),
(DEFAULT,'Frugt og grønt'),
(DEFAULT,'Morgenmadsprodukter'),
(DEFAULT,'Andet');
    
INSERT INTO product VALUES
(DEFAULT,'Kaffe', 45.0,'Lækker kaffe',4,1),
(DEFAULT,'Te', 30.0,'Super te fra Kina',5,1),
(DEFAULT,'Is', 22.0,'Kølig Magnum',3,2),
(DEFAULT,'Lakridspibe', 5.0,'Skippers Lakridspibe',6,2),
(DEFAULT,'Bolcherne', 47.5,'Lækre bolcher fra Køge Nord',5,2),
(DEFAULT,'Pepsi Max', 5.0,'Nul kalorier og god smag',1,1);