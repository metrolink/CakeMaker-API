DROP TABLE IF EXISTS cake;

CREATE TABLE cake(
    id  INT AUTO_INCREMENT PRIMARY KEY,
    ingredients VARCHAR(250) NOT NULL
);

INSERT INTO cake (id, ingredients) VALUES (1, 'baking powder');
INSERT INTO cake (id, ingredients) VALUES (2, 'flour');
INSERT INTO cake (id, ingredients) VALUES (3, 'milk');
INSERT INTO cake (id, ingredients) VALUES (4, 'sugar');
INSERT INTO cake (id, ingredients) VALUES (5, 'USA');