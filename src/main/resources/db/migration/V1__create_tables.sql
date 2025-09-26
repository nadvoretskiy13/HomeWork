CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL
);

CREATE TABLE customer_order (
                                id SERIAL PRIMARY KEY,
                                customer_id INTEGER NOT NULL REFERENCES customer(id) ON DELETE CASCADE,
                                order_date DATE NOT NULL DEFAULT CURRENT_DATE,
                                total_amount NUMERIC(10,2) NOT NULL DEFAULT 0.00,
                                discount NUMERIC(5,2) NOT NULL DEFAULT 0.00
);

CREATE INDEX idx_customer_order_customer_id ON customer_order(customer_id);