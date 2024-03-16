SELECT d.department_id,d.department_name,d.manager_id,m.first_name 
from departments d
join employees m
on d.MANAGER_ID=m.EMPLOYEE_ID
ORDER BY d.DEPARTMENT_ID