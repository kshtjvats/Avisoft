use dbtest;
CREATE TABLE emails(
    Id INT,
    Email VARCHAR(255)
);

INSERT INTO emails (Id, Email) VALUES (1, 'a@b.com');
INSERT INTO emails (Id, Email) VALUES (2, 'c@d.com');
INSERT INTO emails (Id, Email) VALUES (3, 'a@b.com');

SELECT Email
FROM emails
GROUP BY Email
HAVING COUNT(*) > 1;