SELECT pi.client_id, pi.name, pi.addres, pi.region 
FROM personal_info pi
INNER JOIN clients_services cs
ON cs.client_id = pi.client_id
WHERE (TO_DAYS(curdate()) - TO_DAYS(cs.date_activation)) > 365;