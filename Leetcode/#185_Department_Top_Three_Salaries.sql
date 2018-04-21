# Write your MySQL query statement below
SELECT D.Name AS Department, E.Name AS Employee, E.Salary 
FROM Department D, Employee E, Employee E2  
WHERE D.ID = E.DepartmentId AND E.DepartmentId = E2.DepartmentId AND 
E.Salary <= E2.Salary
GROUP BY D.ID,E.Name HAVING COUNT(DISTINCT E2.Salary) <= 3
ORDER BY D.Name, E.Salary DESC