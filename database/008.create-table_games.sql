CREATE TABLE IF NOT EXISTS games (
  id                  BIGSERIAL       NOT NULL,
  developer_id        BIGINT          NOT NULL,
  publisher_id        BIGINT          NOT NULL,
  title               VARCHAR(45)     NOT NULL,
  release_date        DATE,
  base_price          DECIMAL(15,5)   NOT NULL CHECK (base_price >= 0),
  description         VARCHAR(300),
  average_rating      DECIMAL(3,2),
  review_count        INT             DEFAULT 0 CHECK (review_count >= 0),

  PRIMARY KEY (id),
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);