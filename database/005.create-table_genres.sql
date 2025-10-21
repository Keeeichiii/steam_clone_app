CREATE TABLE IF NOT EXISTS genres (
  id                  BIGSERIAL       NOT NULL,
  name                VARCHAR(45)     NOT NULL,
  description         VARCHAR(300),

  PRIMARY KEY (id),
  UNIQUE (name)
);