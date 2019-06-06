/* Powers */
INSERT INTO db_ey_heroes.power (id, name)
VALUES (1, 'Voar');

INSERT INTO db_ey_heroes.power (id, name)
VALUES (2, 'Força sobrenatural');

INSERT INTO db_ey_heroes.power (id, name)
VALUES (3, 'Invisibilidade');

INSERT INTO db_ey_heroes.power (id, name)
VALUES (4, 'Telepatia');

INSERT INTO db_ey_heroes.power (id, name)
VALUES (5, 'Gerar fogo com as mãos');

/* Universes */
INSERT INTO db_ey_heroes.universe (id, name)
VALUES (1, 'EY Comics');

INSERT INTO db_ey_heroes.universe (id, name)
VALUES (2, 'Trainee Comics');

INSERT INTO db_ey_heroes.universe (id, name)
VALUES (3, 'Outros');

/* Heroes */
INSERT INTO db_ey_heroes.hero(id, creation_date, name, universe_id)
VALUES(1, now(), 'Russelzão', 1);
INSERT INTO db_ey_heroes.hero_powers(hero_id, powers_id)
VALUES(1, 1);
INSERT INTO db_ey_heroes.hero_powers(hero_id, powers_id)
VALUES(1, 2);

INSERT INTO db_ey_heroes.hero(id, creation_date, name, universe_id)
VALUES(2, now(), 'A mulher russelzona', 2);
INSERT INTO db_ey_heroes.hero_powers(hero_id, powers_id)
VALUES(2, 3);
INSERT INTO db_ey_heroes.hero_powers(hero_id, powers_id)
VALUES(2, 4);
INSERT INTO db_ey_heroes.hero_powers(hero_id, powers_id)
VALUES(2, 5);

/* Joga auto incremtos pra frente para nao dar conflitos com os registros criados acima */
UPDATE db_ey_heroes.hibernate_sequence
SET next_val = 100;
