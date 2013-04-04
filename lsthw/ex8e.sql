SELECT * FROM person;
SELECT * FROM pet;
SELECT * FROM person_pet;

DELETE FROM person_pet
    WHERE pet_id IN(
        SELECT id FROM pet WHERE dead = 0
    );
SELECT * FROM person_pet;
