SELECT author.id, author.fname, COUNT(author.id) as book_written
FROM book_author ba
INNER JOIN author
ON (author.id = ba.author_id)
GROUP BY author.fname
HAVING (COUNT(author.id)>1);