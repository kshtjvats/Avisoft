use dbtest;

CREATE TABLE StudentClass (
    student VARCHAR(1),
    class VARCHAR(20)
);

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

SELECT class from StudentClass 
group by class
having count(class)>5