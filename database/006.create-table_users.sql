CREATE TABLE IF NOT EXISTS Steam_db.users (
  id INT NOT NULL AUTO_INCREMENT,
  country_id INT NOT NULL,
  username VARCHAR(45) NOT NULL,
  registration_date DATE NOT NULL,
  first_name VARCHAR(45),
  last_name VARCHAR(45),
  profile_name VARCHAR(45),
  avatar_url VARCHAR(255),
  bio VARCHAR(100),
  last_activity DATETIME,
  phone VARCHAR(30),
  PRIMARY KEY (id),
  UNIQUE INDEX unique_username (username),
  INDEX idx_country_id (country_id),
  FOREIGN KEY (country_id) REFERENCES countries(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);