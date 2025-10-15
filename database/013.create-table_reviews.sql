CREATE TABLE IF NOT EXISTS Steam_db.reviews (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  game_id INT NOT NULL,
  rating TINYINT NOT NULL,
  text VARCHAR(300),
  date_posted DATETIME NOT NULL,
  PRIMARY KEY (id),
  INDEX idx_user_id (user_id),
  INDEX idx_game_id (game_id),
  UNIQUE INDEX unique_user_game_review (user_id, game_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);