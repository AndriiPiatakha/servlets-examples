SELECT books.name
FROM books
JOIN readers
ON books.udk = readers.book_udk;