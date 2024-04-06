CREATE TABLE inquiry
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    contents VARCHAR(100) NOT NULL,
    created DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE survey
(
    id INT NOT NULL AUTO_INCREMENT,
    age INT NOT NULL,
    satisfaction INT NOT NULL,
    comment VARCHAR(100) NOT NULL,
    created DATETIME NOT NULL,
    PRIMARY KEY (id)
);