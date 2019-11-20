SELECT country, COUNT(country) as operators_amount 
FROM rouming_operators
group by country
HAVING (count(country) > 3);