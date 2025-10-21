CREATE TABLE IF NOT EXISTS users_roles (
  user_id             BIGINT          NOT NULL,
  role_id             BIGINT          NOT NULL,
  assigned_at         TIMESTAMP       NOT NULL,

  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES roles(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);