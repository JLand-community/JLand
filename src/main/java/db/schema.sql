-- create database

CREATE DATABASE jland
  WITH OWNER = vagrant
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

-- create schema
CREATE SCHEMA public
  AUTHORIZATION vagrant;

GRANT ALL ON SCHEMA public TO vagrant;
GRANT ALL ON SCHEMA public TO public;

-- create tables
create table if not exists public.timeslot
(
	id serial not null
		constraint timestamp_pk
			primary key,
	date date,
	start_time time,
	end_time time
)
;

create table if not exists public.presentation
(
	presentation_name char(255) [],
	timeslot_id integer not null
		constraint presentation_fk
			references public.timeslot,
	id serial not null
		constraint presentation_pk
			primary key
)
;

create table if not exists public.presentation_details
(
	id serial not null
		constraint presentation_details_pk
			primary key,
	presentation_id integer not null
		constraint presentation_details_fk
			references public.presentation,
	point char(255) [],
	"order" integer
)
;

create index if not exists fki_presentation_details_fk
	on public.presentation_details (presentation_id)
;

create table if not exists public.presenter
(
	id serial not null
		constraint presenter_pk
			primary key,
	first_name char(255) [],
	last_name char(255) [],
	photo bytea
)
;

create table if not exists public.presentation_presenter
(
	presentation_id integer not null,
	presenter_id integer not null
)
;