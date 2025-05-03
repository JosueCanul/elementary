CREATE TABLE IF NOT EXISTS student_table (
    enrollment char(10) NOT NULL,
    student_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar (255) NOT NULL,
    grade varchar(50) NOT NULL DEFAULT 'FIRST',
    PRIMARY KEY (enrollment)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS subject_table (
    subject_name varchar(150),
    description varchar(200),
    grade varchar(50),
    PRIMARY KEY (subject_name)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS score_table (
    score_id int NOT NULL AUTO_INCREMENT,
    enrollment char(10) NOT NULL,
    subject_name varchar(150),
    start_date date NOT NULL,
    final_date date NOT NULL,
    score int NOT NULL,
    PRIMARY KEY (score_id),
    FOREIGN KEY (enrollment) REFERENCES student_table(enrollment) ON DELETE CASCADE,
    FOREIGN KEY (subject_name) REFERENCES subject_table(subject_name) ON DELETE CASCADE
)ENGINE=INNODB;