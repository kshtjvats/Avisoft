USE TestDb;
-- create table
CREATE TABLE Scores (
    Id INT,
    Score DECIMAL(4, 2)
);
-- insert into the table
INSERT INTO Scores (Id, Score)
VALUES
    (1, 3.50),
    (2, 3.65),
    (3, 4.00),
    (4, 3.85),
    (5, 4.00),
    (6, 3.65);
    
-- query to return ranked scores
SELECT Score, DENSE_RANK() OVER (ORDER BY Score DESC) AS Rank
FROM Scores 
ORDER BY Score DESC;