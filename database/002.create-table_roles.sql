CREATE TABLE IF NOT EXISTS Steam_db.roles (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45),
  PRIMARY KEY (id),
  UNIQUE INDEX unique_role_name (name)
);