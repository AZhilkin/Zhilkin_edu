WITH tmp AS
(SELECT manager_id, subordinates_count FROM(
SELECT manager_id, COUNT(manager_id) AS subordinates_count
FROM employees GROUP BY manager_id) AS T
WHERE subordinates_count > 5)
SELECT first_name, last_name, subordinates_count
FROM 
tmp INNER JOIN employees ON tmp.manager_id=employees.employee_id
ORDER BY employees.employee_id

SELECT departments.department_id, 
department_name, 
ROUND(AVG(salary), 2) AS average_salary, 
COUNT(employee_id) AS employee_count
FROM
departments INNER JOIN employees 
ON departments.department_id = employees.department_id 
GROUP BY departments.department_id
ORDER BY departments.department_id

WITH tmp AS
(SELECT * FROM (SELECT department_id, COUNT(employee_id) AS employee_count 
FROM employees
GROUP BY department_id) AS T
WHERE employee_count > 30)
SELECT departments.department_id, departments.location_id, city, employee_count
FROM 
tmp INNER JOIN departments ON departments.department_id = tmp.department_id
INNER JOIN locations ON locations.location_id = departments.location_id
ORDER BY departments.department_id