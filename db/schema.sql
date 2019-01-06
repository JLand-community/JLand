-- create database

CREATE DATABASE jland
  WITH OWNER = admin
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

-- create schema
CREATE SCHEMA jland_site
  AUTHORIZATION admin;

-- create sequences
create sequence conference_id_seq;

create sequence event_id_seq;

create sequence user_id_seq;

create sequence presentation_id_seq;

create sequence presentation_plan_id_seq;

create sequence participant_id_seq;

-- create tables
create table conference
(
	id          serial not null
		constraint conference_id_pkey
		primary key,
	description varchar,
	date        date,
	address     varchar(255)
);

create table event
(
	id            serial  not null
		constraint event_id_pkey
		primary key,
	conference_id integer not null
		constraint event_conference_id_fkey
		references conference,
	name          varchar(255),
	type          varchar(255),
	start_time    time,
	end_time      time,
	event_order   integer
);

create index event_conference_id_idx
	on event (conference_id);

create table "user"
(
	id         serial not null
		constraint user_id_pkey
		primary key,
	first_name varchar(255),
	last_name  varchar(255),
	photo      bytea
);

create table presentation
(
	id                 serial  not null
		constraint presentation_id_pkey
		primary key,
	event_id           integer not null
		constraint presentation_presentation_id_fkey
		references event,
	name               varchar(255),
	user_id            integer
		constraint presentation_user_id_fkey
		references "user",
	presentation_order integer
);

create index presentation_event_id_idx
	on presentation (event_id);

create table presentation_plan
(
	id              serial  not null
		constraint presentation_plan_id_pkey
		primary key,
	presentation_id integer not null
		constraint presentation_plan_presentation_id_fkey
		references presentation,
	point           varchar(255),
	item_order      integer
);

create index presentation_plan_presentation_id_idx
	on presentation_plan (presentation_id);

create table participant
(
	id            serial                not null
		constraint participant_id_pkey
		primary key,
	user_id       integer               not null
		constraint participant_user_id_fkey
		references "user",
	conference_id integer               not null
		constraint participant_conference_id_fkey
		references conference,
	event_role       varchar(255)
);

