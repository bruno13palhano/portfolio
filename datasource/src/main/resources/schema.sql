CREATE TABLE IF NOT EXISTS projects (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    type TEXT,
    description TEXT,
    images_urls TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS profile (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    email VARCHAR(255),
    cellphone_number VARCHAR(55),
    social_media TEXT,
    PRIMARY KEY (id)
)