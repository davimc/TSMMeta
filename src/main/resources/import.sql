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

INSERT INTO tb_goal (date, amount, store_id) VALUES ('2023-01-01', 85000.00, 1);
INSERT INTO tb_goal (date, amount, store_id) VALUES ('2023-02-01', 69020.30, 2);
INSERT INTO tb_goal (date, amount, store_id) VALUES ('2022-01-01', 50005.90, 3);
INSERT INTO tb_goal (date, amount, store_id) VALUES ('2022-03-01', 10101.01, 4);
INSERT INTO tb_goal (date, amount, store_id) VALUES ('2022-02-01', 85000.00, 1);

INSERT INTO tb_debit (name, date, amount,store_id, status) VALUES ('Aluguel', '2023-03-03', 10300.50,1,1);
INSERT INTO tb_debit (name, date, amount,store_id, status) VALUES ('Agua', '2023-03-14', 7300.77,1,1);
INSERT INTO tb_debit (name, date, amount,store_id, status) VALUES ('Luz', '2023-03-12', 2000.20,1,1);
INSERT INTO tb_debit (name, date, amount,store_id, status) VALUES ('Adquirir toaster', '2023-03-16', 72000.0,1,2);

INSERT INTO tb_tax (name, percentage) VALUES ('ICMS', 17.0);
INSERT INTO tb_tax (name, percentage) VALUES ('ISS', 22.5);
INSERT INTO tb_tax (name, percentage) VALUES ('IMTS', 0.3);

INSERT INTO tb_taxes_stores (tax_id, store_id) VALUES (1,1);
INSERT INTO tb_taxes_stores (tax_id, store_id) VALUES (2,1);
INSERT INTO tb_taxes_stores (tax_id, store_id) VALUES (3,1);
INSERT INTO tb_taxes_stores (tax_id, store_id) VALUES (1,2);
INSERT INTO tb_taxes_stores (tax_id, store_id) VALUES (2,2);
