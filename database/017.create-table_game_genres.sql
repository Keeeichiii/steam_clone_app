CREATE TABLE IF NOT EXISTS game_genres (
  game_id             BIGINT          NOT NULL,
  genre_id            BIGINT          NOT NULL,

  PRIMARY KEY (game_id, genre_id),
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);