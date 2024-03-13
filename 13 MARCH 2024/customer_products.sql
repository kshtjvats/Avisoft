-- Use the database named dbtest
USE dbtest;

-- Create the Customer table
CREATE TABLE Customer (
    customer_id INT,
    product_key INT
);

-- Create the Product table
CREATE TABLE Product (
    product_key INT
);

-- Insert values into the Customer table
INSERT INTO Customer (customer_id, product_key)
VALUES
    (1, 5),
    (2, 6),
    (3, 5),
    (3, 6),
    (1, 6);

-- Insert values into the Product table
INSERT INTO Product (product_key)
VALUES
    (5),
    (6);

-- Select customer IDs who have purchased all products
SELECT customer_id 
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);
