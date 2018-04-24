SELECT department.name, SUM(groups.amount_students),
(SELECT COUNT(students.stud_book) AS num
FROM students,specialization,groups
WHERE students.form_study = 'distance'
AND groups.id = students.group_id AND department.id = specialization.dep_id
AND groups.spec_id = specialization.id
GROUP BY department.name) AS distance
FROM
department,groups,specialization
WHERE department.id = specialization.dep_id AND specialization.id = groups.spec_id
GROUP BY department.name
HAVING SUM(groups.amount_students)/distance < 2