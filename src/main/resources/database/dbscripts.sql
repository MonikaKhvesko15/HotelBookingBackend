DROP DATABASE hotel;
CREATE DATABASE hotel CHARACTER SET UTF8 COLLATE utf8_bin;
USE hotel;

CREATE TABLE IF NOT EXISTS roles
(
    id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role ENUM ('ADMIN','USER')
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(20) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    surname   VARCHAR(20) NOT NULL,
    role_id     BIGINT NOT NULL,
    is_blocked BIT DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT united_name_surname UNIQUE (firstname, surname)
);

CREATE TABLE IF NOT EXISTS rooms
(
    id        INT AUTO_INCREMENT,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    room_type   ENUM ('STANDARD', 'BUSINESS','LUX'),
    capacity INT,
    price DECIMAL NOT NULL,
    is_available BIT DEFAULT 0,
    description VARCHAR(100),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS reservations
(
    id   INT AUTO_INCREMENT,
    start_date  DATE NOT NULL,
    end_date    DATE NOT NULL,
    total_price DECIMAL NOT NULL,
    status      ENUM ('ACCEPTED','UNDER_CONSIDERATION','COMPLETED','REJECTED') DEFAULT 'UNDER_CONSIDERATION',
    user_id     INT  NOT NULL,
    room_id     INT  NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id)
);

CREATE TABLE IF NOT EXISTS rooms_reservations
(
    room_id INT NOT NULL REFERENCES rooms (id),
    reservation_id INT NOT NULL REFERENCES reservations (id)
)

CREATE TABLE IF NOT EXISTS comments
(
    id   INT AUTO_INCREMENT,
    create_date    DATE NOT NULL,
    text_comment VARCHAR(300) NOT NULL,
    user_id     INT  NOT NULL,
    room_id     INT  NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (room_id) REFERENCES rooms (id)
);



