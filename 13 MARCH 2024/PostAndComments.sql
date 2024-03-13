-- Use the database named dbtest
USE dbtest;

-- Create the SubParent table
CREATE TABLE SubParent (
    sub_id INT,
    parent_id INT
);

-- Insert values into the SubParent table
INSERT INTO SubParent (sub_id, parent_id) VALUES
(1, NULL),
(2, NULL),
(1, NULL),
(12, NULL),
(3, 1),
(5, 2),
(3, 1),
(4, 1),
(9, 1),
(10, 2),
(6, 7);

-- Common Table Expression (CTE) to select distinct posts with NULL parent_id (top-level posts)
WITH tab1 AS (
    SELECT DISTINCT sub_id, parent_id 
    FROM SubParent 
    WHERE parent_id IS NULL
)

-- Select the count of comments for each post
SELECT DISTINCT t.sub_id AS 'post id', COUNT(DISTINCT p.sub_id) AS 'number of comments' 
FROM tab1 t
LEFT JOIN SubParent p ON t.sub_id = p.parent_id
GROUP BY t.sub_id;
