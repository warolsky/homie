CREATE TABLE budget (
    id UUID NOT NULL PRIMARY KEY,
    date VARCHAR(10) NOT NULL,
    description VARCHAR(100) NOT NULL,
    value FLOAT NOT NULL,
    currency VARCHAR(3) NOT NULL
)
