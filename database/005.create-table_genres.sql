CREATE TABLE IF NOT EXISTS Steam_db.genres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(300),
  PRIMARY KEY (id),
  UNIQUE INDEX unique_genre_name (name)
);