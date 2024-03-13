CREATE TABLE FatProducts (
    product_id INT,
    low_fats CHAR(1),
    recyclable CHAR(1)
);
INSERT INTO FatProducts (product_id, low_fats, recyclable) VALUES
    (0, 'Y', 'N'),
    (1, 'Y', 'Y'),
    (2, 'N', 'Y'),
    (3, 'Y', 'Y'),
    (4, 'N', 'N');

SELECT product_id from FatProducts
where
low_fats='Y' and recyclable='Y'