--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: sectors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sectors (
    id integer NOT NULL,
    label character varying(64) NOT NULL,
    parent integer
);


ALTER TABLE public.sectors OWNER TO postgres;

--
-- Name: sectors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sectors_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sectors_id_seq OWNER TO postgres;

--
-- Name: sectors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sectors_id_seq OWNED BY public.sectors.id;


--
-- Name: user_to_sector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_to_sector (
    user_id integer,
    sector_id integer
);


ALTER TABLE public.user_to_sector OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    session_id character varying(32) NOT NULL,
    name character varying(64) NOT NULL,
    is_agreed boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: sectors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sectors ALTER COLUMN id SET DEFAULT nextval('public.sectors_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: sectors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sectors (id, label, parent) FROM stdin;
13	Manufacturing	0
14	Construction materials	13
15	Electronics and Optics	13
16	Food and Beverage	13
17	Bakery & confectionery products	16
18	Fish & fish products	16
19	Meat & meat products	16
20	Milk & dairy products	16
21	Other	16
22	Sweets & snack food	16
23	Furniture	13
24	Furniture	23
25	Bathroom/sauna	23
26	Bedroom	23
27	Children’s room	23
28	Kitchen	23
29	Living room	23
30	Office	23
31	Other (Furniture)	23
32	Outdoor	23
33	Project furniture	23
34	Machinery	13
35	Machinery components	34
36	Machinery equipment/tools	34
37	Manufacture of machinery	34
38	Maritime	34
39	Aluminium and steel workboats	38
40	Boat/Yacht building	38
41	Ship repair and conversion	38
42	Metal structures	34
43	Other	34
44	Repair and maintenance service	34
45	Metalworking	13
46	Construction of metal structures	45
47	Houses and buildings	45
48	Metal products	45
49	Metal works	45
50	CNC-machining	49
51	Forgings, Fasteners	49
52	Gas, Plasma, Laser cutting	49
53	MIG, TIG, Aluminum welding	49
54	Plastic and Rubber	13
55	Packaging	54
56	Plastic goods	54
57	Plastic processing technology	54
58	Blowing	57
59	Moulding	57
60	Plastics welding and processing	57
61	Plastic profiles	54
62	Printing	13
63	Advertising	62
64	Book/Periodicals printing	62
65	Labelling and packaging printing	62
66	Textile and Clothing	13
67	Clothing	66
68	Textile	66
69	Wood	13
70	Other (Wood)	69
71	Wooden building materials	69
72	Wooden houses	69
73	Other	0
74	Creative industries	73
75	Energy technology	73
76	Environment	73
77	Service	0
78	Business services	77
79	Engineering	77
80	Information Technology and Telecommunications	77
81	Data processing, Web portals, E-marketing	80
82	Programming, Consultancy	80
83	Software, Hardware	80
84	Telecommunications	80
85	Tourism	77
86	Translation services	77
87	Transport and Logistics	77
88	Air	87
89	Rail	87
90	Road	87
91	Water	87
\.


--
-- Data for Name: user_to_sector; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_to_sector (user_id, sector_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, session_id, name, is_agreed) FROM stdin;
\.


--
-- Name: sectors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sectors_id_seq', 91, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 21, true);


--
-- Name: sectors sectors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sectors
    ADD CONSTRAINT sectors_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_session_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_session_id_key UNIQUE (session_id);


--
-- Name: user_to_sector user_to_sector_sector_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_to_sector
    ADD CONSTRAINT user_to_sector_sector_id_fkey FOREIGN KEY (sector_id) REFERENCES public.sectors(id);


--
-- Name: user_to_sector user_to_sector_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_to_sector
    ADD CONSTRAINT user_to_sector_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

