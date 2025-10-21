CREATE TABLE IF NOT EXISTS reviews (
  id                  BIGSERIAL       NOT NULL,
  user_id             BIGINT          NOT NULL,
  game_id             BIGINT          NOT NULL,
  rating              SMALLINT        NOT NULL CHECK (rating >= 1 AND rating <= 5),
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