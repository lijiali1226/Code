delete from Person where id in(select * from (select b.Id from Person a,Person b where a.Email=b.Email and a.Id<b.Id)as temp)