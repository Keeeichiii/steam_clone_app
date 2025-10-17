CREATE TABLE IF NOT EXISTS discounts (
  id                    SERIAL          NOT NULL,
  discount_percentage   DECIMAL(5,2)    NOT NULL,
  start_date            TIMESTAMP       NOT NULL,
  end_date              TIMESTAMP       NOT NULL,
  is_active             BOOLEAN         DEFAULT TRUE,
  type                  VARCHAR(45),
  publisher_id          INT,
  developer_id          INT,
  genre_id              INT,
  applies_to_all        BOOLEAN         DEFAULT FALSE,

  PRIMARY KEY (id),
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);