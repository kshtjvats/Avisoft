USE TestDb;

-- create table my_numbers
CREATE TABLE my_numbers(num INT);

-- Insert sample data into the table my_numbers
INSERT INTO my_numbers (num) VALUES
(8),
(8),
(3),
(3),
(1),
(4),
(5),
(6);
                        
--  query to find the biggest number, which only appears once
SELECT 
    num
FROM
    my_numbers
GROUP BY num
HAVING COUNT(num) = 1
ORDER BY num DESC
LIMIT 1;