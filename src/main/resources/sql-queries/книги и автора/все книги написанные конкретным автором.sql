SELECT author.fname, book.title
FROM book_author ba
LEFT JOIN author
ON (author.id = ba.author_id)
RIGHT JOIN book
ON (book.id = ba.book_id)
WHERE author.fname = 'John';