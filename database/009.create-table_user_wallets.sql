CREATE TABLE IF NOT EXISTS Steam_db.user_wallets (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  balance DECIMAL(10,2) DEFAULT 0.00,
  currency_code VARCHAR(3) NOT NULL,
  last_updated_at DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX unique_user_wallet (user_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);