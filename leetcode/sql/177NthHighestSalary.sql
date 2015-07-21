CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
     select c.Salary from(select Salary,@i:=@i+1 as rank from (select @i:=0)as a, (select Salary from Employee group by Salary)as b order by Salary desc)as c where c.rank=N
  );
END