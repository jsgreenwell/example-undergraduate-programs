CREATE TABLE student (
    student_id INTEGER        NOT NULL,
    major_id   INTEGER        NOT NULL,
    f_name     VARCHAR (30)   NOT NULL,
    l_name     VARCHAR (30)   NOT NULL,
    email      VARCHAR (50)   NOT NULL,
    st_address VARCHAR (70),
    city       VARCHAR (50),
    zipcode    NUMERIC (5, 0),
    gpa        NUMERIC (4, 2) DEFAULT 0.0,
    transfer   BOOLEAN        DEFAULT false,
    CONSTRAINT pk_student_id PRIMARY KEY (
        student_id
    ),
    CONSTRAINT fk_major_id FOREIGN KEY (
        major_id
    ) REFERENCES major(major_id)
);
