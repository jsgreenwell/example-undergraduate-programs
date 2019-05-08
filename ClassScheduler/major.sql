CREATE TABLE major (
    major_id    INTEGER,
    major_name  VARCHAR (70) NOT NULL,
    certificate BOOLEAN      DEFAULT false,
    degree_lvl  VARCHAR      CHECK ( degree_lvl IN ('associate',  
                                    'bachelors',  
                                    'masters', 
                                    'doctorate', 
                                    'none')),
    CONSTRAINT pk_major_id PRIMARY KEY (
        major_id
    )
);
