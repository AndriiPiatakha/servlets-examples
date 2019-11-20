SELECT book.title, COUNT(book.id) as written_by
FROM book_author ba
INNER JOIN book
ON (book.id = ba.book_id)
GROUP BY book.title
HAVING (count(book.title)>1);