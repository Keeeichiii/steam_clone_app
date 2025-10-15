CREATE TABLE IF NOT EXISTS Steam_db.transaction_items (
  id INT NOT NULL AUTO_INCREMENT,
  transaction_id INT NOT NULL,
  game_id INT NOT NULL,
  price_paid DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  INDEX idx_transaction_id (transaction_id),
  INDEX idx_game_id (game_id),
  FOREIGN KEY (transaction_id) REFERENCES transactions(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (game_id) REFERENCES games(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);