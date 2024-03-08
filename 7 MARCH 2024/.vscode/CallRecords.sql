-- Create Calls table
CREATE TABLE Calls (
    from_id INT,
    to_id INT,
    duration INT
);

-- Insert sample data into Calls table
INSERT INTO Calls (from_id, to_id, duration) VALUES
(1, 2, 59),
(2, 1, 11),
(1, 3, 20),
(3, 4, 100),
(3, 4, 200),
(3, 4, 200),
(4, 3, 499);

-- select  to report the number of calls and the total call duration between each pair of distinct persons
SELECT 
    CASE WHEN from_id < to_id THEN from_id ELSE to_id END AS person1,
    CASE WHEN from_id < to_id THEN to_id ELSE from_id END AS person2,
    COUNT(*) AS call_count,
    SUM(duration) AS total_duration
FROM Calls
GROUP BY 
    CASE WHEN from_id < to_id THEN from_id ELSE to_id END,
    CASE WHEN from_id < to_id THEN to_id ELSE from_id END;