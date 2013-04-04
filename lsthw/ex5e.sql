INSERT INTO person(id, first_name, last_name, age)
    VALUES(1, "JIALI", "LI", 21);
INSERT INTO person(id, first_name, last_name, age)
    VALUES(2, "AUGUST", "RUSH", 10);

SELECT * FROM pet WHERE age > 10;
SELECT id, age FROM person WHERE age < 21;
SELECT * FROM person WHERE first_name = "Zed" AND age > 30;
SELECT id, age FROM person WHERE first_name = "Zed" AND age > 30 OR age < 20;
