select COUNT(*) as distance_student FROM students
WHERE students.form_study = 'distance' and students.group_id in (select specialization.id 
FROM specialization WHERE specialization.dep_id = 1);