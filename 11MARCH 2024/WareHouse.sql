USE TestDb;

-- create products table
CREATE TABLE Products (
				product_id INT PRIMARY KEY,
				product_name VARCHAR(255),
                width INT,
                length INT,
                height INT
               );

-- insert into products table
INSERT INTO Products (product_id, product_name, Width, Length, Height)
VALUES
    (1, 'LC-TV', 5, 50, 40),
    (2, 'LC-KeyChain', 5, 5, 5),
    (3, 'LC-Phone', 2, 10, 10),
    (4, 'LC-T-Shirt', 4, 10, 20);

-- create warehouse table
CREATE TABLE Warehouse(
					name VARCHAR(255),
                    product_id INT,
					units INT,
					PRIMARY KEY (name, product_id), -- composite key
					FOREIGN KEY (product_id) REFERENCES Products(product_id) -- foreign key constraint
                    );
-- insert in Warehouse table
INSERT INTO Warehouse (name, product_id, units) VALUES
										('LCHouse1',1, 1),
                                        ('LCHouse1',2, 10),
                                        ('LCHouse1',3, 5),
                                        ('LCHouse2',1, 2),
                                        ('LCHouse2',2, 2),
                                        ('LCHouse3',4, 1);

-- query to return the volume that the inventory occupy in each warehouse
WITH ProductVolumes AS (
	SELECT 	
		p.product_id,
		p.product_name,
        p.width * p.height * p.length AS Volume
	FROM 
		Products p
)
SELECT 
    w.name AS warehouse_name, 
    SUM(pv.volume * w.units) AS volume
FROM
    Warehouse w
        JOIN
    ProductVolumes pv ON w.product_id = pv.product_id
GROUP BY w.name;   -- The GROUP BY clause groups the result set by the name column of the Warehouse table, ensuring that the SUM function is applied to each warehouse separately.