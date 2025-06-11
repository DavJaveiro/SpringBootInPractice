INSERT INTO courses (name, category, rating, description)
VALUES ('Rapid Spring Boot Application Development', 'Spring', 4, 'Spring Boot gives all the power of the Spring Framework without all of the complexity');

INSERT INTO courses (name, category, rating, description)
VALUES ('Getting Started with Spring Security DSL', 'Spring', 5, 'Learn Spring Security DSL in easy steps');

INSERT INTO courses (name, category, rating, description)
VALUES ('Getting Started with Spring Cloud Kubernetes', 'Python', 3, 'Master Spring Boot application deployment with Kubernetes');

INSERT INTO ct_users (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, EMAIL, VERIFIED, LOCKED, ACC_CRED_EXPIRED)
VALUES ('John', 'Socket', 'jsocket', 'password', 'jsocket@example.com', TRUE, FALSE, FALSE);

INSERT INTO ct_users (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, EMAIL, VERIFIED, LOCKED, ACC_CRED_EXPIRED)
VALUES ('Steve', 'Smith', 'smith', 'password', 'smith@example.com', FALSE, FALSE, FALSE);
