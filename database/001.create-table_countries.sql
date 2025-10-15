CREATE TABLE IF NOT EXISTS Steam_db.countries (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  code VARCHAR(2) NOT NULL,
  currency_code VARCHAR(3) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX unique_country_name (name),
  UNIQUE INDEX unique_country_code (code),
  UNIQUE INDEX unique_country_currency_code (currency_code)

);