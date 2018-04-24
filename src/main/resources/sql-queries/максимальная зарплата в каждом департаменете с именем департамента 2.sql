SELECT name, MAX(salary), dep_name FROM employee e
LEFT JOIN department d
ON e.dep_id = d.id 
GROUP BY dep_id;