CREATE TABLE IF NOT EXISTS game_discounts (
  game_id             BIGINT          NOT NULL,
  discount_id         BIGINT          NOT NULL,

  PRIMARY KEY (game_id, discount_id),
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (discount_id) REFERENCES discounts(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);