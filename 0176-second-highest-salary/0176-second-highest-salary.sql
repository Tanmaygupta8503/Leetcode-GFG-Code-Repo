SELECT 
    CASE 
        WHEN COUNT(*) < 2 THEN NULL
        ELSE MIN(salary)
    END AS SecondHighestSalary
FROM (
    SELECT distinct salary
    FROM employee
    ORDER BY salary DESC
    LIMIT 2
) AS emp;
