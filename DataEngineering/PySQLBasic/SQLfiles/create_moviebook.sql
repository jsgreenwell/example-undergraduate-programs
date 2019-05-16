CREATE TABLE movies (
    isbn      INTEGER      PRIMARY KEY
                           UNIQUE
                           NOT NULL,
    title     TEXT,
    author    VARCHAR (40),
    genre     VARCHAR (40),
    tot_pages INTEGER,
    editor    VARCHAR (40) 
);

CREATE TABLE dvds (
    sku    INTEGER        PRIMARY KEY
                          UNIQUE
                          NOT NULL,
    title  TEXT,
    price  NUMERIC (8, 2),
    genre  VARCHAR (40),
    length INTEGER
);
