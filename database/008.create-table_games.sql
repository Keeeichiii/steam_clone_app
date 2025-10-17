CREATE TABLE IF NOT EXISTS games (
  id                  SERIAL          NOT NULL,
  developer_id        INT             NOT NULL,
  publisher_id        INT             NOT NULL,
  title               VARCHAR(45)     NOT NULL,
  release_date        DATE,
  base_price          DECIMAL(10,2)   NOT NULL,
  description         VARCHAR(300),
  average_rating      DECIMAL(3,2),
  review_count        INT             DEFAULT 0,

  PRIMARY KEY (id),
  FOREIGN KEY (developer_id) REFERENCES developers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);