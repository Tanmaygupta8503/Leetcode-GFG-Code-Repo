CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N = N - 1;
  RETURN (
    SELECT DISTINCT salary 
    FROM Employee
    ORDER BY salary DESC
    LIMIT N, 1
  );
END;
