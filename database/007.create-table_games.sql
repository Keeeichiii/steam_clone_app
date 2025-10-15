CREATE TABLE IF NOT EXISTS Steam_db.games (
  id INT NOT NULL AUTO_INCREMENT,
  developer_id INT NOT NULL,
  publisher_id INT NOT NULL,
  title VARCHAR(45) NOT NULL,
  release_date DATE,
  base_price DECIMAL(10,2) NOT NULL,
  description VARCHAR(300),
  average_rating DECIMAL(3,2),
  review_count INT DEFAULT 0,
  PRIMARY KEY (id),
  INDEX idx_developer_id (developer_id),
  INDEX idx_publisher_id (publisher_id),
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);