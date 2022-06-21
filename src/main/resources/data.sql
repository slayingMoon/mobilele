INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('MODERATOR');
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO users (username, password, first_name, last_name, is_active, role_id, email)
VALUES ('Pesho', '81686302eb39cb3865c7352f127876515a349c476aa22b104f8641fae8a28f9ed7fd6dfe574ec0fc', 'Peter', 'Binkov', 1, 1, 'peter.binkov@gmail.com');

INSERT INTO brands (name)
VALUES ('Ford'),
       ('Toyota');

INSERT INTO models (name, category, start_year, end_year, brand_id, image_url)
VALUES ('Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/413px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
        ('Escort', 'CAR', 1968, 2000, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg'),
        ('Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/420px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg')
