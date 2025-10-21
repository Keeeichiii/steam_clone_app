CREATE TABLE IF NOT EXISTS roles (
  id                  BIGSERIAL       NOT NULL,
  name                VARCHAR(45)     NOT NULL,
  description         VARCHAR(45),

  PRIMARY KEY (id),
  UNIQUE (name)
);