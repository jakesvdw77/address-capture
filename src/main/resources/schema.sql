DROP TABLE IF EXISTS country;

CREATE TABLE country (

    country_code INT NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);


DROP TABLE IF EXISTS province;


CREATE TABLE province (
            province_code INT NOT NULL,
            country_code INT NOT NULL,
            name VARCHAR(100) NOT NULL,
            PRIMARY KEY(province_code,country_code)
);


DROP TABLE IF EXISTS address;

CREATE TABLE address (
                         address_id INT AUTO_INCREMENT  PRIMARY KEY,
                         line1 VARCHAR(250) NULL,
                         line2 VARCHAR(250)  NULL,
                         city VARCHAR(250)  NULL,
                         province INT NOT NULL ,
                         country INT  NOT NULL,
                         FOREIGN KEY(province,country) REFERENCES province(province_code,country_code),
                         FOREIGN KEY(country) REFERENCES country(country_code)
);


