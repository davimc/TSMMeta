INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user (name, email, password) VALUES ('Davi','davi@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Sérgio','sergio@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Luciane','luci@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2);

INSERT INTO tb_store (name) VALUES ('Boston');
INSERT INTO tb_store (name) VALUES ('Chicago');
INSERT INTO tb_store (name) VALUES ('Londres');
INSERT INTO tb_store (name) VALUES ('Paris');


INSERT INTO tb_employee (name, salary, position, admission_Date, current_id, original_id) VALUES ('travor', 1500.0, 'Gerente', '2023-01-01', 1,1);
INSERT INTO tb_employee (name, salary, position, admission_Date, current_id, original_id) VALUES ('laican', 1350.0, 'Supervisor geral', '2021-01-01', 2,1);
INSERT INTO tb_employee (name, salary, position, admission_Date, current_id, original_id) VALUES ('malica', 1200.0, 'Garçom', '2023-03-16', 1,1);



INSERT INTO tb_debit (name, date, amount) VALUES ('Aluguel', '2023-03-03', 1300.50);