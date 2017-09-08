CREATE TABLE locker(id INT(11) NOT NULL AUTO_INCREMENT, public_id VARCHAR(100), rider_id INT, created_at DATETIME, update_at DATETIME,
PRIMARY KEY (id),
FOREIGN KEY (rider_id) REFERENCES rider (id));

CREATE TABLE locker_position (id INT(11) NOT NULL AUTO_INCREMENT, locker_id INT(11), latitude FLOAT, longitude FLOAT,
PRIMARY KEY (id),
FOREIGN KEY (locker_id) REFERENCES locker (id));

