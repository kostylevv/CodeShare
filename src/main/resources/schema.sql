CREATE TABLE IF NOT EXISTS snippets (
                                     id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     snippet CHARACTER VARYING NOT NULL,
    snippet_date DATE NOT NULL);