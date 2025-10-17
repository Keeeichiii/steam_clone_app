CREATE TABLE IF NOT EXISTS countries (
  id                  SERIAL          NOT NULL,
  name                VARCHAR(45)     NOT NULL,
  code                VARCHAR(2)      NOT NULL,
  currency_code       VARCHAR(3)      NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (name),
  UNIQUE (code),
  UNIQUE (currency_code)
);