- Create student table
CREATE TABLE student (
    name VARCHAR(255),
    continent VARCHAR(255)
);

-- Insert sample data into student table
INSERT INTO student (name, continent) VALUES
('Jack', 'America'),
('Pascal', 'Europe'),
('Xi', 'Asia'),
('Jane', 'America');
('max','Europe')

-- Group names in continents columns 
SELECT 
    MAX(CASE WHEN s.continent = 'America' THEN s.name ELSE '' END) AS America,
    MAX(CASE WHEN s.continent = 'Asia' THEN s.name ELSE '' END) AS Asia,
    MAX(CASE WHEN s.continent = 'Europe' THEN s.name ELSE '' END) AS Europe
FROM 
    student s
GROUP BY 
    s.name
ORDER BY 
    America, Asia, Europe;