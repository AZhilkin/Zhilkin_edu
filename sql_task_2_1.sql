Insert into employees (employee_id,
                      first_name,
                      last_name,
                      email,
                      job_id,
                      salary,
                      manager_id,
                      department_id, 
                      hire_date) 
select nextval('employees_employee_id_seq'), 
        'Alexandr', 
        'Zhilkin',
        'AZHILKIN',
        'IT_PROG',
        trunc(random()*1800 + 4200),
        manager_id,
        60,
        date(now())
        from departments where department_id = 60;
                              
