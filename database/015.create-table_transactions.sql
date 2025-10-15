CREATE TABLE IF NOT EXISTS Steam_db.transactions (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  transaction_date DATETIME NOT NULL,
  total_amount DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  transaction_type ENUM('PURCHASE', 'DEPOSIT', 'REFUND') NOT NULL,
  description VARCHAR(45),
  PRIMARY KEY (id),
  INDEX idx_user_id (user_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);