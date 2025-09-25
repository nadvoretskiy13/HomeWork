-- ==============================
-- Проверка данных в таблицах
-- ==============================

-- Все товары
SELECT * FROM product;

-- Все покупатели
SELECT * FROM customer;

-- Все заказы
SELECT * FROM order_table;

-- Заказы с деталями (покупатель + товар + стоимость)
SELECT
    o.order_date,
    c.name AS customer_name,
    p.description AS product_name,
    o.quantity,
    p.price,
    (o.quantity * p.price) AS total_sum
FROM order_table o
         JOIN customer c ON o.customer_id = c.id
         JOIN product p ON o.product_id = p.id;

-- ==============================
-- Примеры UPDATE (изменение данных)
-- ==============================

-- Изменим цену товара с id=1
UPDATE product SET price = 110.00 WHERE id = 1;

-- Изменим имя покупателя с id=1
UPDATE customer SET name = 'Иван Иванович' WHERE id = 1;

-- Уменьшим остаток товара после покупки
UPDATE product SET quantity = quantity - 2 WHERE id = 1;

-- ==============================
-- Примеры DELETE (удаление данных)
-- ==============================

-- Удалим заказ (товар 10, покупатель 10)
DELETE FROM order_table WHERE product_id = 10 AND customer_id = 10;

-- Удалим товар с id=10
DELETE FROM product WHERE id = 10;

-- Удалим покупателя с id=10
DELETE FROM customer WHERE id = 10;