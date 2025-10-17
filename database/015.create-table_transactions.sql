CREATE TABLE IF NOT EXISTS transactions (
  id                  SERIAL          NOT NULL,
  user_id             INT             NOT NULL,
  transaction_date    TIMESTAMP       NOT NULL,
  total_amount        DECIMAL(14,6)   NOT NULL,
  status              VARCHAR(20)     NOT NULL,
  transaction_type    transaction_type_enum NOT NULL,
  description         VARCHAR(45),

  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);