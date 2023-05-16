CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    size VARCHAR(255),
    color VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT,
    countryofproduction VARCHAR(255),
    description TEXT,
    manufacturerid BIGINT,
    reservationId BIGINT,
    FOREIGN KEY (manufacturerid) REFERENCES manufacturer (manufacturerid),
    FOREIGN KEY (reservationId) REFERENCES reservation (reservationId)
);



CREATE TABLE manufacturer (
    manufacturerid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);




CREATE TABLE reservation (
    reservationId INT AUTO_INCREMENT PRIMARY KEY,
    custName VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    name VARCHAR(255),
    type VARCHAR(255),
    size VARCHAR(255),
    color VARCHAR(255),
    price DECIMAL(10, 2),
    status VARCHAR(255)
);