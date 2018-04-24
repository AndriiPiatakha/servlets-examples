SELECT department.name, SUM(groups.amount_students) FROM department,groups,specialization
WHERE department.id = specialization.dep_id AND specialization.id = groups.spec_id
GROUP BY department.name;