# Write your MySQL query statement below
SELECT DISTINCT P1.Email
FROM Person AS P1, Person AS P2
WHERE P1.Email = P2.Email and P1.Id < P2.Id