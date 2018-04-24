SELECT book.title, author.fname
from book_author ba
INNER JOIN book
ON (book.id = ba.book_id)
INNER JOIN author
ON (author.id = ba.author_id)
