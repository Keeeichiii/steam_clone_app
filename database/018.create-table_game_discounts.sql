CREATE TABLE IF NOT EXISTS game_discounts (
  game_id             INT             NOT NULL,
  discount_id         INT             NOT NULL,

  PRIMARY KEY (game_id, discount_id),
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (discount_id) REFERENCES discounts(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);