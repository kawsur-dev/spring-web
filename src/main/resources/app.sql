create table hibernate_tutorial.user
(
    id             int auto_increment
        primary key,
    first_name     varchar(100) not null,
    last_name      varchar(100) null,
    user_detail_id bigint       null,
    constraint user_user_detail_id_fk
        foreign key (user_detail_id) references hibernate_tutorial.user_detail (id)
);

create table hibernate_tutorial.user_detail
(
    id          bigint auto_increment
        primary key,
    father_name varchar(100) not null,
    mother_name varchar(100) not null
);

create table hibernate_tutorial.user_contact
(
    id             bigint auto_increment
        primary key,
    type           varchar(100) not null,
    contact_no     varchar(100) not null,
    user_detail_id bigint       not null,
    constraint contact_no_unique
        unique (contact_no),
    constraint user_contact_user_detail_id_fk
        foreign key (id) references hibernate_tutorial.user_detail (id)
);

