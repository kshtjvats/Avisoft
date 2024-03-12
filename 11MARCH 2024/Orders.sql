USE TestDb;

-- create table Orders
CREATE TABLE Orders
(
order_number INT PRIMARY KEY,
customer_number INT
);

-- insert data in orders table
INSERT INTO Orders(order_number, customer_number) VALUES
(1,1),
(2,2),
(3,3),
(4,3);

-- query to find the customer_number for the customer who has placed the largest number of orders.
SELECT 
    customer_number
FROM
    Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;