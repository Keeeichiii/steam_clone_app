CREATE TABLE IF NOT EXISTS publishers (
  id                  BIGSERIAL       NOT NULL,
  name                VARCHAR(45)     NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (name)
);