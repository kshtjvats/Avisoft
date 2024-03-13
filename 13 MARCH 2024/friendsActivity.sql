Use dbtest;

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


WITH Activitycount AS
(
SELECT activity,count(*) AS num 
FROM friends
group by activity
)
SELECT activity from Activitycount
where num not in
(
SELECT MAX(num) from Activitycount
union
SELECT MIN(num) from Activitycount
);

