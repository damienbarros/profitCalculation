INSERT INTO shipment (id, reference_number, profit_or_loss)
VALUES
(1, 'shipment1', 0.00);

INSERT INTO customer (id, name, payment_amount, shipment_id)
VALUES
(1, 'customer1', 1200.00, 1),
(2, 'customer2', 800.00, 1);

INSERT INTO service_provision (id, description, cost_amount, shipment_id)
VALUES
(1, 'Fuel Costs', 300.00, 1),
(2, 'Handling Fees', 100.00, 1),
(3, 'Maintenance', 50.00, 1);
