CREATE TABLE director (
    director_id INTEGER PRIMARY KEY,
    director_name    VARCHAR
);

CREATE TABLE actor (
    actor_id INTEGER PRIMARY KEY,
    actor_name    VARCHAR
);

CREATE TABLE actress (
    actress_id INTEGER PRIMARY KEY,
    actress_name    VARCHAR
);

CREATE TABLE subject (
    subject_name VARCHAR PRIMARY KEY
);

CREATE TABLE film (
    movie_id     INTEGER  PRIMARY KEY AUTOINCREMENT
                          UNIQUE
                          NOT NULL,
    year         INTEGER  NOT NULL,
    length       INTEGER,
    title        TEXT,
    popularity   SMALLINT DEFAULT 0,
    awards       BOOLEAN  DEFAULT false,
    subject_name VARCHAR,
    actress_id   INTEGER,
    actor_id     INTEGER,
    director_id  INTEGER,
    FOREIGN KEY (
        subject_name
    )
    REFERENCES subject (subject_name),
    FOREIGN KEY (
        director_id
    )
    REFERENCES director (director_id),
    FOREIGN KEY (
        actor_id
    )
    REFERENCES actor (actor_id),
    FOREIGN KEY (
        actress_id
    )
    REFERENCES actor (actress_id) 
);

CREATE INDEX subject_idx ON subject (
    subject_name
);

CREATE INDEX director_idx ON director (
    director_id
);

CREATE INDEX actor_idx ON actor (
    actor_id
);

CREATE INDEX actress_idx ON actress (
    actress_id
);

INSERT INTO subject VALUES ('Drama'),('Comedy'),('Horror'),
                    ('Action'),('Science Fiction'),('Short'),
                    ('Music'),('War'),('Western'),('Mystery');

