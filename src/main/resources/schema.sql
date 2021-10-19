DROP TABLE IF EXISTS country;

CREATE TABLE country (

    country_code CHAR (2)  NOT NULL PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS province;


CREATE TABLE province (
            province_code VARCHAR (3) NOT NULL,
            country_code CHAR (2) NOT NULL,
            province_name VARCHAR(20) NOT NULL,
            PRIMARY KEY(province_code,country_code)
);


DROP TABLE IF EXISTS address;

CREATE TABLE address (
                         address_id INT AUTO_INCREMENT  PRIMARY KEY,
                         line1 VARCHAR(100) NULL,
                         line2 VARCHAR(100)  NULL,
                         city VARCHAR(100)  NULL,
                         suburb VARCHAR(100)  NULL,
                         province_code VARCHAR (3)  ,
                         country_code CHAR (2) NOT NULL,
                         FOREIGN KEY(province_code,country_code) REFERENCES province(province_code,country_code),
                         FOREIGN KEY(country_code) REFERENCES country(country_code)
);


