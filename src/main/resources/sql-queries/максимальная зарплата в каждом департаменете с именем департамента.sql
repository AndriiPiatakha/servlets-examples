SELECT name, MAX(salary), dep_name FROM employee, department
WHERE dep_id = department.id 
GROUP BY dep_id;