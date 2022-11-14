CREATE TABLE IF NOT EXISTS machine_resources(
    id INT AUTO_INCREMENT PRIMARY KEY,
    ip_address VARCHAR(255),
    ram FLOAT,
    storage FLOAT,
    cpu FLOAT
);

ALTER TABLE IF EXISTS machine_resources ADD COLUMN time_s TIMESTAMP NULL;
