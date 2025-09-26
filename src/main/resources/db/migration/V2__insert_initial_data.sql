INSERT INTO customer (first_name, last_name) VALUES
                                                 ('Иван', 'Иванов'),
                                                 ('Мария', 'Петрова'),
                                                 ('Алексей', 'Сидоров');

INSERT INTO customer_order (customer_id, total_amount, discount) VALUES
                                                                     (1, 1200.50, 5.00),
                                                                     (2, 300.00, 0.00),
                                                                     (3, 750.00, 10.00);