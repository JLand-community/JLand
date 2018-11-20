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

GRANT ALL ON SCHEMA jland_site TO admin;

-- create tables
create table if not exists jland_site.conference
(
	id serial not null
		constraint conference_id_pkey
			primary key,
			description varchar
	date date,
	place varchar(255) []
)
;

create table if not exists jland_site.event
(
  id serial not null
		constraint event_id_pkey
			primary key,
			conference_id integer not null
		constraint event_conference_id_fkey
			references jland_site.conference,
  name varchar(255) [],
  type varchar(255) [],
  start_time time,
  end_time time,
  order integer
)
;

create table if not exists jland_site.presentation
(
	id serial not null
		constraint presentation_id_pkey
			primary key,
	event_id integer not null
		constraint presentation_presentation_id_fkey
			references jland_site.event,
	name varchar(255),
	user_id integer,
	constraint presentation_user_id_fkey
			references jland_site.user,
	point varchar(255) [],
	order integer
)
;

create index if not exists fki_presentation_fk
	on jland_site.presentation (event_id)
;

create table if not exists jland_site.user
(
	id serial not null
		constraint user_id_pkey
			primary key,
	first_name varchar(255) [],
	last_name varchar(255) [],
	photo bytea
)
;