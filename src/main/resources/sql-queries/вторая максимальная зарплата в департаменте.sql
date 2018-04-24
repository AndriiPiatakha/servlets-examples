SELECT name, MAX(salary) FROM employee
WHERE salary NOT IN (SELECT MAX(salary) FROM employee);

SELECT name, MAX(salary) as maxS FROM employee WHERE salary NOT IN (SELECT MAX(salary) FROM employee) GROUP BY name ORDER BY maxS DESC LIMIT 1;
