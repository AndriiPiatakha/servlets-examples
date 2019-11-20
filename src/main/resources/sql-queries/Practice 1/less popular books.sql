SELECT books.name, books.author, count(books.name) as actions_with_book 
FROM history
JOIN books
ON books.udk = history.book_udk
GROUP BY books.name
ORDER BY actions_with_book;