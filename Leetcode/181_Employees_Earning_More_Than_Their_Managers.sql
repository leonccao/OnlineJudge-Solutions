# Write your MySQL query statement below
SELECT E1.Name AS Employee
FROM Employee AS E1, Employee AS E2
WHERE E1.ManagerId = E2.Id and E1.Salary > E2.Salary