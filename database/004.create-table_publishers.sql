CREATE TABLE IF NOT EXISTS Steam_db.publishers (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX unique_publisher_name (name)
);