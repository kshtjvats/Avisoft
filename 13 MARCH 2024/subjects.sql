-- Use the database named dbtest
USE dbtest;

-- Create the StudentClass table
CREATE TABLE StudentClass (
    student VARCHAR(1),
    class VARCHAR(20)
);

-- Insert values into the StudentClass table
INSERT INTO StudentClass (student, class) VALUES
('A', 'Math'),
('B', 'English'),
('C', 'Math'),
('D', 'Biology'),
('E', 'Math'),
('F', 'Computer'),
('G', 'Math'),
('H', 'Math'),
('I', 'Math');

-- Select classes with more than 5 students enrolled
SELECT class 
FROM StudentClass 
GROUP BY class
HAVING COUNT(class) > 5;
