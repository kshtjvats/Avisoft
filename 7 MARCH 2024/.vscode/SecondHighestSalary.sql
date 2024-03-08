-- Create Employee table
CREATE TABLE Employee (
    Id INT PRIMARY KEY,
    Salary INT
);

-- Insert sample data into Employee table
INSERT INTO Employee (Id, Salary) VALUES
(1, 100),
(2, 200),
(3, 300);

-- select secondHighestSalary
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);