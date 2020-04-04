
--DML
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(1,  'Suresh', 'Gaya', '2016-11-16 06:55:40.11');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(2,  'James', 'Gaya','2016-11-16 06:55:40.11');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )  VALUES(3,  'Peter', 'Amsterdam','2016-11-16 06:55:40.11');

insert into phone(id, PERSON_ID, phone_number) values (1, 1, '888888888');
insert into phone(id, PERSON_ID, phone_number) values (2, 1, '999999999');
insert into phone(id, PERSON_ID, phone_number) values (3, 2, '777777777');

insert into course(id, name, created_date, last_updated_date,is_deleted)
values(1,'JPA in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted)
values(2,'Spring in 50 Steps', sysdate(), sysdate(),false);
insert into course(id, name, created_date, last_updated_date,is_deleted)
values(3,'Spring Boot in 100 Steps', sysdate(), sysdate(),false);


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',1);
insert into review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',1);
insert into review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',3);

insert into student_course(student_id,course_id)
values(20001,1);
insert into student_course(student_id,course_id)
values(20002,1);
insert into student_course(student_id,course_id)
values(20003,1);
insert into student_course(student_id,course_id)
values(20001,3);

