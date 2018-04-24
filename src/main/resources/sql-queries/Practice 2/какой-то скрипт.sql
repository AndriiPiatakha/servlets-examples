select groups.paraepostor, groups.amount_students FROM groups
WHERE groups.spec_id in (select specialization.id 
FROM specialization WHERE dep_id = 1);