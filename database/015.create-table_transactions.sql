CREATE TABLE IF NOT EXISTS transactions (
  id                  BIGSERIAL             NOT NULL,
  user_id             BIGINT                NOT NULL,
  transaction_date    TIMESTAMP             NOT NULL DEFAULT NOW(),
  total_amount        DECIMAL(20,5)         NOT NULL,
  status              VARCHAR(20)           NOT NULL,
  transaction_type    transaction_type_enum NOT NULL,
  description         VARCHAR(45),

  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);