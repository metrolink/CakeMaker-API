DROP TABLE IF EXISTS cake;

CREATE TABLE cake(
    id  INT AUTO_INCREMENT PRIMARY KEY,
    cakeName VARCHAR(250) NOT NULL,
    ingredients VARCHAR(250) NOT NULL
);

INSERT INTO cake (id, cakeName, ingredients) VALUES (1, 'Lemoncake','baking powder');
INSERT INTO cake (id, cakeName,ingredients) VALUES (2, 'Lemoncake','flour');
INSERT INTO cake (id, cakeName,ingredients) VALUES (3, 'Lemoncake','milk');
INSERT INTO cake (id, cakeName,ingredients) VALUES (4, 'Lemoncake','sugar');
INSERT INTO cake (id, cakeName,ingredients) VALUES (5, 'Lemoncake','Lemon');