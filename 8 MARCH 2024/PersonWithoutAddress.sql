-- FirstName, LastName, City, State
CREATE DATABASE TestDb;
USE TestDb;

-- create person table 
CREATE TABLE Person (
PersonId INT PRIMARY KEY,
FirstName VARCHAR(255),
LastName VARCHAR(255)
);

-- create address table
CREATE TABLE Address(
AddressId INT PRIMARY KEY,
PersonID Int,
City VARCHAR(255),
State VARCHAR(255),
FOREIGN KEY (PersonId) REFERENCES Person(PersonID)
);

-- Insert into Person table
INSERT INTO Person (PersonId, FirstName, LastName)
VALUES
    (1, 'John', 'Doe'),
    (2, 'Jane', 'Smith'),
    (3, 'Michael', 'Johnson');

-- Insert data into Address table
INSERT INTO Address (AddressId, PersonId, City, State)
VALUES
    (1, 1, 'New York', 'NY'),
    (2, 2, 'Los Angeles', 'CA');
    
-- query to return firstname, lastName, city, state of every person
SELECT FirstName, LastName, a.City, a.State
FROM Person p
LEFT JOIN Address a ON a.PersonId = p.PersonId