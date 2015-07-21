select d.Name as Department,b.Name as Employee,b.Salary as Salary 
from(
    select e.DepartmentId,e.Salary,e.Name,(case when @id<>(@id:=e.DepartmentId) then @i:=0 else @i:=@i+(@sal<>(@sal:=e.Salary)) end)as Rank 
    from Employee e,(select @i:=0,@id:=0,@sal:=(select max(Salary) from Employee)as c)as a 
    order by e.DepartmentId,e.Salary desc)as b,Department d
where b.Rank<3 and d.Id=b.DepartmentId