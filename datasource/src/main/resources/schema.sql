CREATE TABLE IF NOT EXISTS projects (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    type TEXT,
    description TEXT,
    images_urls TEXT,
    PRIMARY KEY (id)
);