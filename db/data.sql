INSERT INTO conference(description, date, address)
VALUES ('Java Community Conference', '2019-03-23', 'Andrey Fabra Str., 2 (International House)');

/*users*/
INSERT INTO "user"(first_name, last_name, photo)
VALUES ('Serhii','Zubenko','');

INSERT INTO "user"(first_name, last_name, photo)
VALUES ('Maxim','Stezhka','');

/*events, event.name = presentation.name*/
INSERT INTO event(conference_id, name, type, start_time, end_time, event_order)
VALUES (1, 'Welcome Coffee', 'Default', '11:00', '11:15', 0);

INSERT INTO event(conference_id, name, type, start_time, end_time, event_order)
VALUES (1, 'Gradle', 'Presentation', '11:15', '12:30', 1);

INSERT INTO event(conference_id, name, type, start_time, end_time, event_order)
VALUES (1, 'Coffee break', 'Coffee break', '12:30', '12:45', 2);

INSERT INTO event(conference_id, name, type, start_time, end_time, event_order)
VALUES (1, 'Docker', 'Presentation', '12:45', '14:00', 3);

/*presentations, presentation.order = event.order*/
INSERT INTO presentation(event_id, name, user_id, presentation_order)
VALUES (2, 'Gradle', 2, 1);
INSERT INTO presentation(event_id, name, user_id, presentation_order)
VALUES (4, 'Docker', 1, 3);

/*presentation plan, Gradle*/
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (1, 'Main aspects of Gradle build tool', 1);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (1, 'Comparison with Maven: where Maven is weak and Gradle is strong.', 2);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (1, 'Gradle lack of lifecycle - the main advantage.', 3);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (1, 'Gradle API overview.', 4);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (1, 'Gradle usage on the example of microservices project.', 5);

/*presentation plan, Docker*/
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'Container and VM.', 1);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'Docker.', 2);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'Interaction of containers.', 3);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'Docker-compose.', 4);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'Popular images.', 5);
INSERT INTO presentation_plan(presentation_id, point, item_order)
VALUES (2, 'tbc', 6);

/*participants*/
INSERT INTO jland_site.participant (user_id, conference_id) VALUES (1, 1);
INSERT INTO jland_site.participant (user_id, conference_id) VALUES (2, 1);

/*users*/
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (1, 'Serhii', 'Zubenko', '', 'zubeser', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (2, 'Maxim', 'Stezhka', '', 'stezmax', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (9, 'Alexey', 'Sheleg', 'default', 'shelale', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (10, 'Artem', 'Lebediev', null, 'lebeart', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (11, 'Daniil', 'Ponomarev', 'default', 'ponodan', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (12, 'Sergey', 'Demenkov', 'default', 'demeser', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (13, 'Julia', 'Miskevich', 'default', 'miskjul', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (14, 'Pavel', 'Pavel', 'default', 'pavepav', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (15, 'Sergey', 'Gudimov', null, 'gudiser', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (16, 'Sergey', 'Solovey', null, 'soloser', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (17, 'Siamang', 'Siamang', 'default', 'siamsia', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (18, 'Volodymyr', 'Kireiko', null, 'kirevol', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (19, 'Anya', 'Khalikova', null, 'khalany', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (20, 'Vasiliy', 'Svinenkov', null, 'svinvas', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (21, 'Julia', 'Shinkarenko', null, 'shinjul', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (5, 'Oksana', 'Gromova', '', 'gromoks', '$2a$10$WWCV94TZIFo/gxETY3x2oeh9oKGk4HKx9tOyqT9ERVqKeHLW/GY8K', 'ADMIN');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (4, 'Yana', 'Demenkova', '', 'demeyan', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (6, 'Anatoliy', 'Trubin', '', 'trubana', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (3, 'Alena', 'Stroganova', 'default', 'stroale', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (7, 'User', '', 'default', 'user', '$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa', 'USER');
INSERT INTO jland_site."user" (id, first_name, last_name, photo, username, password, user_role) VALUES (8, 'Admin', '', 'default', 'admin', '$2a$10$WWCV94TZIFo/gxETY3x2oeh9oKGk4HKx9tOyqT9ERVqKeHLW/GY8K', 'ADMIN');
