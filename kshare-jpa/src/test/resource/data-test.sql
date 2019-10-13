

create table person
(
  id integer not null AUTO_INCREMENT,
  birth_date timestamp,
  location varchar(255),
  name varchar(255),
  primary key (id)
);



INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(  'Suresh', 'Gaya',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(  'Pieter', 'Amsterdam',sysdate());


    create table course (
       id bigint not null,
        created_date timestamp,
        is_deleted boolean not null,
        last_updated_date timestamp,
        name varchar(255) not null,
        primary key (id)
    );
    create table full_time_employee (
       id bigint not null,
        name varchar(255) not null,
        salary decimal(19,2),
        primary key (id)
    );
    create table part_time_employee (
       id bigint not null,
        name varchar(255) not null,
        hourly_wage decimal(19,2),
        primary key (id)
    );
    create table passport (
       id bigint not null,
        number varchar(255) not null,
        primary key (id)
    );
    create table review (
       id bigint not null,
        description varchar(255),
        rating varchar(255),
        course_id bigint,
        primary key (id)
    );
    create table student (
       id bigint not null,
        city varchar(255),
        line1 varchar(255),
        line2 varchar(255),
        name varchar(255) not null,
        passport_id bigint,
        primary key (id)
    );
    create table student_course (
       student_id bigint not null,
        course_id bigint not null
    );
    
    alter table review 
       add constraint FKprox8elgnr8u5wrq1983degk 
       foreign key (course_id) 
       references course;
       
    alter table student 
       add constraint FK6i2dofwfuu97njtfprqv68pib 
       foreign key (passport_id) 
       references passport;
    alter table student_course 
       add constraint FKejrkh4gv8iqgmspsanaji90ws 
       foreign key (course_id) 
       references course;
    alter table student_course 
       add constraint FKq7yw2wg9wlt2cnj480hcdn6dq 
       foreign key (student_id) 
       references student;


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