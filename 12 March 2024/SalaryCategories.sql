USE TestDb;

-- create table Accounts
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    income INT
);

-- insert data into the table
INSERT INTO Accounts (account_id, income) VALUES
(3, 108939),
(2, 12747),
(8, 87709),
(6, 91796);

-- SQL query to report the number of bank accounts of each salary category
SELECT 
    'Low Salary' AS category,
    COUNT(CASE WHEN income < 20000 THEN account_id ELSE NULL END) AS accounts_count
FROM 
    Accounts
UNION 
SELECT 
    'Average Salary' AS category,
    COUNT(CASE WHEN income >= 20000 AND income <= 50000 THEN account_id ELSE NULL END) AS accounts_count
FROM 
    Accounts
UNION 
SELECT 
    'High Salary' AS category,
    COUNT(CASE WHEN income > 50000 THEN account_id ELSE NULL END) AS accounts_count
FROM 
    Accounts;