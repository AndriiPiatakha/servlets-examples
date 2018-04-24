SELECT owners.fname, owners.lname, COUNT(bought.owner_id) 
FROM owners, bought
WHERE owners.id = bought.owner_id 
AND YEAR(bought.date_bought) = YEAR(curdate())
GROUP BY bought.owner_id 
HAVING COUNT(bought.owner_id) >= 2;