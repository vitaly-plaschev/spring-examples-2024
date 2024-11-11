insert into customers (name, mobile) VALUES
('Name1', '+7 911 111-11-11'),
('Name2', '+7 911 111-11-12'),
('Name3', '+7 911 111-11-13'),
('Name4', '+7 911 111-11-14'),
('Name5', '+7 911 111-11-15'),
('Name6', '+7 911 111-11-16'),
('Name7', '+7 911 111-11-17'),
('Name8', '+7 911 111-11-18'),
('Name9', '+7 911 111-11-19'),
('Name10', '+7 911 111-11-00');

insert into services (name, price) VALUES
('Computer hardware check & repair', 1499.99),
('Software update', 1000),
('Digital appliances check & repair', 2380),
('Electricity & water meters validation', 700),
('Furniture assembling', 800),
('TV repair', 1000);

insert into orders (date_at, customer_id, service_id) VALUES
('2024-10-01T12:45:00', 1, 1),
('2024-11-01T14:00:00', 2, 2),
('2024-12-01T15:00:00', 3, 1),
('2024-11-01T14:30:00', 4, 3),
('2024-11-03T10:00:00', 4, 4),
('2024-11-04T09:00:00', 5, 6);
