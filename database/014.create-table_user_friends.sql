CREATE TABLE IF NOT EXISTS user_friends (
  user_added_id       BIGINT                NOT NULL,
  user_sender_id      BIGINT                NOT NULL,
  status              user_friend_status    NOT NULL,
  request_at          TIMESTAMP             NOT NULL,
  accept_at           TIMESTAMP,

  PRIMARY KEY (user_added_id, user_sender_id),
  FOREIGN KEY (user_sender_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (user_added_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);