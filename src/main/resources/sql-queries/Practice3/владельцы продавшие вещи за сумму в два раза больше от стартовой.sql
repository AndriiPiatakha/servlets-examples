SELECT owners.fname, owners.lname, subject.start_price, basket.last_price
FROM owners, subject, basket
WHERE owners.id = basket.owner_id 
AND subject.id = basket.subject_id
AND basket.sign = 'sold'
AND basket.last_price > 2*subject.start_price;