-- Use the database named dbtest
USE dbtest;

-- Create the Friends table
CREATE TABLE Friends (
    id INT,
    name VARCHAR(255),
    activity VARCHAR(255)
);

-- Insert entries into the Friends table
INSERT INTO Friends (id, name, activity) VALUES
(1, 'Jonathan D.', 'Eating'),
(2, 'Jade W.', 'Singing'),
(3, 'Victor J.', 'Singing'),
(4, 'Elvis Q.', 'Eating'),
(5, 'Daniel A.', 'Eating'),
(6, 'Bob B.', 'Horse Riding');

-- Create the Activities table
CREATE TABLE Activities (
    id INT,
    name VARCHAR(255)
);

-- Insert entries into the Activities table
INSERT INTO Activities (id, name) VALUES
(1, 'Eating'),
(2, 'Singing'),
(3, 'Horse Riding');

-- Common Table Expression (CTE) to count the number of participants for each activity
WITH Activity_count AS (
    SELECT activity, COUNT(*) AS num 
    FROM Friends
    GROUP BY activity
)

-- Select activities with neither the maximum nor the minimum number of participants
SELECT activity 
FROM Activity_count
WHERE num NOT IN (
    SELECT MAX(num) FROM Activity_count 
    UNION
    SELECT MIN(num) FROM Activity_count
);
