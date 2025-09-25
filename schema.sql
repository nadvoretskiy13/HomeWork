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
                                                       ('Товар 1', 100.00, 10),
                                                       ('Товар 2', 200.50, 20),
                                                       ('Товар 3', 150.75, 15),
                                                       ('Товар 4', 300.00, 5),
                                                       ('Товар 5', 50.00, 50),
                                                       ('Товар 6', 120.00, 12),
                                                       ('Товар 7', 75.00, 25),
                                                       ('Товар 8', 220.00, 8),
                                                       ('Товар 9', 90.00, 18),
                                                       ('Товар 10', 180.00, 7);

-- Покупатели
INSERT INTO customer (name) VALUES
                                ('Иван Иванов'),
                                ('Пётр Петров'),
                                ('Сергей Сергеев'),
                                ('Алексей Алексеев'),
                                ('Мария Смирнова'),
                                ('Анна Кузнецова'),
                                ('Елена Попова'),
                                ('Дмитрий Соколов'),
                                ('Ольга Васильева'),
                                ('Николай Николаев');

-- Заказы
INSERT INTO order_table (product_id, customer_id, order_date, quantity) VALUES
                                                                            (1, 1, '2025-09-23', 2),
                                                                            (2, 2, '2025-09-23', 1),
                                                                            (3, 3, '2025-09-23', 5),
                                                                            (4, 4, '2025-09-23', 1),
                                                                            (5, 5, '2025-09-23', 10),
                                                                            (6, 6, '2025-09-23', 3),
                                                                            (7, 7, '2025-09-23', 4),
                                                                            (8, 8, '2025-09-23', 2),
                                                                            (9, 9, '2025-09-23', 6),
                                                                            (10, 10, '2025-09-23', 1);
