-- Create the database
CREATE DATABASE EIGHT_MARCH;

-- Use the newly created database
USE EIGHT_MARCH;

-- Create the table to store country information
CREATE TABLE Country (
    name VARCHAR(255),
    continent VARCHAR(255),
    area INT,
    population INT,
    gdp INT
);

-- Insert data into the table
INSERT INTO Country (name, continent, area, population, gdp) VALUES 
    ('Afghanistan', 'Asia', 652230, 25500100, 20343000),
    ('Albania', 'Europe', 28748, 2831741, 12960000),
    ('Algeria', 'Africa', 2381741, 37100000, 188681000),
    ('Andorra', 'Europe', 468, 78115, 3712000),
    ('Angola', 'Africa', 1246700, 20609294, 100990000);

-- Retrieve all records from the Country table
SELECT * FROM Country;

-- Retrieve big countries (area > 3 million sq km or population > 25 million)
SELECT 
    name,
    population,
    area
FROM 
    Country
WHERE 
    area > 3000000 OR population > 25000000;
