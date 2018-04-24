SELECT department.name, COUNT(students.stud_book) FROM department,groups,specialization,students
WHERE department.id = specialization.dep_id AND specialization.id = groups.spec_id
AND students.group_id = groups.id AND students.form_study = 'distance'
GROUP BY department.name