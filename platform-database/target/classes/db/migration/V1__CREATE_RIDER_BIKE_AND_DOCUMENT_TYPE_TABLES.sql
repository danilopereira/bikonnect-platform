CREATE TABLE document_type (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(20), PRIMARY KEY (id));
INSERT INTO document_type (name) VALUES ('cpf');
INSERT INTO document_type (name) VALUES ('rg');
INSERT INTO document_type (name) VALUES ('passport');


CREATE TABLE rider(id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(100) NOT NULL , public_name VARCHAR(50), document_type_id INTEGER,
  document_number VARCHAR(30), is_active TINYINT(1), created_at DATETIME, updated_at DATETIME,
  PRIMARY KEY (id),
  FOREIGN KEY (document_type_id) REFERENCES document_type (id));

CREATE TABLE bike(id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(100) NOT NULL, PRIMARY KEY (id));