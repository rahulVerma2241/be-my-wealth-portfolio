create table "fixed-deposit"
(
    id               uuid not null primary key ,
    close_date       date,
    current_amount   numeric(38, 2),
    institution_name varchar(255),
    interest_rate    numeric(38, 2),
    maturity_amount  numeric(38, 2),
    nominee_name     varchar(255),
    open_date        date,
    principal_amount numeric(38, 2),
    user_id          varchar(255)
);

ALTER TABLE "fixed-deposit" alter column id set default gen_random_uuid();

