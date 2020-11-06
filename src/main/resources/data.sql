INSERT INTO company (name) VALUES
('Pepsi'),
('Meyers'),
('Nestlé'),
('Merrild'),
('Coop'),
('Skipper');

INSERT INTO product (name, price, description,company_id) VALUES
('Kaffe', 45.0,'Lækker kaffe',4),
('Te', 30.0,'Super te fra Kina',5),
('Is', 22.0,'Kølig Magnum',3),
('Lakridspibe', 5.0,'Skippers Lakridspibe',6),
('Bolcherne', 47.5,'Lækre bolcher fra Køge Nord',5),
('Pepsi Max', 5.0,'Nul kalorier og god smag',1);

/*INSERT INTO companydescription(description,product_id) VALUES ('Næsten ligeså god som Cola',6);
UPDATE product SET companydescription_id = 1 WHERE id = 6;

INSERT INTO companydescription(description,product_id) VALUES
('Masser af kakao og andre chokolade ting',3);
UPDATE product SET companydescription_id = 2 WHERE id = 3;

INSERT INTO companydescription(description,product_id) VALUES
('Masser af kakao og andre chokolade ting',4);
UPDATE product SET companydescription_id = 3 WHERE id = 4;

INSERT INTO companydescription(description,product_id) VALUES
('Kaffe og andre ikke-koffeinholdige produkter',1);
UPDATE product SET companydescription_id = 4 WHERE id = 1;

INSERT INTO companydescription(description,product_id) VALUES
('Kaffe og andre ikke-koffeinholdige produkter',2);
UPDATE product SET companydescription_id = 5 WHERE id = 2;

INSERT INTO companydescription(description,product_id) VALUES
('Et firma der laver ting',5);
UPDATE product SET companydescription_id = 5 WHERE id = 5;
*/
INSERT INTO category (name) VALUES
('Drikkevarer'),
('Slik'),
('Frugt og grønt'),
('Morgenmadsprodukter'),
('Andet');

INSERT INTO category_products (categories_id,products_id) VALUES (1,1);
INSERT INTO category_products (categories_id,products_id) VALUES (1,2);
INSERT INTO category_products (categories_id,products_id) VALUES (2,3);
INSERT INTO category_products (categories_id,products_id) VALUES (2,4);
INSERT INTO category_products (categories_id,products_id) VALUES (2,5);
INSERT INTO category_products (categories_id,products_id) VALUES (1,6);