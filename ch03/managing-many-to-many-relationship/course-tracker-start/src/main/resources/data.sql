INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION)  VALUES(1, 'Rapid Spring Boot Application Development', 'Spring', 4, 'Spring Boot gives all the power of the Spring Framework without all of the complexity');
INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION)  VALUES(2, 'Getting Started with Spring Security DSL', 'Spring', 5, 'Learn Spring Security DSL in easy steps');
INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION)  VALUES(3, 'Getting Started with Spring Cloud Kubernetes', 'Python', 3, 'Master Spring Boot application deployment with Kubernetes');

INSERT INTO AUTHORS(ID, NAME, BIO)  VALUES(1, 'John Doe', 'Author of several Spring Boot courses');
INSERT INTO AUTHORS(ID, NAME, BIO)  VALUES(2, 'Steve Muller', 'Author of several popular Spring and Python courses');

INSERT INTO AUTHORS_COURSES(AUTHOR_ID, COURSE_ID) VALUES(1, 1);
INSERT INTO AUTHORS_COURSES(AUTHOR_ID, COURSE_ID) VALUES(1, 2);
INSERT INTO AUTHORS_COURSES(AUTHOR_ID, COURSE_ID) VALUES(2, 1);
INSERT INTO AUTHORS_COURSES(AUTHOR_ID, COURSE_ID) VALUES(2, 2);
INSERT INTO AUTHORS_COURSES(AUTHOR_ID, COURSE_ID) VALUES(2, 3);
