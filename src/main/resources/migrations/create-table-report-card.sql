CREATE TABLE public.report_card (
	id serial NOT NULL,
	student_id int NOT NULL,
	subject varchar NOT NULL,
	grade numeric NOT NULL,
	semester varchar NOT NULL,
	CONSTRAINT report_card_pk PRIMARY KEY (id),
	CONSTRAINT report_card_student_fk_1 FOREIGN KEY (student_id) REFERENCES public.student(id) ON DELETE CASCADE
);