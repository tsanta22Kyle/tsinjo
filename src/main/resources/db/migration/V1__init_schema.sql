CREATE TABLE donor
(
    id        UUID PRIMARY KEY,
    full_name TEXT NOT NULL,
    email     TEXT NOT NULL UNIQUE
);

CREATE TABLE beneficiary
(
    id        UUID PRIMARY KEY,
    full_name TEXT NOT NULL,
    email     TEXT NOT NULL UNIQUE
);

CREATE TABLE payment
(
    id                            UUID PRIMARY KEY,
    method                        TEXT             NOT NULL,
    psp_payment_id                TEXT             NOT NULL,
    amount                        DOUBLE PRECISION NOT NULL,
    creation_instant              TIMESTAMP        NOT NULL,
    last_psp_verification_instant TIMESTAMP,
    verification_attempt_nb       INT DEFAULT 0,
    verification_status           TEXT             NOT NULL
);

CREATE TABLE donation
(
    id            UUID PRIMARY KEY,
    donor_id      UUID      NOT NULL REFERENCES donor (id),
    payment_id    UUID      NOT NULL REFERENCES payment (id),
    creation_date TIMESTAMP NOT NULL
);

CREATE TABLE help
(
    id             UUID PRIMARY KEY,
    beneficiary_id UUID      NOT NULL REFERENCES beneficiary (id),
    payment_id     UUID      NOT NULL REFERENCES payment (id),
    creation_date  TIMESTAMP NOT NULL,
    description    TEXT
);
