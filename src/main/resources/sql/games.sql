CREATE TABLE IF NOT EXISTS games (
                                     game_id SERIAL PRIMARY KEY,
                                     game_name VARCHAR(30) NOT NULL,
                                     minimum_play_amount DECIMAL(3, 2) NOT NULL,
                                     win_rate DECIMAL(3, 2) NOT NULL
);
CREATE TABLE IF NOT EXISTS users (
                                     user_id SERIAL PRIMARY KEY,
                                     username VARCHAR(15) NOT NULL UNIQUE,
                                     balance DECIMAL(10,2) NOT NULL
);
CREATE TABLE IF NOT EXISTS game_history (
                                            history_id SERIAL PRIMARY KEY,
                                            user_id INT NOT NULL,
                                            game_id INT NOT NULL,
                                            play_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                            FOREIGN KEY (game_id) REFERENCES games(game_id) ON DELETE CASCADE
);

INSERT INTO users (username, balance)
VALUES ('cagatay', 1000),
       ('ego', 1000);


INSERT INTO games (game_name, minimum_play_amount, win_rate)
VALUES ('Gates Of Olympus', 0.20, 0.45),
       ('Sweet Bonanza', 0.20, 0.10),
       ('Saray Rüyası', 0.20, 0.75);

select * from game_history;

ALTER TABLE game_history
    ADD COLUMN winAmount DECIMAL(10, 2);