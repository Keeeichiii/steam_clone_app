CREATE TABLE IF NOT EXISTS Steam_db.credentials (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX unique_email (email),
  UNIQUE INDEX unique_user_credential (user_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);