CREATE TABLE IF NOT EXISTS publishers (
  id                  SERIAL          NOT NULL,
  name                VARCHAR(45)     NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (name)
);