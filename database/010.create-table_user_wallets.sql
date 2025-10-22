CREATE TABLE IF NOT EXISTS user_wallets (
  id                  BIGSERIAL       NOT NULL,
  user_id             BIGINT          NOT NULL,
  balance             DECIMAL(15,5)   DEFAULT 0.00 CHECK (balance >= 0),
  currency_code       VARCHAR(3)      NOT NULL,
  last_updated_at     TIMESTAMP       NOT NULL DEFAULT NOW(),

  PRIMARY KEY (id),
  UNIQUE (user_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);