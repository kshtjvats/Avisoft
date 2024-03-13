use dbtest;
CREATE TABLE SubParent (
    sub_id INT,
    parent_id INT
);

INSERT INTO SubParent (sub_id, parent_id) VALUES
(1, NULL),
(2, NULL),
(1, NULL),
(12, NULL),
(3, 1),
(5, 2),
(3, 1),
(4, 1),
(9, 1),
(10, 2),
(6, 7);

With tab1 as
(
SELECT distinct sub_id,parent_id from SubParent p
where
parent_id is NULL
)
SELECT distinct t.sub_id as 'post id' ,COUNT(DISTINCT p.sub_id) as 'number of comments' FROM tab1 t
LEFT JOIN SubParent p
on t.sub_id=p.parent_id
group by t.sub_id


