--Host	localhost
--Database	myapp
--DBMS	MySQL
--myapp is a sample MySQL database for customer application for following below mention tables.



--this is customers table script details ,it have id is auto increment
-- customer table is parent table
-- The customers table lists information for all customer.
-- it have id as primary key

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE
);

--this is orders table script details ,it have id is auto increment
-- it is child table with parent table is customers table
-- The orders table lists information for orders.
-- it have id as primary key and customer_id as foreign key map to customers table

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_details VARCHAR(100) NOT NULL,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
--this is address table script details ,it have id is auto increment
--it is child table with parent table is customers table
-- The address table lists information for address of customer.
-- it have id as primary key and customer_id as foreign key map to customers table

CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    line1 VARCHAR(100) NOT NULL,
    line2 VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
     country VARCHAR(100) NOT NULL,
     pin INT
     FOREIGN KEY (customer_id) REFERENCES customers(id)
);