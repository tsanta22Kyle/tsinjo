ALTER TABLE payment
    ADD date TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE payment
    ADD psp_type VARCHAR(255);

ALTER TABLE payment
    ADD status VARCHAR(255);

ALTER TABLE payment
    ALTER COLUMN date SET NOT NULL;

ALTER TABLE payment
    ALTER COLUMN psp_type SET NOT NULL;

ALTER TABLE payment
    ALTER COLUMN status SET NOT NULL;

ALTER TABLE donation
    DROP COLUMN creation_date;

ALTER TABLE donation
    DROP COLUMN payment_id;

ALTER TABLE help
    DROP COLUMN creation_date;

ALTER TABLE help
    DROP COLUMN payment_id;

ALTER TABLE payment
    DROP COLUMN creation_instant;

ALTER TABLE payment
    DROP COLUMN method;

ALTER TABLE payment
    DROP COLUMN verification_attempt_nb;

ALTER TABLE payment
    DROP COLUMN verification_status;

ALTER TABLE payment
    DROP COLUMN id;

ALTER TABLE help
    ALTER COLUMN description TYPE VARCHAR(255) USING (description::VARCHAR(255));

ALTER TABLE help
    ALTER COLUMN description SET NOT NULL;

ALTER TABLE beneficiary
    ALTER COLUMN email TYPE VARCHAR(255) USING (email::VARCHAR(255));

ALTER TABLE donor
    ALTER COLUMN email TYPE VARCHAR(255) USING (email::VARCHAR(255));

ALTER TABLE beneficiary
    ALTER COLUMN full_name TYPE VARCHAR(255) USING (full_name::VARCHAR(255));

ALTER TABLE donor
    ALTER COLUMN full_name TYPE VARCHAR(255) USING (full_name::VARCHAR(255));

ALTER TABLE payment
    ADD id VARCHAR(255) NOT NULL PRIMARY KEY;

ALTER TABLE donation
    ADD payment_id VARCHAR(255) NOT NULL;

ALTER TABLE donation
    ADD CONSTRAINT FK_DONATION_ON_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (id);

ALTER TABLE help
    ADD payment_id VARCHAR(255) NOT NULL;

ALTER TABLE help
    ADD CONSTRAINT FK_HELP_ON_PAYMENT FOREIGN KEY (payment_id) REFERENCES payment (id);

ALTER TABLE payment
    ALTER COLUMN psp_payment_id TYPE VARCHAR(255) USING (psp_payment_id::VARCHAR(255));