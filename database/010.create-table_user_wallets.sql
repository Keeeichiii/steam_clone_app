CREATE TABLE IF NOT EXISTS user_wallets (
  id                  SERIAL          NOT NULL,
  user_id             INT             NOT NULL,
  balance             DECIMAL(10,2)   DEFAULT 0.00,
  currency_code       VARCHAR(3)      NOT NULL,
  last_updated_at     TIMESTAMP       NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (user_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);