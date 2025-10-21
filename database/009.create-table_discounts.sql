CREATE TABLE IF NOT EXISTS discounts (
  id                    BIGSERIAL       NOT NULL,
  discount_percentage   DECIMAL(7,5)    NOT NULL CHECK (discount_percentage >= 0 AND discount_percentage <= 100),
  start_date            TIMESTAMP       NOT NULL,
  end_date              TIMESTAMP       NOT NULL,
  is_active             BOOLEAN         DEFAULT TRUE,
  type                  VARCHAR(45),
  publisher_id          BIGINT,
  developer_id          BIGINT,
  genre_id              BIGINT,
  applies_to_all        BOOLEAN         DEFAULT FALSE,

  PRIMARY KEY (id),
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);