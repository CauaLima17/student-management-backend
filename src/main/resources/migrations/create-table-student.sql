CREATE TABLE public.student (
	id serial4 NOT NULL,
	"name" varchar(100) NOT NULL,
	registration_id varchar(100) NOT NULL,
	course varchar(100) NOT NULL,
	CONSTRAINT newtable_pk PRIMARY KEY (id),
	CONSTRAINT newtable_unique UNIQUE (registration_id)
);