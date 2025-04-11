CREATE TABLE IF NOT EXISTS snippets (
                                     uuid VARCHAR NOT NULL PRIMARY KEY,
                                     snippet VARCHAR(100) NOT NULL,
    snippet_date TIMESTAMP,
    view_limit INTEGER,
    time_limit INTEGER);