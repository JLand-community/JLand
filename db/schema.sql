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

-- create tables
create table if not exists jland_site.conference
(
	id serial
		constraint conference_id_pkey
			primary key,
			description varchar,
	date date,
	address varchar(255)
)
;

create table if not exists jland_site.event
(
  id serial
		constraint event_id_pkey
			primary key,
			conference_id integer not null
		constraint event_conference_id_fkey
			references jland_site.conference,
  name varchar(255),
  type varchar(255),
  start_time time,
  end_time time,
  order integer
)
;

create table if not exists jland_site.presentation
(
	id serial
		constraint presentation_id_pkey
			primary key,
	event_id integer not null
		constraint presentation_presentation_id_fkey
			references jland_site.event,
	name varchar(255),
	user_id integer,
	constraint presentation_user_id_fkey
			references jland_site.user,
	order integer
)
;

create table if not exists jland_site.presentation_plan
(
	id serial
		constraint presentation_plan_id_pkey
			primary key,
	presentation_id integer not null
		constraint presentation_plan_presentation_id_fkey
			references jland_site.presentation,
	point varchar(255),
	order integer
)
;

create table if not exists jland_site.user
(
	id serial
		constraint user_id_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	photo bytea
)
;

create index if not exists presentation_event_id_idx
	on jland_site.presentation (event_id)
;

create index if not exists event_conference_id_idx
	on jland_site.event (conference_id)
;

create index if not exists presentation_plan_presentation_id_idx
	on jland_site.presentation_plan (presentation_id)
;