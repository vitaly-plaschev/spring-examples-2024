CREATE TABLE users(
user_id serial PRIMARY KEY,
username VARCHAR (50) UNIQUE NOT NULL,
password VARCHAR (50) NOT NULL,
email VARCHAR (255) UNIQUE NOT NULL
);


INSERT INTO users (username, password, email)
VALUES('Test', 'Test123', 'test@test.com')

select * from users;



CREATE TABLE customers(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	email VARCHAR(255),
	address VARCHAR(255),
	state VARCHAR(255),
	city VARCHAR(255),
	zip_code VARCHAR(255)
);

insert into customers (first_name, last_name, email, address, city, state, zip_code ) VALUES
('John2', 'Dow2', 'jdow2@test.com', 'address 2', 'city 2', 'state 2', 'zio 2'),
('John3', 'Dow3', 'jdow3@test.com', 'address 3', 'city 3', 'state 3', 'zio 3'),
('John4', 'Dow4', 'jdow4@test.com', 'address 4', 'city 4', 'state 4', 'zio 4'),
('John5', 'Dow5', 'jdow5@test.com', 'address 5', 'city 5', 'state 5', 'zio 5'),
('John6', 'Dow6', 'jdow6@test.com', 'address 6', 'city 6', 'state 6', 'zio 6')


UPDATE customers
SET email = 'testnew@testnew.com'
WHERE id = 3

DELETE FROM customers
where id = 3


ALTER TABLE customers ADD test_col VARCHAR(255)

ALTER TABLE customers
ALTER COLUMN test_col TYPE VARCHAR(4);

ALTER TABLE customers
DROP COLUMN test_col;


select first_name, last_name from customers where age < 30

select * from customers where city LIKE '%y 5'


CREATE TABLE products(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	price INT
);

insert into products (name, price) VALUES
('Product 1', 3),
('Product 2', 7),
('Product 3', 100),
('Product 4', 65),
('Product 5', 45),
('Product 6', 32);

CREATE TABLE orders(
	id SERIAL PRIMARY KEY,
	order_number INT,
	product_id INT REFERENCES products(id),
	customer_id INT REFERENCES customers(id),
	age INT,
	order_date DATE DEFAULT CURRENT_TIMESTAMP
);

insert into orders (order_number, product_id, customer_id, age) VALUES
(001,1, 4, 1),
(002,3, 1, 2),
(003,1, 1, 2),
(004,1, 2, 2),
(005,1, 1, 2),
(006,4, 6, 2),
(007,4, 4, 2),
(008,4, 6, 2),
(009,2, 5, 2);


select customers.first_name, customers.last_name, orders.id, orders.order_number
from customers
INNER JOIN  orders
ON customers.id = orders.customer_id
ORDER BY customers.last_name

select customers.first_name, customers.last_name, orders.order_number, orders.order_date
from customers
INNER JOIN  orders
ON customers.id = orders.customer_id
ORDER BY customers.last_name

select orders.order_number, customers.first_name, customers.last_name, products.name
from orders
INNER JOIN products
    on orders.product_id = products.id
INNER JOIN customers
    on orders.customer_id = customers.id
order by orders.order_number;

select age, COUNT(age)
from customers
where age > 30
GROUP BY age;
