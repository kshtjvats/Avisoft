USE TestDb;
-- create playback table
CREATE TABLE Playback(
				session_id INT PRIMARY KEY AUTO_INCREMENT,
                customer_id INT,
                start_time INT,
                end_time INT);
-- insert into Playback table
INSERT INTO Playback (customer_id, start_time, end_time) VALUES
															(1,1,5),
                                                            (1,15,23),
                                                            (2,10,12),
                                                            (2,17,28),
                                                            (2,2,8);

-- create ads table
CREATE TABLE Ads(
				ad_id INT PRIMARY KEY AUTO_INCREMENT,
                customer_id INT,
                timestamp INT);

-- insert data in ads table
INSERT INTO Ads (customer_id, timestamp) VALUES
											(1,5),
                                            (2,17),
                                            (2,20);

-- select session id of sessions that are not shown any sessions                                            
SELECT DISTINCT (session_id) 
FROM Playback p
JOIN Ads a USING (customer_id) 
WHERE a.timestamp NOT BETWEEN p.start_time AND p.end_time;