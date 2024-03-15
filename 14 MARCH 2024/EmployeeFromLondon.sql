SELECT e.FIRST_NAME,e.LAST_NAME,e.JOB_ID,d.DEPARTMENT_ID,d.DEPARTMENT_NAME FROM employees e
JOIN departments d
 on
e.DEPARTMENT_ID=d.DEPARTMENT_ID
JOIN locations l
on d.LOCATION_ID=l.location_id
where l.city='London'
