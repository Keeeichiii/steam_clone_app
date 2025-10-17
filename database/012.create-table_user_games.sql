CREATE TABLE IF NOT EXISTS user_games (
  id                  SERIAL          NOT NULL,
  user_id             INT             NOT NULL,
  game_id             INT             NOT NULL,
  purchase_date       TIMESTAMP,
  total_playtime      INT             DEFAULT 0,

  PRIMARY KEY (id),
  UNIQUE (user_id, game_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);