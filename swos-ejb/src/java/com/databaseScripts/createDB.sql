CREATE TABLE Classes (
  idClasses INTEGER   NOT NULL  ,
  Lecturer_idLecturer INTEGER   NOT NULL,
  classesTerm VARCHAR(45) NULL,
  beginingHour TIME NULL,
  lectureHall VARCHAR(20) NULL,
  documentNameMask VARCHAR(45) NULL,
  PRIMARY KEY(idClasses)
);

CREATE TABLE Faculty (
  idFaculty INTEGER   NOT NULL  ,
  facultyName VARCHAR(20) NULL,
  facultyAdress VARCHAR(255) NULL,
  facultyPhoneNumer INTEGER   NULL,
  PRIMARY KEY(idFaculty)
);

CREATE TABLE FieldOfStudy (
  idFieldOfStudy INTEGER   NOT NULL  ,
  Student_studentCardNumber VARCHAR(6) NOT NULL,
  Faculty_idFaculty INTEGER   NOT NULL,
  name VARCHAR(20) NULL,
  PRIMARY KEY(idFieldOfStudy)
);

CREATE TABLE LabGroup (
  idLabGroup INTEGER   NOT NULL  ,
  Student_studentCardNumber VARCHAR(6) NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY(idLabGroup)
);

CREATE TABLE Lecturer (
  idLecturer INTEGER   NOT NULL  ,
  firstName VARCHAR(20) NULL,
  lastName VARCHAR(45) NULL,
  academicTitle VARCHAR(20) NULL,
  email VARCHAR(45) NULL,
  phoneNumber VARCHAR(9) NULL,
  office VARCHAR(45) NULL,
  PRIMARY KEY(idLecturer)
);

CREATE TABLE StorehouseOfDocuments (
  idStorehouseOfDocuments INTEGER   NOT NULL  ,
  Classes_idClasses INTEGER   NOT NULL,
  Student_studentCardNumber VARCHAR(6) NOT NULL,
  document bytea NULL,
  grade DECIMAL NULL,
  comments TEXT NULL,
  PRIMARY KEY(idStorehouseOfDocuments)
);

CREATE TABLE Student (
  studentCardNumber VARCHAR(6) NOT NULL  ,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  email VARCHAR(20) NULL,
  studyYear INTEGER   NULL,
  phoneNumber VARCHAR(9) NULL,
  PRIMARY KEY(studentCardNumber)
);


