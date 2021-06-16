create table position
(
    name   varchar(255) not null
        constraint position_pkey
            primary key,
    status varchar(255)
);

alter table position
    owner to postgres;

INSERT INTO public.position (name, status) VALUES ('Пилот SpaceX', 'Действующий');
INSERT INTO public.position (name, status) VALUES ('Машинист буровой установки', 'Действующий');
INSERT INTO public.position (name, status) VALUES ('Самый главный', 'Действующий');
INSERT INTO public.position (name, status) VALUES ('Генеральный директор', 'Действующий');
INSERT INTO public.position (name, status) VALUES ('Номер расчета АГС-17 "Пламя"', 'Действующий');