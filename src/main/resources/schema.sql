DROP TABLE IF EXISTS address;

CREATE TABLE address (
                         address_id INT AUTO_INCREMENT  PRIMARY KEY,
                         line1 VARCHAR(250) NULL,
                         line2 VARCHAR(250)  NULL,
                         city VARCHAR(250)  NULL,
                         province INT NOT NULL,
                         country INT  NOT NULL
);


