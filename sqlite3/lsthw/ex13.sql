ALTER TABLE person ADD COLUMN dead INTEGER;
ALTER TABLE person ADD COLUMN phone_number TEXT;
ALTER TABLE person ADD COLUMN salary FLOAT;
ALTER TABLE person ADD COLUMN dob DATETIME;
ALTER TABLE pet ADD COLUMN dob DATETIME;
ALTER TABLE person_pet ADD COLUMN purchased_on DATETIME;
ALTER TABLE pet ADD COLUMN parent INTEGER;

UPDATE person_pet SET purchased_on = 2003 WHERE pet_id IN (
	SELECT pet.id
    FROM pet, person_pet, person
    WHERE
    person.id = person_pet.person_id AND
    pet.id = person_pet.pet_id
    );

SELECT * FROM person_pet;

INSERT INTO person(id, first_name, last_name, age, dead, phone_number, salary, dob)
	VALUES (1, "Alice", "Wang", 32, 0, 0, 0, 2012);
INSERT INTO person(id, first_name, last_name, age, dead, phone_number, salary, dob)
	VALUES (2, "Linux", "Li", 80, 0, 0, 0, 2012);
INSERT INTO person(id, first_name, last_name, age, dead, phone_number, salary, dob)
	VALUES (3, "Elex", "Green", 25, 0, 0, 0, 2012);
INSERT INTO person(id, first_name, last_name, age, dead, phone_number, salary, dob)
	VALUES (4, "Bob", "Red", 2, 0, 0, 0, 2012);

INSERT INTO pet(id, name, breed, age, dead, dob, parent)
	VALUES (2, "Juju", "Rabit", 1, 0, 2012, 0);	
INSERT INTO pet(id, name, breed, age, dead, dob, parent)
	VALUES (3, "Mimi", "Cat", 1, 0, 2012, 0);	
INSERT INTO pet(id, name, breed, age, dead, dob, parent)
	VALUES (4, "Gary", "Sheep", 1, 0, 2012, 0);	
INSERT INTO pet(id, name, breed, age, dead, dob, parent)
	VALUES (5, "Jess", "Fish", 1, 0, 2012, 0);	
INSERT INTO pet(id, name, breed, age, dead, dob, parent)
	VALUES (6, "Ari", "Rabit", 1, 0, 2012, 2);

INSERT INTO person_pet(person_id, pet_id, purchased_on)
	VALUES (1, 4,  2012);
INSERT INTO person_pet(person_id, pet_id, purchased_on)
	VALUES (2, 5,  2012);
INSERT INTO person_pet(person_id, pet_id, purchased_on)
	VALUES (3, 6,  2012);
INSERT INTO person_pet(person_id, pet_id, purchased_on)
	VALUES (4, 3,  2012);
INSERT INTO person_pet(person_id, pet_id, purchased_on)
	VALUES (1, 2,  2012);

SELECT * FROM pet;
SELECT * FROM person;
SELECT * FROM person_pet;

SELECT pet.name, person.first_name, person.last_name
	FROM pet, person, person_pet
	WHERE
	person.id = person_pet.person_id AND
	pet.id = person_pet.pet_id AND
    person_pet.purchased_on > 2004;

SELECT * FROM pet
	WHERE parent = 0;
