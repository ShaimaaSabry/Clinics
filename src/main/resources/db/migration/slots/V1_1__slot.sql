CREATE TABLE slot (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    doctor_id UUID NOT NULL,
    starts_at TIMESTAMP NOT NULL,
    is_reserved BOOLEAN NOT NULL DEFAULT FALSE,
    cost NUMERIC(6,2) NOT NULL
);