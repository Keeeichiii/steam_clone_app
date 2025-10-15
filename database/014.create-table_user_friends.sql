CREATE TABLE IF NOT EXISTS Steam_db.user_friends (
  user_added_id INT NOT NULL,
  user_sender_id INT NOT NULL,
  status ENUM('WAITING', 'ACCEPTED') NOT NULL,
  request_at DATETIME NOT NULL,
  accept_at DATETIME,
  PRIMARY KEY (user_added_id, user_sender_id),
  INDEX idx_user_sender_id (user_sender_id),
  INDEX idx_user_added_id (user_added_id),
  FOREIGN KEY (user_sender_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (user_added_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);