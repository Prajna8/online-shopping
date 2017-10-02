	CREATE TABLE category (
	
		id IDENTITY,
		name VARCHAR(50),
		description VARCHAR(255),
		image_url VARCHAR(50),
		is_active BOOLEAN,
		
		CONSTRAINT pk_category_id PRIMARY KEY(id)

	);
	
INSERT INTO category(name, description, image_url, is_active) VALUES ('LAPTOP', 'this is description for mobile category', 'CAT_1.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('TELEVISION', 'this is description for mobile category', 'CAT_2.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES ('MOBILE', 'this is description for mobile category', 'CAT_3.png', true);

CREATE TABLE user_detail (

id IDENTITY,
first_name 	VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enable BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number)
VALUES ('Frank', 'Lampard','ADMIN','true','admin','fl@gmail.com','888888');

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number)
VALUES ('Eden', 'Hazard','SUPLIER','true','12345','eh@gmail.com','10101010');

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number)
VALUES ('Alvaro', 'Morata','SUPPLIER','true','12345','ra@gmail.com','99999999');


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
	

);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
VALUES ('ILYCFC1','iPhone X','apple','This is the latest phone from apple','89990','1','true','3','2','0','0');

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
VALUES ('ILYCFC2','Samsung S8+','Samsung','This is a smart phone from samsung','64000','2','true','3','3','0','0');

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
VALUES ('ILYCFC3','Oneplus 5 ','Oneplus','This is a smart phone from oneplus','37830','3','true','3','2','0','0');

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
VALUES ('ILYCFC4','Macbook Pro ','apple','This is a Laptop from apple','74000','4','true','1','2','0','0');

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
VALUES ('ILYCFC5','Dell Inspiron ','dell','This is a Laptop from Dell','32000','5','true','1','3','0','0');




