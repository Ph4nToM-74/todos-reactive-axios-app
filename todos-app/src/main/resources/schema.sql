CREATE TABLE IF NOT EXISTS todo (id SERIAL PRIMARY KEY,
                                 title VARCHAR(255),
                                 description VARCHAR(255),
                                 done BOOLEAN);