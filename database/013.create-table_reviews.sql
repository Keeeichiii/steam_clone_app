CREATE TABLE IF NOT EXISTS reviews (
  id                  SERIAL          NOT NULL,
  user_id             INT             NOT NULL,
  game_id             INT             NOT NULL,
  rating              SMALLINT        NOT NULL,
  text                VARCHAR(300),
  date_posted         TIMESTAMP       NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (user_id, game_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);