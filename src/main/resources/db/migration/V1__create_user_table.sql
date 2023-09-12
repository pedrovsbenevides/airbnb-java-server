CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL, 
    email VARCHAR(255) NOT NULL, 
    password VARCHAR(45) NOT NULL,
    phone VARCHAR(15) NULL
);
