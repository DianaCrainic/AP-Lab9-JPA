create table artists(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    country varchar(100),
    primary key (id)
);
create table albums(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    artist_id integer not null references artists on delete restrict,
    release_year integer,
    primary key (id)
);
create table chart (
    id integer not null generated always as identity,
    album_id integer not null references albums on delete restrict,
    profit integer, 
    primary key (id)
);
