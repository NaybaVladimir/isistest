create table employee
(
    id                 bigint not null
        constraint employee_pkey
            primary key,
    date_birthday      timestamp with time zone,
    date_of_employment timestamp with time zone,
    mobile_number      varchar(255),
    name               varchar(255),
    patronymic         varchar(255),
    salary_level       varchar(255),
    sex                varchar(255),
    status             varchar(255),
    surname            varchar(255),
    work_phone_number  varchar(255),
    bank_id            bigint
        constraint fkicptso0qh4vmwt76bgf5hm9p6
            references bank,
    position_name      varchar(255)
        constraint fkgkdone991hiwq0et69p2u5q3n
            references position
);

alter table employee
    owner to postgres;

INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (48, '1952-10-06 17:00:00.000000', '2000-07-11 17:00:00.000000', '1', 'Владимир', 'Владимирович', '2000000', 'Мужской', 'Действующий', 'Путин', '2', 43, 'Самый главный');
INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (49, '1988-09-19 16:00:00.000000', '2001-03-02 18:00:00.000000', '88888888888', 'Хабиб', 'Абдулманапович', '', 'Мужской', 'Действующий', 'Нурмагомедов', '88888888888', 44, 'Номер расчета АГС-17 "Пламя"');
INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (50, '1974-01-26 17:00:00.000000', '2015-06-15 18:00:00.000000', '89999999999', 'Уле-Эйнар', '', '30000', 'Мужской', 'Действующий', 'Бьёрндален', '89999999999', 45, 'Машинист буровой установки');
INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (51, '1856-07-09 17:00:00.000000', '1900-10-09 18:28:20.000000', '9', 'Никола', '', '2000000', 'Мужской', 'Действующий', 'Тесла', '9', 46, 'Генеральный директор');
INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (52, '1971-06-27 17:00:00.000000', '2010-01-16 18:00:00.000000', '13', 'Илон', 'Рив', '1000000', 'Мужской', 'Действующий', 'Маск', '13', 46, 'Самый главный');
INSERT INTO public.employee (id, date_birthday, date_of_employment, mobile_number, name, patronymic, salary_level, sex, status, surname, work_phone_number, bank_id, position_name) VALUES (47, '1988-07-13 16:00:00.000000', '2010-02-12 18:00:00.000000', '123', 'Конор', '', '100000', 'Мужской', 'Действующий', 'Макгрегор', '123456', 43, 'Пилот SpaceX');