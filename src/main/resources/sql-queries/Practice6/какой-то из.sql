SELECT * FROM services
WHERE name <> (SELECT distinct s.name as name_one
FROM services s
INNER JOIN clients_services cs
ON s.id = cs.service_id
WHERE month(cs.date_activation) IN (MONTH(curdate()))
);