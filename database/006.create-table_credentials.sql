CREATE TABLE IF NOT EXISTS credentials (
  id                  BIGSERIAL       NOT NULL,
  password_hash       VARCHAR(255)    NOT NULL,
  email               VARCHAR(100)    NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (email)
);