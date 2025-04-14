CREATE TABLE COURSES_POSTGRES (
                                  id INTEGER NOT NULL,
                                  name VARCHAR(100) NOT NULL,
                                  category VARCHAR(20) NOT NULL,
                                  rating SMALLINT NOT NULL CHECK (rating BETWEEN 0 AND 9),
                                  description VARCHAR(1000) NOT NULL,
                                  PRIMARY KEY (id)
);
