DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS receipts;
DROP TABLE IF EXISTS items;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  pass_word VARCHAR(250) DEFAULT NULL
);
CREATE TABLE receipts (
  receipt_id INT AUTO_INCREMENT  PRIMARY KEY,
  total INT NOT NULL
);
CREATE TABLE items (
  item_id INT AUTO_INCREMENT  PRIMARY KEY,
  price INT NOT NULL,
  istaxable BOOLEAN NOT NULL
);

INSERT INTO users (username, email, pass_word) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');