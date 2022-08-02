create table hibernate_tutorial.user
(
    id             int auto_increment
        primary key,
    first_name     varchar(100) not null,
    last_name      varchar(100) null
);

