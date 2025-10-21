CREATE TABLE IF NOT EXISTS transaction_items (
  id                  BIGSERIAL       NOT NULL,
  transaction_id      BIGINT          NOT NULL,
  game_id             BIGINT          NOT NULL,
  price_paid          DECIMAL(15,5)   NOT NULL,
  quantity            INT             NOT NULL DEFAULT 1,

  PRIMARY KEY (id),
  FOREIGN KEY (transaction_id) REFERENCES transactions(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);