CREATE TABLE IF NOT EXISTS Steam_db.game_genres (
  game_id INT NOT NULL,
  genre_id INT NOT NULL,
  PRIMARY KEY (game_id, genre_id),
  INDEX idx_genre_id (genre_id),
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);