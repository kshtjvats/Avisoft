use dbtest;
-- Create Customer table
CREATE TABLE Customer (
    customer_id INT,
    product_key INT
);

-- Create Product table
CREATE TABLE Product (
    product_key INT
);

-- Insert values into Customer table
INSERT INTO Customer (customer_id, product_key)
VALUES
    (1, 5),
    (2, 6),
    (3, 5),
    (3, 6),
    (1, 6);

-- Insert values into Product table
INSERT INTO Product (product_key)
VALUES
    (5),
    (6);
SELECT customer_id from
customer
group by customer_id
having
count(distinct product_key)=(select count(*) from product)