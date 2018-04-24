SELECT a.id, a.fname, COUNT(b.id) as book_written
FROM book_author ba
LEFT JOIN author a
ON (a.id = ba.author_id)
RIGHT JOIN book b
ON (b.id = ba.book_id)
GROUP BY a.fname
HAVING (COUNT(b.id)>=2);
