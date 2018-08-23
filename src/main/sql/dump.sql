CREATE TABLE sectors (
    id serial PRIMARY KEY,
    label VARCHAR (64) NOT NULL,
    parent integer
);
CREATE TABLE users (
    id serial PRIMARY KEY,
    session_id VARCHAR (32) UNIQUE NOT NULL,
    name VARCHAR (64) NOT NULL,
    is_agreed boolean
);
CREATE TABLE user_to_sector (
    user_id integer REFERENCES users (id),
    sector_id integer REFERENCES sectors (id)
);