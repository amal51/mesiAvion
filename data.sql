--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS mesi_avion;
--
-- Name: mesi_avion; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mesi_avion WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE mesi_avion OWNER TO postgres;

\connect mesi_avion

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: avion; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.avion (
    arn character varying(10) NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    estenmaintenance boolean DEFAULT true NOT NULL,
    idmodele bigint
);


ALTER TABLE public.avion OWNER TO mesi;

--
-- Name: constructeur; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.constructeur (
    idconstructeur bigint NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    nomconstructeur character varying(50) NOT NULL
);


ALTER TABLE public.constructeur OWNER TO mesi;

--
-- Name: constructeur_idconstructeur_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.constructeur_idconstructeur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.constructeur_idconstructeur_seq OWNER TO mesi;

--
-- Name: constructeur_idconstructeur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.constructeur_idconstructeur_seq OWNED BY public.constructeur.idconstructeur;


--
-- Name: detailsvols; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.detailsvols (
    iddetailsvols bigint NOT NULL,
    datearrivee timestamp without time zone NOT NULL,
    datedepart timestamp without time zone NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    arn character varying(10),
    idvol bigint
);


ALTER TABLE public.detailsvols OWNER TO mesi;

--
-- Name: detailsvols_iddetailsvols_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.detailsvols_iddetailsvols_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detailsvols_iddetailsvols_seq OWNER TO mesi;

--
-- Name: detailsvols_iddetailsvols_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.detailsvols_iddetailsvols_seq OWNED BY public.detailsvols.iddetailsvols;


--
-- Name: langues; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.langues (
    idlangue bigint NOT NULL,
    nomlangue character varying(50) NOT NULL
);


ALTER TABLE public.langues OWNER TO mesi;

--
-- Name: langues_idlangue_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.langues_idlangue_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.langues_idlangue_seq OWNER TO mesi;

--
-- Name: langues_idlangue_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.langues_idlangue_seq OWNED BY public.langues.idlangue;


--
-- Name: messages; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.messages (
    idmessage bigint NOT NULL,
    message character varying(255),
    idlangue bigint
);


ALTER TABLE public.messages OWNER TO mesi;

--
-- Name: messages_idmessage_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.messages_idmessage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.messages_idmessage_seq OWNER TO mesi;

--
-- Name: messages_idmessage_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.messages_idmessage_seq OWNED BY public.messages.idmessage;


--
-- Name: modeleavion; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.modeleavion (
    idmodele bigint NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    nomavion character varying(50) NOT NULL,
    nombreplaceaffaire integer DEFAULT 0 NOT NULL,
    nombreplaceeco integer DEFAULT 0 NOT NULL,
    idconstructeur bigint
);


ALTER TABLE public.modeleavion OWNER TO mesi;

--
-- Name: modeleavion_avion; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.modeleavion_avion (
    modeleavion_idmodele bigint NOT NULL,
    avion_arn character varying(10) NOT NULL
);


ALTER TABLE public.modeleavion_avion OWNER TO mesi;

--
-- Name: modeleavion_idmodele_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.modeleavion_idmodele_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modeleavion_idmodele_seq OWNER TO mesi;

--
-- Name: modeleavion_idmodele_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.modeleavion_idmodele_seq OWNED BY public.modeleavion.idmodele;


--
-- Name: passagers; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.passagers (
    numerocni character varying(255) NOT NULL,
    datenaissancepassager timestamp without time zone NOT NULL,
    emailpassager character varying(255) NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    genrepassager character(1) NOT NULL,
    motdepassepassager character varying(255),
    nompassager character varying(100) NOT NULL,
    numerotelephonepassager character varying(15) NOT NULL,
    prenompassager character varying(100) NOT NULL
);


ALTER TABLE public.passagers OWNER TO mesi;

--
-- Name: reservation; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.reservation (
    idreservation bigint NOT NULL,
    classe character(1) NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    iddetailsvols bigint,
    idpassager character varying(255)
);


ALTER TABLE public.reservation OWNER TO mesi;

--
-- Name: reservation_idreservation_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.reservation_idreservation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_idreservation_seq OWNER TO mesi;

--
-- Name: reservation_idreservation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.reservation_idreservation_seq OWNED BY public.reservation.idreservation;


--
-- Name: vol; Type: TABLE; Schema: public; Owner: mesi
--

CREATE TABLE public.vol (
    idvol bigint NOT NULL,
    estactif boolean DEFAULT true NOT NULL,
    villearriveevol character varying(100) NOT NULL,
    villedepartvol character varying(100) NOT NULL
);


ALTER TABLE public.vol OWNER TO mesi;

--
-- Name: vol_idvol_seq; Type: SEQUENCE; Schema: public; Owner: mesi
--

CREATE SEQUENCE public.vol_idvol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vol_idvol_seq OWNER TO mesi;

--
-- Name: vol_idvol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mesi
--

ALTER SEQUENCE public.vol_idvol_seq OWNED BY public.vol.idvol;


--
-- Name: constructeur idconstructeur; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.constructeur ALTER COLUMN idconstructeur SET DEFAULT nextval('public.constructeur_idconstructeur_seq'::regclass);


--
-- Name: detailsvols iddetailsvols; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.detailsvols ALTER COLUMN iddetailsvols SET DEFAULT nextval('public.detailsvols_iddetailsvols_seq'::regclass);


--
-- Name: langues idlangue; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.langues ALTER COLUMN idlangue SET DEFAULT nextval('public.langues_idlangue_seq'::regclass);


--
-- Name: messages idmessage; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.messages ALTER COLUMN idmessage SET DEFAULT nextval('public.messages_idmessage_seq'::regclass);


--
-- Name: modeleavion idmodele; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion ALTER COLUMN idmodele SET DEFAULT nextval('public.modeleavion_idmodele_seq'::regclass);


--
-- Name: reservation idreservation; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.reservation ALTER COLUMN idreservation SET DEFAULT nextval('public.reservation_idreservation_seq'::regclass);


--
-- Name: vol idvol; Type: DEFAULT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.vol ALTER COLUMN idvol SET DEFAULT nextval('public.vol_idvol_seq'::regclass);


--
-- Data for Name: avion; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.avion VALUES ('73-1677', true, false, 1);
INSERT INTO public.avion VALUES ('OM-ACB', true, true, 1);
INSERT INTO public.avion VALUES ('PH-MPS', true, false, 2);
INSERT INTO public.avion VALUES ('EP-NHT', true, false, 2);
INSERT INTO public.avion VALUES ('EP-CQA', true, false, 2);
INSERT INTO public.avion VALUES ('ER-BAT', false, false, 3);
INSERT INTO public.avion VALUES ('ER-BAM', true, false, 3);
INSERT INTO public.avion VALUES ('N465MC', true, false, 3);
INSERT INTO public.avion VALUES ('N741CK', true, false, 4);
INSERT INTO public.avion VALUES ('4L-GEO', true, false, 4);
INSERT INTO public.avion VALUES ('4L-GEL', true, false, 4);
INSERT INTO public.avion VALUES ('EP-ICD', true, false, 5);
INSERT INTO public.avion VALUES ('HZ-HM1C', true, false, 5);
INSERT INTO public.avion VALUES ('A6-COM', true, false, 5);
INSERT INTO public.avion VALUES ('75-0125', true, true, 6);
INSERT INTO public.avion VALUES ('PH-BFH', false, false, 6);
INSERT INTO public.avion VALUES ('5-8108', true, false, 6);
INSERT INTO public.avion VALUES ('OO-ACE', true, false, 7);
INSERT INTO public.avion VALUES ('OM-ACG', true, false, 7);


--
-- Data for Name: constructeur; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.constructeur VALUES (1, true, 'Airbus');
INSERT INTO public.constructeur VALUES (2, true, 'Boeing');


--
-- Data for Name: detailsvols; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.detailsvols VALUES (1, '2019-09-15 15:35:00.001', '2019-09-14 19:22:36', true, 'PH-MPS', 9);
INSERT INTO public.detailsvols VALUES (2, '2019-09-15 19:22:57', '2019-09-15 15:23:07', true, 'A6-COM', 2);
INSERT INTO public.detailsvols VALUES (3, '2019-09-15 19:22:57', '2019-09-15 17:27:30', true, 'OO-ACE', 4);
INSERT INTO public.detailsvols VALUES (4, '2019-09-17 13:22:57', '2019-09-17 11:27:08', true, 'A6-COM', 1);
INSERT INTO public.detailsvols VALUES (5, '2019-09-11 19:22:57', '2019-09-13 16:27:59', true, 'ER-BAM', 5);
INSERT INTO public.detailsvols VALUES (6, '2019-09-17 23:22:57', '2019-09-17 19:27:50', true, 'A6-COM', 1);


--
-- Data for Name: langues; Type: TABLE DATA; Schema: public; Owner: mesi
--



--
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: mesi
--



--
-- Data for Name: modeleavion; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.modeleavion VALUES (5, true, '737 MAX 9', 0, 210, 2);
INSERT INTO public.modeleavion VALUES (3, true, 'A340', 30, 150, 1);
INSERT INTO public.modeleavion VALUES (6, true, '737 MAX 10', 0, 250, 2);
INSERT INTO public.modeleavion VALUES (4, true, 'A320', 0, 150, 1);
INSERT INTO public.modeleavion VALUES (1, true, 'A380', 80, 320, 1);
INSERT INTO public.modeleavion VALUES (2, true, 'A350', 60, 250, 1);
INSERT INTO public.modeleavion VALUES (7, true, '747', 30, 154, 2);
INSERT INTO public.modeleavion VALUES (8, true, '787', 62, 245, 2);


--
-- Data for Name: modeleavion_avion; Type: TABLE DATA; Schema: public; Owner: mesi
--



--
-- Data for Name: passagers; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.passagers VALUES ('yq96s87w74cfs654rbr6u8xi3gj7wh3z6624', '1950-09-11 00:00:00', 'jeff.trujillo@gmail.com', true, 'h', 'AhComaeb1', 'Tryjillo', '832-597-9422', 'Jeffrey');
INSERT INTO public.passagers VALUES ('9cqx58j36554669dzj4ss46di3t8f3hbvj6e', '1980-11-15 00:00:00', 'CaiTang@gmail.com', true, 'f', 'iG8Aemohzuha', 'T''ang', '01.12.03.39.92', 'Cai');
INSERT INTO public.passagers VALUES ('5c4x384ae54zn3372w5hxyz2w8b9nw4u6s4i', '1999-12-11 00:00:00', 'lecuyer.v@gmail.com', true, 'f', 'cheo5iCh1e', 'Lécuyer', '03.71.18.71.52', 'Vedette');
INSERT INTO public.passagers VALUES ('z3r8gnbd99z2er8jn4n7a78rp86e56f6x933', '1993-01-04 00:00:00', 'HarrietteLemaitre@gmail.com', true, 'f', 'AeLoh4uu', 'Lemaître', '01.03.18.01.65', 'Harriette');
INSERT INTO public.passagers VALUES ('ur5n72z8w54i6rz8p49j27m293scn58dhnq4', '1970-07-10 00:00:00', 'AdeleParenteau@hotmail.fr', true, 'f', 'eeN8lahng4ee', 'Parenteau', '04.72.78.18.23', 'Adèle');
INSERT INTO public.passagers VALUES ('j9kmxk7433a36uwn3r3e8y68486v497yshzu', '1953-08-25 00:00:00', 'WilliamFranchet@gmail.com', true, 'h', 'xaiW5aMoo', 'Franchet', '04.91.29.08.46', 'William');
INSERT INTO public.passagers VALUES ('4qzz65vx52bc25f7qr345xy589u4i522pgwj', '1992-09-09 00:00:00', 'MerlinFluet@rhyta.com', true, 'h', 'Ohf4Ep7usa9', 'Fluet', '05.65.42.20.51', 'Merlin');
INSERT INTO public.passagers VALUES ('5dj8365a4n5xkp7rh9qs46mhis9285ky2j77', '1997-12-06 00:00:00', 'BruceAdler@dayrep.com', true, 'h', 'jah6Cooch', 'Adler', '04.10.30.52.85', 'Bruce');
INSERT INTO public.passagers VALUES ('kt53gg68m2qxcu5rk53u388tx92my562m78j', '1994-06-18 00:00:00', 'HarbinVeronneau@teleworm.us', true, 'h', 'Chebu8voh4ae', 'Veronneau', '01.34.98.06.27', 'Harbin');
INSERT INTO public.passagers VALUES ('ng7yane94t9qtwe8sy48554ts77k3b36632f', '2005-09-07 19:36:13', 'AlfredFoucault@dayrep.com', true, 'h', 'xiec1Shu', 'Foucault', '02.29.35.57.15', 'Alfred');


--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: mesi
--



--
-- Data for Name: vol; Type: TABLE DATA; Schema: public; Owner: mesi
--

INSERT INTO public.vol VALUES (1, true, 'Lesquin', 'Aix');
INSERT INTO public.vol VALUES (2, true, 'Aix', 'Lesquin');
INSERT INTO public.vol VALUES (3, true, 'Rome', 'Bruxelles');
INSERT INTO public.vol VALUES (4, true, 'Bruxelles', 'Rome');
INSERT INTO public.vol VALUES (5, true, 'Naples', 'Bruxelles');
INSERT INTO public.vol VALUES (6, true, 'Bruxelles', 'Naples');
INSERT INTO public.vol VALUES (7, true, 'Barcelone', 'Bruxelles');
INSERT INTO public.vol VALUES (8, true, 'Bruxelles', 'Barcelone');
INSERT INTO public.vol VALUES (9, true, 'Seoul', 'Bruxelles');
INSERT INTO public.vol VALUES (10, true, 'Bruxelles', 'Seoul');
INSERT INTO public.vol VALUES (11, false, 'New-York', 'Paris Roisy');
INSERT INTO public.vol VALUES (12, false, 'Paris Roisy', 'New-York');


--
-- Name: constructeur_idconstructeur_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.constructeur_idconstructeur_seq', 2, true);


--
-- Name: detailsvols_iddetailsvols_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.detailsvols_iddetailsvols_seq', 1, false);


--
-- Name: langues_idlangue_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.langues_idlangue_seq', 1, false);


--
-- Name: messages_idmessage_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.messages_idmessage_seq', 1, false);


--
-- Name: modeleavion_idmodele_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.modeleavion_idmodele_seq', 17, true);


--
-- Name: reservation_idreservation_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.reservation_idreservation_seq', 1, false);


--
-- Name: vol_idvol_seq; Type: SEQUENCE SET; Schema: public; Owner: mesi
--

SELECT pg_catalog.setval('public.vol_idvol_seq', 1, false);


--
-- Name: avion avion_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.avion
    ADD CONSTRAINT avion_pkey PRIMARY KEY (arn);


--
-- Name: constructeur constructeur_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.constructeur
    ADD CONSTRAINT constructeur_pkey PRIMARY KEY (idconstructeur);


--
-- Name: detailsvols detailsvols_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.detailsvols
    ADD CONSTRAINT detailsvols_pkey PRIMARY KEY (iddetailsvols);


--
-- Name: langues langues_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.langues
    ADD CONSTRAINT langues_pkey PRIMARY KEY (idlangue);


--
-- Name: messages messages_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (idmessage);


--
-- Name: modeleavion modeleavion_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion
    ADD CONSTRAINT modeleavion_pkey PRIMARY KEY (idmodele);


--
-- Name: passagers passagers_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.passagers
    ADD CONSTRAINT passagers_pkey PRIMARY KEY (numerocni);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (idreservation);


--
-- Name: modeleavion_avion uk_mssy0udppupaitldglq75hx0v; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion_avion
    ADD CONSTRAINT uk_mssy0udppupaitldglq75hx0v UNIQUE (avion_arn);


--
-- Name: vol vol_pkey; Type: CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.vol
    ADD CONSTRAINT vol_pkey PRIMARY KEY (idvol);


--
-- Name: reservation fk3cufxa464mgg2c654qmwi1og1; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fk3cufxa464mgg2c654qmwi1og1 FOREIGN KEY (idpassager) REFERENCES public.passagers(numerocni);


--
-- Name: messages fk62k4xwt8pshgb178bq13yw1cp; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk62k4xwt8pshgb178bq13yw1cp FOREIGN KEY (idlangue) REFERENCES public.langues(idlangue);


--
-- Name: modeleavion fkaw9qn1et8xn01ugkjds98ows7; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion
    ADD CONSTRAINT fkaw9qn1et8xn01ugkjds98ows7 FOREIGN KEY (idconstructeur) REFERENCES public.constructeur(idconstructeur);


--
-- Name: reservation fkeen5q3l4huwaf6pcb8riqxp3m; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fkeen5q3l4huwaf6pcb8riqxp3m FOREIGN KEY (iddetailsvols) REFERENCES public.detailsvols(iddetailsvols);


--
-- Name: detailsvols fkevsccdp0gkq0vp7go6crn0ltv; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.detailsvols
    ADD CONSTRAINT fkevsccdp0gkq0vp7go6crn0ltv FOREIGN KEY (arn) REFERENCES public.avion(arn);


--
-- Name: modeleavion_avion fkhqgk1goc9hwv3o329delu94qd; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion_avion
    ADD CONSTRAINT fkhqgk1goc9hwv3o329delu94qd FOREIGN KEY (modeleavion_idmodele) REFERENCES public.modeleavion(idmodele);


--
-- Name: detailsvols fkj2yhaw1uhwd7idgo7hmoif5yb; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.detailsvols
    ADD CONSTRAINT fkj2yhaw1uhwd7idgo7hmoif5yb FOREIGN KEY (idvol) REFERENCES public.vol(idvol);


--
-- Name: avion fkq4pldarx14fx4qa99pa49ax8v; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.avion
    ADD CONSTRAINT fkq4pldarx14fx4qa99pa49ax8v FOREIGN KEY (idmodele) REFERENCES public.modeleavion(idmodele);


--
-- Name: modeleavion_avion fkrw63got4rct4dxaiyfkaei1aj; Type: FK CONSTRAINT; Schema: public; Owner: mesi
--

ALTER TABLE ONLY public.modeleavion_avion
    ADD CONSTRAINT fkrw63got4rct4dxaiyfkaei1aj FOREIGN KEY (avion_arn) REFERENCES public.avion(arn);


--
-- Name: DATABASE mesi_avion; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON DATABASE mesi_avion TO mesi;


--
-- PostgreSQL database dump complete
--

