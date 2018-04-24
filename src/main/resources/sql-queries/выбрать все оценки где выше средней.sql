SELECT name, mark from students
WHERE mark > (SELECT AVG(mark) FROM students);