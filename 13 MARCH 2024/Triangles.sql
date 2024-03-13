-- Use a created database named dbtest
USE dbtest;

-- Create a table named my_table with columns x, y, and z to store triangle side lengths
CREATE TABLE my_table (
    x INT,
    y INT,
    z INT
);

-- Insert sample triangle side lengths into the my_table
INSERT INTO my_table (x, y, z) VALUES (13, 15, 30);
INSERT INTO my_table (x, y, z) VALUES (10, 20, 15);
INSERT INTO my_table(x, y, z) VALUES(5, 12, 13);

-- Query to determine if each set of sides forms a triangle or not
SELECT x, y, z, 'Yes' as triangle 
FROM my_table
WHERE 
    x < y + z AND 
    y < x + z AND 
    z < x + y
UNION
SELECT x, y, z, 'No' as triangle 
FROM my_table
WHERE 
    x >= y + z OR 
    y >= x + z OR 
    z >= x + y;

/* 
-- Alternative query using Pythagoras' theorem
SELECT x, y, z, 'Yes' as triangle 
FROM my_table
WHERE 
    CASE 
        WHEN GREATEST(x, y, z) = x THEN x*x = y*y + z*z
        WHEN GREATEST(x, y, z) = y THEN y*y = x*x + z*z
        ELSE z*z = x*x + y*y
    END
UNION
SELECT x, y, z, 'No' as triangle 
FROM my_table
WHERE 
    CASE
        WHEN GREATEST(x, y, z) = x THEN x*x != y*y + z*z
        WHEN GREATEST(x, y, z) = y THEN y*y != x*x + z*z
        ELSE z*z != x*x + y*y
    END;
*/
