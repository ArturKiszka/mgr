INSERT INTO classes(
            idclasses, lecturer_idlecturer, classesterm, begininghour, lecturehall, 
            documentnamemask)
    VALUES (1, 1, 'poniedzialek', '8:00', '123 D10', 
            '.zip');
			
INSERT INTO faculty(
            idfaculty, facultyname, facultyadress, facultyphonenumer)
    VALUES (1, 'FiIS', 'Reymonta 34, 30-36 Kraków', '607676453');
	
INSERT INTO fieldofstudy(
            idfieldofstudy, student_studentcardnumber, faculty_idfaculty, 
            name)
    VALUES (1, 238894, 1, 
            'IS');

INSERT INTO labgroup(
            idlabgroup, student_studentcardnumber, name)
    VALUES (1, 238894, 'Programowanie I 8:00');

INSERT INTO lecturer(
            idlecturer, firstname, lastname, academictitle, email, phonenumber, 
            office)
    VALUES (1, 'Maciej', 'Woloszyn', 'dr', 'woloszyn@agh.edu.pl', '444543231', 
            '18 D10');
INSERT INTO storehouseofdocuments(
            idstorehouseofdocuments, classes_idclasses, student_studentcardnumber, 
            document, grade, comments)
    VALUES (1, 1, 238894, 
            '123', 4.5, 'wszystko ok');
INSERT INTO student(
            studentcardnumber, firstname, lastname, email, studyyear, phonenumber)
    VALUES (238894, 'Artur', 'Kiszka', 'artur_kiszka@wp.pl', 5, '607564321');
