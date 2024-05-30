DROP TABLE IF EXISTS guitarsDB.guitar_info CASCADE;
CREATE TABLE guitarsDB.guitar_info (id bigserial PRIMARY KEY, model VARCHAR(255), n_frets INT, scale FLOAT);
INSERT INTO guitarsDB.guitar_info (model, n_frets, scale) VALUES
                                                    ('Les Paul', 22, 24.75),
                                                    ('Stratocaster', 21, 25.5),
                                                    ('Telecaster', 22, 25.5),
                                                    ('SG', 24, 24.75),
                                                    ('PRS Custom', 24, 25.0),
                                                    ('Signature', 24, 25.5),
                                                    ('C-profile', 22, 24.6),
                                                    ('SuperStratocaster', 24, 25.5),
                                                    ('SuperStratocaster', 24, 25.5),
                                                    ('C-profile', 24, 24.75);

DROP TABLE IF EXISTS guitarsDB.guitar_brand CASCADE;
CREATE TABLE guitarsDB.guitar_brand (id bigserial PRIMARY KEY, brand VARCHAR(255));
INSERT INTO guitarsDB.guitar_brand (brand) VALUES
                                     ('Gibson'),
                                     ('Fender'),
                                     ('PRS'),
                                     ('Ibanez'),
                                     ('Gretsch'),
                                     ('ESP'),
                                     ('Jackson');

DROP TABLE IF EXISTS guitarsDB.groups CASCADE;
CREATE TABLE guitarsDB.groups (id bigserial PRIMARY KEY, number bigint);
INSERT INTO guitarsDB.groups (number) VALUES
                                (1),
                                (2),
                                (3),
                                (4),
                                (5),
                                (6),
                                (7),
                                (8),
                                (9),
                                (10);

DROP TABLE IF EXISTS guitarsDB.guitars CASCADE;
CREATE TABLE guitarsDB.guitars (id bigserial PRIMARY KEY, name VARCHAR(255), price bigint, id_brand bigint, id_info bigint, FOREIGN KEY (id_brand) REFERENCES guitar_brand(id), FOREIGN KEY (id_info) REFERENCES guitar_info(id));
INSERT INTO guitarsDB.guitars (name, price, id_brand, id_info) VALUES
                                                         ('Standard ’60s', 2800, 1, 1),
                                                         ('American Original ’50s', 2100, 2, 2),
                                                         ('American Original ’50s', 1500, 2, 3),
                                                         ('Standard Reissue', 1700, 1, 4),
                                                         ('Custom 24', 3000, 3, 5),
                                                         ('JEM7VP', 2500, 4, 6),
                                                         ('G5422TDC Electromatic', 1000, 5, 7),
                                                         ('E-II NT', 2200, 6, 8),
                                                         ('USA Soloist SL1', 3900, 7, 9),
                                                         ('ES-335', 2900, 1, 10);

DROP TABLE IF EXISTS guitarsDB.groups_guitars CASCADE;
CREATE TABLE guitarsDB.groups_guitars (group_id bigint, guitar_id bigint, FOREIGN KEY (group_id) REFERENCES groups (id), FOREIGN KEY (guitar_id) REFERENCES guitars (id));
INSERT INTO guitarsDB.groups_guitars (group_id, guitar_id)  VALUES
                                                                (1, 3),
                                                                (1, 4),
                                                                (1, 7),
                                                                (2, 1),
                                                                (2, 2),
                                                                (2, 5),
                                                                (2, 6),
                                                                (2, 8),
                                                                (2, 9),
                                                                (2, 10);
