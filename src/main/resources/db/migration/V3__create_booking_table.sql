CREATE TABLE booking (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    guest_id SERIAL NOT NULL,
    accommodation_id SERIAL NOT NULL,
    total_value DECIMAL(8, 2) NOT NULL,
    assessment_value DECIMAL(8, 2) DEFAULT 0,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    checkin BOOLEAN DEFAULT FALSE,
    cancellation BOOLEAN DEFAULT FALSE
);