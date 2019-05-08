CREATE TABLE address (
    address_id   INTEGER        PRIMARY KEY,
    street       VARCHAR        NOT NULL,
    city         VARCHAR (25)   NOT NULL,
    state        CHAR (2),
    zipcode      NUMERIC (5, 0),-- Forces 5 & only 5 numeric char values
    country_code VARCHAR (5), -- could also be a boolean international field
    CONSTRAINT pk_address PRIMARY KEY (address_id) 
    -- Just add the above (dont forget comma after country_code) to set with SQL
);
