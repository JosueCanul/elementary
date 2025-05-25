CREATE TABLE IF NOT EXISTS student_table (
    id int NOT NULL AUTO_INCREMENT,
    enrollment char(10) NOT NULL,
    student_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar (255) NOT NULL,
    grade varchar(50) NOT NULL DEFAULT 'FIRST',
    PRIMARY KEY (id),
    UNIQUE (enrollment),
    UNIQUE (email)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS subject_table (
    id int NOT NULL AUTO_INCREMENT,
    subject_name varchar(150),
    description varchar(200),
    grade varchar(50),
    PRIMARY KEY (id),
    UNIQUE (subject_name)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS score_table (
    id int NOT NULL AUTO_INCREMENT,
    id_student int,
    id_subject int,
    start_date date NOT NULL,
    end_date date NOT NULL,
    score int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_student) REFERENCES student_table(id) ON DELETE CASCADE,
    FOREIGN KEY (id_subject) REFERENCES subject_table(id) ON DELETE CASCADE,
    UNIQUE (id_student, id_subject, start_date, end_date)
)ENGINE=INNODB;