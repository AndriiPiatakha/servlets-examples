select department.name, (select COUNT(*) as distance_student FROM students
WHERE students.form_study = 'distance' and students.group_id in (select specialization.id 
FROM specialization WHERE specialization.dep_id = department.id)) 
as distance_students
from department
WHERE (select COUNT(*) as distance_student FROM students
WHERE students.form_study = 'distance' and students.group_id in (select specialization.id 
FROM specialization WHERE specialization.dep_id = department.id)) > (select SUM(groups.amount_students)/2 from groups);