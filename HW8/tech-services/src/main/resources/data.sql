insert into customers (first_name, last_name, email, address, city, state, zip_code ) VALUES
('Name1', 'Lastname1', 'email1@test.com', 'address 1', 'city 1', 'state 1', 'zio 1'),
('Name2', 'Lastname2', 'email2@test.com', 'address 2', 'city 2', 'state 2', 'zio 2'),
('Name3', 'Lastname3', 'email3@test.com', 'address 3', 'city 3', 'state 3', 'zio 3'),
('Name4', 'Lastname4', 'email4@test.com', 'address 4', 'city 4', 'state 4', 'zio 4'),
('Name5', 'Lastname5', 'email5@test.com', 'address 5', 'city 5', 'state 5', 'zio 5'),
('Name6', 'Lastname6', 'email6@test.com', 'address 6', 'city 6', 'state 6', 'zio 6');

insert into products (name, price) VALUES
('Product 1', 3),
('Product 2', 7),
('Product 3', 100),
('Product 4', 65),
('Product 5', 45),
('Product 6', 32);

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