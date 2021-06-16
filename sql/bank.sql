create table bank
(
    id      bigint not null
        constraint bank_pkey
            primary key,
    address varchar(255),
    bic     varchar(255),
    name    varchar(255),
    status  varchar(255)
);

alter table bank
    owner to postgres;

INSERT INTO public.bank (id, address, bic, name, status) VALUES (43, 'Россия, Москва, 117312, ул. Вавилова, д. 19 ', '044525225', 'ПАО Сбербанк', 'Действующий');
INSERT INTO public.bank (id, address, bic, name, status) VALUES (44, ' 191144, г. Санкт-Петербург, Дегтярный переулок, д. 11, лит. А', '044525745', 'Банк ВТБ (ПАО)', 'Действующий');
INSERT INTO public.bank (id, address, bic, name, status) VALUES (45, '127287, г. Москва, ул. Хуторская 2-я, д. 38А, стр. 26', '044525974', 'АО «Тинькофф Банк»', 'Действующий');
INSERT INTO public.bank (id, address, bic, name, status) VALUES (46, '129090, Москва, ул.Троицкая, д.17, стр. 1', '044525700', 'АО «Райффайзенбанк»', 'Действующий');