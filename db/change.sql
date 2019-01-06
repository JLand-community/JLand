CREATE TABLE jland_site.participant
(
  id serial NOT NULL,
  user_id integer NOT NULL,
  conference_id integer NOT NULL,
  event_role       varchar(255),
  CONSTRAINT participant_id_pkey PRIMARY KEY (id),
  CONSTRAINT participant_conference_id_fkey FOREIGN KEY (conference_id)
  REFERENCES jland_site.conference (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT participant_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES jland_site."user" (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE jland_site.participant
  OWNER TO admin;