-- Create the FatProducts table
CREATE TABLE FatProducts (
    product_id INT,
    low_fats CHAR(1),
    recyclable CHAR(1)
);

-- Insert values into the FatProducts table
INSERT INTO FatProducts (product_id, low_fats, recyclable) VALUES
    (0, 'Y', 'N'),
    (1, 'Y', 'Y'),
    (2, 'N', 'Y'),
    (3, 'Y', 'Y'),
    (4, 'N', 'N');

-- Select product IDs of products that are low in fats and recyclable
SELECT product_id 
FROM FatProducts
WHERE low_fats = 'Y' AND recyclable = 'Y';
