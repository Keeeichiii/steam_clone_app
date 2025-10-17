CREATE TABLE IF NOT EXISTS users (
  id                  SERIAL          NOT NULL,
  credential_id       INT             NOT NULL, 
  country_id          INT             NOT NULL,
  username            VARCHAR(45)     NOT NULL,
  registration_date   DATE            NOT NULL DEFAULT NOW(),
  first_name          VARCHAR(45),
  last_name           VARCHAR(45),
  profile_name        VARCHAR(45),
  avatar_url          VARCHAR(255),
  bio                 VARCHAR(100),
  last_activity       TIMESTAMP,
  phone               VARCHAR(30),

  PRIMARY KEY (id),
  UNIQUE (username),
  UNIQUE (credential_id),
  FOREIGN KEY (credential_id) REFERENCES credentials(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (country_id) REFERENCES countries(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);