DROP DATABASE hotel;
CREATE DATABASE hotel CHARACTER SET UTF8 COLLATE utf8_bin;
USE hotel;

CREATE TABLE IF NOT EXISTS roles
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_value	 VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(20) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    surname   VARCHAR(20) NOT NULL,
    role_id     INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT united_name_surname UNIQUE (firstname, surname)
);

CREATE TABLE IF NOT EXISTS rooms
(
    id        INT AUTO_INCREMENT,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    room_type   VARCHAR(20) NOT NULL,
    capacity INT,
    price DECIMAL NOT NULL,
    is_available BIT DEFAULT 0,
    description VARCHAR(100),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS room_status
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status_value	 VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations
(
    id   INT AUTO_INCREMENT,
    start_date  DATE,
    end_date    DATE,
    total_price DECIMAL NOT NULL,
    status_id   INT  NOT NULL,
    user_id     INT  NOT NULL,
    room_id     INT  NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (status_id) REFERENCES room_status (id)
);



