CREATE TABLE IF NOT EXISTS Steam_db.developers (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX unique_developer_name (name)
);