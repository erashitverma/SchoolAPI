CREATE TABLE student (
    StudentId int NOT NULL,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT null,
    PRIMARY KEY (StudentId)
);

CREATE SEQUENCE student_sequence start 999 increment 1;

CREATE TABLE courses (
    CourseId int NOT NULL,
    CourseName varchar(255) NOT NULL,
    MinProfessor int NOT null,
    MaxProfessor int NOT null,
    MaxStudents int NOT null,
    PRIMARY KEY (CourseId)
);

CREATE SEQUENCE course_sequence start 999 increment 1;

CREATE TABLE professors (
    ProfessorId int NOT NULL,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT null,
    PRIMARY KEY (ProfessorId)
);

CREATE SEQUENCE professor_sequence start 999 increment 1;

CREATE TABLE courses_student (
    CourseId int NOT NULL,
    StudentId int NOT NULL,
    CONSTRAINT fk_course
      FOREIGN KEY(CourseId)
      REFERENCES courses(CourseId),
    CONSTRAINT fk_student
      FOREIGN KEY(StudentId)
      REFERENCES student(StudentId)
);


CREATE TABLE courses_professors (
    CourseId int NOT NULL,
    ProfessorId int NOT NULL,
    CONSTRAINT fk_course
      FOREIGN KEY(CourseId)
      REFERENCES courses(CourseId),
    CONSTRAINT fk_professor
      FOREIGN KEY(ProfessorId)
      REFERENCES professors(ProfessorId),
    PRIMARY KEY(CourseId, ProfessorId)
);
