CREATE TABLE IF NOT EXISTS developers (
  id                  SERIAL          NOT NULL,
  name                VARCHAR(45)     NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (name)
);