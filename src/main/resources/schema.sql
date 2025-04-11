CREATE TABLE IF NOT EXISTS snippets (
                                     uuid CHARACTER VARYING NOT NULL PRIMARY KEY,
                                     snippet CHARACTER LARGE OBJECT NOT NULL,
    snippet_date TIMESTAMP);