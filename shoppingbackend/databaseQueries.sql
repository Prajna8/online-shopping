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
enabled BOOLEAN,
password VARCHAR(60),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Frank', 'Lampard','ADMIN','true','$2y$10$bkwm.wXgLtMYeBI0zdRLEO.efSKmJLfRR966isSY95MMLizhf1GbO','fl@gmail.com','888888');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Eden', 'Hazard','SUPLIER','true','$2y$10$ZcZn2k8kwMDO4GlY1vXVZOMWLJlMXz8JEnv9Rxp7aIfAkna7qtwXm','eh@gmail.com','10101010');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Alvaro', 'Morata','SUPPLIER','true','$2y$10$5AkdhRu4Dsji8U8MpOPN7.8jA4J5lozLseD2vPS.ZJGmwDQ/THedy','ra@gmail.com','99999999');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('test', 'ok','ADMIN','true','$2y$10$zQzyzD/yOqVnTaYRa0aLAOZ9028nDgAX5E5O54jb11BsW/Gz330z6','ram@gmail.com','9810000000');

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

-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (2, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
)
-- adding a cart for testing 
--so far error null value false
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (null, 0, 0);

CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);


-- the order detail table to store the order

CREATE TABLE order_detail (
	id IDENTITY,
	user_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);

-- the order item table to store order items

CREATE TABLE order_item (
	id IDENTITY,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);
