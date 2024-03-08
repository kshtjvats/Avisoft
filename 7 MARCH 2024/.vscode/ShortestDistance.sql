-- Create the point table
CREATE TABLE point (
    x INT
);

-- Insert sample data into the point table
INSERT INTO point (x) VALUES
(-1),
(0),
(2);

-- Query to find the shortest distance between two points
SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM point p1
JOIN point p2 ON p1.x <> p2.x;