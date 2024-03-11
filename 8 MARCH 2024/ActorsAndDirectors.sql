-- create table
CREATE TABLE ActorDirector (
    actor_id INT,
    director_id INT,
    timestamp INT,
    PRIMARY KEY (timestamp)
);

-- insert in table
INSERT INTO ActorDirector (actor_id, director_id, timestamp)
VALUES
    (1, 1, 0),
    (1, 1, 1),
    (1, 1, 2),
    (1, 2, 3),
    (1, 2, 4),
    (2, 1, 5),
    (2, 1, 6);
    
-- query to return the actor and director id where they have worked together 3 or more times.
SELECT actor_id, director_id 
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >=3;