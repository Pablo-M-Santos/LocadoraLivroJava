CREATE TABLE tb_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    role SMALLINT NOT NULL
);


-- Insert an admin user
INSERT INTO (name, password) VALUES ('admin', 'admin123');
