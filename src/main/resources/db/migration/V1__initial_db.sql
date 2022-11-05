create table company(
    id serial primary key,
    title text not null,
    descr text not null,
    prev text not null
);

create table company_rew(
    id bigserial primary key,
    user_id integer not null,
    ticket_id bigint not null,
    info text,
    rew_rating numeric(2, 1) check (rew_rating<=5.0 and rew_rating>=0.0),
    set_rating integer check (set_rating<=5 and set_rating>=0),
    create_time timestamp with time zone not null
);

create table plane(
    id text primary key,
    sit_count integer not null,
    model_type integer not null,
    company_id integer not null,
        constraint fk_plane_company foreign key (company_id) references company(id) on update cascade on delete cascade
);

create unique index on company_rew(ticket_id);