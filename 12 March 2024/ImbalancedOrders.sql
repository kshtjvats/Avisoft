use TestDb;

-- Create the OrdersDetails table
CREATE TABLE OrdersDetails (
    order_id INT,
    product_id INT,
    quantity INT,
    PRIMARY KEY (order_id, product_id)
);

-- Insert data into the OrdersDetails table
INSERT INTO OrdersDetails (order_id, product_id, quantity) VALUES
(1, 1, 12),
(1, 2, 10),
(1, 3, 15),
(2, 1, 8),
(2, 4, 4),
(2, 5, 6),
(3, 3, 5),
(3, 4, 18),
(4, 5, 2),
(4, 6, 8),
(5, 7, 9),
(5, 8, 9),
(3, 9, 20),
(2, 9, 4);

-- query to return the imbalanced order ids
WITH OrderStats AS (
    SELECT 
        order_id,
        COUNT(DISTINCT product_id) AS num_products,
        SUM(quantity) AS total_quantity,
        MAX(quantity) AS max_quantity
    FROM 
        OrdersDetails
    GROUP BY 
        order_id
),
AverageMax AS (
    SELECT 
        order_id,
        total_quantity / num_products AS average_quantity,
        max_quantity
    FROM 
        OrderStats
)
SELECT 
    order_id
FROM 
    AverageMax
WHERE 
    max_quantity > ALL (SELECT average_quantity FROM AverageMax);