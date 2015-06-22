CREATE TABLE Faculty (
  idFaculty SERIAL NOT NULL  ,
  facultyName VARCHAR(20) NULL,
  facultyAdress VARCHAR(255) NULL,
  facultyPhoneNumer INTEGER  NULL,
  PRIMARY KEY(idFaculty)
);

CREATE TABLE LabGroup (
  idLabGroup SERIAL NOT NULL  ,
  name VARCHAR(45) NULL,
  PRIMARY KEY(idLabGroup)
);

CREATE TABLE Lecturer (
  idLecturer SERIAL NOT NULL  ,
  firstName VARCHAR(20) NULL,
  lastName VARCHAR(45) NULL,
  academicTitle VARCHAR(20) NULL,
  email VARCHAR(45) NULL,
  phoneNumber VARCHAR(9) NULL,
  office VARCHAR(45) NULL,
  PRIMARY KEY(idLecturer)
);

CREATE TABLE Classes (
  idClasses SERIAL NOT NULL  ,
  Lecturer_idLecturer SERIAL NOT NULL,
  classesTerm VARCHAR(45) NULL,
  beginingHour TIME NULL,
  lectureHall VARCHAR(20) NULL,
  documentNameMask VARCHAR(45) NULL,
  idlecturer integer REFERENCES lecturer (idlecturer),
  PRIMARY KEY(idClasses)
);

CREATE TABLE FieldOfStudy (
  idFieldOfStudy SERIAL NOT NULL  ,
  Faculty_idFaculty SERIAL NOT NULL,
  name VARCHAR(20) NULL,
  idFaculty integer REFERENCES Faculty (idFaculty),
  PRIMARY KEY(idFieldOfStudy)
  
);


CREATE TABLE Student (
  studentCardNumber VARCHAR(6) NOT NULL  ,
  FieldOfStudy_idFieldOfStudy SERIAL NOT NULL,
  LabGroup_idLabGroup SERIAL NOT NULL,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  email VARCHAR(20) NULL,
  studyYear integer NULL,
  phoneNumber VARCHAR(9) NULL,
  idFieldOfStudy integer REFERENCES FieldOfStudy(idFieldOfStudy),
idLabGroup integer REFERENCES LabGroup(idLabGroup),
  PRIMARY KEY(studentCardNumber)
);

CREATE TABLE StorehouseOfDocuments (
  idStorehouseOfDocuments SERIAL NOT NULL  ,
  Classes_idClasses SERIAL NOT NULL,
  Student_studentCardNumber VARCHAR(6) NOT NULL,
  document bytea NULL,
  grade DECIMAL NULL,
  comments TEXT NULL,
  idClasses integer  REFERENCES Classes(idClasses),
  studentCardNumber VARCHAR(6) REFERENCES Student(studentCardNumber),
  PRIMARY KEY(idStorehouseOfDocuments)

);