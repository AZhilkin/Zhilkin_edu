Update employees
set salary = salary*2, manager_id = t.manager_id
from (
    select manager_id
    from employees 
    where employee_id = (select manager_id from employees 
                         where (first_name = 'Alexandr' 
                                and last_name = 'Zhilkin')
                         )
    )as t
where (first_name = 'Alexandr' and last_name = 'Zhilkin')