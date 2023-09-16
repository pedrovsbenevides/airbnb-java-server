CREATE TABLE acomodacao (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    user_id SERIAL NOT NULL,
    cep VARCHAR(8) NOT NULL,
    address VARCHAR(255) NOT NULL,
    complement VARCHAR(255) NULL DEFAULT NULL,
    daily_fee FLOAT(8, 2) NOT NULL,
    description VARCHAR(255) NULL DEFAULT NULL,
    capacity VARCHAR(45) NOT NULL,
);