-- Create Playback table
CREATE TABLE Playback (
    session_id INT PRIMARY KEY,
    customer_id INT,
    start_time INT,
    end_time INT
);

-- Insert sample data into Playback table
INSERT INTO Playback (session_id, customer_id, start_time, end_time) VALUES
(1, 1, 1, 5),
(2, 1, 15, 23),
(3, 2, 10, 12),
(4, 2, 17, 28),
(5, 2, 2, 8);

-- Create Ads table
CREATE TABLE Ads (
    ad_id INT PRIMARY KEY,
    customer_id INT,
    timestamp INT
);

-- Insert sample data into Ads table
INSERT INTO Ads (ad_id, customer_id, timestamp) VALUES
(1, 1, 5),
(2, 2, 17),
(3, 2, 20);

-- select session_id where no ads are shown
SELECT session_id
FROM Playback
WHERE session_id NOT IN (
    SELECT DISTINCT p.session_id
    FROM Playback p
    JOIN Ads a ON p.customer_id = a.customer_id
    WHERE a.timestamp BETWEEN p.start_time AND p.end_time
);