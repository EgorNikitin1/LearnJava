DROP TABLE IF EXISTS public.guitars CASCADE;
CREATE TABLE public.guitars (id bigserial PRIMARY KEY, name VARCHAR(255), brand VARCHAR(255), model VARCHAR(255), n_frets INTEGER, scale FLOAT, price INTEGER);
INSERT INTO public.guitars (name, brand, model, n_frets, scale, price) VALUES
                                                                               ('Gibson', 'Standard ’60s', 'Les Paul', 22, 24.75, 2800),
                                                                               ('Fender', 'American Original ’50s', 'Stratocaster', 21, 25.5, 2100),
                                                                               ('Fender', 'American Original ’50s', 'Telecaster', 22, 25.5, 1500),
                                                                               ('Gibson', 'Standard Reissue', 'SG', 24, 24.75, 1700),
                                                                               ('PRS', 'Custom 24', 'PRS Custom', 24, 25.0, 3000),
                                                                               ('Ibanez', 'JEM7VP', 'Signature', 24, 25.5, 2500),
                                                                               ('Gretsch', 'G5422TDC Electromatic', 'C-profile', 22, 24.6, 1000),
                                                                               ('ESP', 'E-II NT', 'SuperStratocaster', 24, 25.5, 2200),
                                                                               ('Jackson', 'USA Soloist SL1', 'SuperStratocaster', 24, 25.5, 3900),
                                                                               ('Gibson', 'ES-335', 'C-profile', 24, 24.75, 2900);
