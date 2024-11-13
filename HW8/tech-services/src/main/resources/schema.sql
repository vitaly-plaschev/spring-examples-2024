DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS services CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP VIEW IF EXISTS reservations CASCADE;

CREATE TABLE IF NOT EXISTS customers(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	mobile VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS services(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	price DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS orders(
	id SERIAL PRIMARY KEY,
	is_completed BOOLEAN DEFAULT FALSE,
	date_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	customer_id INT REFERENCES customers(id) ON DELETE CASCADE,
	service_id INT REFERENCES services(id) ON DELETE CASCADE
);

CREATE VIEW reservations AS
    SELECT row_number() OVER () AS id, orders.id as order_id, customers.name AS customer_name, services.name AS service_name, orders.date_at, services.price, orders.is_completed, 0 as total_amount
    FROM orders
    INNER JOIN services
        ON orders.service_id = services.id
    INNER JOIN customers
        ON orders.customer_id = customers.id
    ORDER BY orders.id;