
--DML
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(1,  'Suresh', 'Gaya', '2016-11-16 06:55:40.11');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(2,  'James', 'Gaya','2016-11-16 06:55:40.11');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(3,  'Peter', 'Amsterdam','2016-11-16 06:55:40.11');

insert into phone(id, PERSON_ID, phone_number) values (1, 1, '888888888');
insert into phone(id, PERSON_ID, phone_number) values (2, 1, '999999999');
insert into phone(id, PERSON_ID, phone_number) values (3, 2, '777777777');

