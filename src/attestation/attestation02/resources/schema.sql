-- Очищаем схему public (удаляются все таблицы, если они были)
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- ==============================
-- Таблица товаров
-- ==============================
CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       description VARCHAR(100) NOT NULL,
                                       price DECIMAL(10,2) NOT NULL,
                                       quantity INT NOT NULL
);

-- ==============================
-- Таблица покупателей
-- ==============================
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL
);

-- ==============================
-- Таблица заказов
-- ==============================
CREATE TABLE IF NOT EXISTS order_table (
                                           product_id INT REFERENCES product(id),
                                           customer_id INT REFERENCES customer(id),
                                           order_date DATE NOT NULL,
                                           quantity INT NOT NULL,
                                           PRIMARY KEY (product_id, customer_id, order_date)
);

-- ==============================
-- Заполняем таблицы данными
-- ==============================

-- Товары
INSERT INTO product (description, price, quantity) VALUES
                                                       ('Ноутбук', 1200.00, 5),
                                                       ('Смартфон', 800.00, 10),
                                                       ('Планшет', 600.00, 7),
                                                       ('Наушники', 150.00, 20),
                                                       ('Монитор', 300.00, 8),
                                                       ('Клавиатура', 50.00, 15),
                                                       ('Мышь', 40.00, 30),
                                                       ('Принтер', 200.00, 4),
                                                       ('Веб-камера', 90.00, 12),
                                                       ('Колонка', 120.00, 9);

INSERT INTO customer (name) VALUES
                                ('Иван Иванов'),
                                ('Петр Петров'),
                                ('Сергей Сергеев'),
                                ('Анна Смирнова'),
                                ('Ольга Кузнецова'),
                                ('Дмитрий Сидоров'),
                                ('Елена Попова'),
                                ('Алексей Морозов'),
                                ('Мария Волкова'),
                                ('Николай Федоров');

INSERT INTO order_table (product_id, customer_id, order_date, quantity) VALUES
                                                                            (1, 1, '2025-09-23', 2),
                                                                            (2, 2, '2025-09-23', 1),
                                                                            (3, 3, '2025-09-23', 5),
                                                                            (4, 4, '2025-09-23', 2),
                                                                            (5, 5, '2025-09-23', 10),
                                                                            (6, 6, '2025-09-23', 3),
                                                                            (7, 7, '2025-09-23', 4),
                                                                            (8, 8, '2025-09-23', 2),
                                                                            (9, 9, '2025-09-23', 6),
                                                                            (10, 10, '2025-09-23', 1);