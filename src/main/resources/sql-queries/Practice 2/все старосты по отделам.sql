SELECT groups.paraepostor, specialization.name 
FROM groups
INNER JOIN specialization
ON groups.spec_id = specialization.id
GROUP BY spec_id;