INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('MODERATOR');
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO users (username, password, first_name, last_name, is_active, role_id, email)
VALUES ('Pesho', '81686302eb39cb3865c7352f127876515a349c476aa22b104f8641fae8a28f9ed7fd6dfe574ec0fc', 'Peter', 'Binkov', 1, 1, 'peter.binkov@gmail.com');