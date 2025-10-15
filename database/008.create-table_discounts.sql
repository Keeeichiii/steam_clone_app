CREATE TABLE IF NOT EXISTS Steam_db.discounts (
  id INT NOT NULL AUTO_INCREMENT,
  discount_percentage DECIMAL(5,2) NOT NULL,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  is_active TINYINT DEFAULT 1,
  type VARCHAR(45),
  publisher_id INT,
  developer_id INT,
  genre_id INT,
  applies_to_all TINYINT DEFAULT 0,
  PRIMARY KEY (id),
  INDEX idx_publisher_id (publisher_id),
  INDEX idx_developer_id (developer_id),
  INDEX idx_genre_id (genre_id),
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);