--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7
-- Dumped by pg_dump version 12.7

-- Started on 2021-07-22 20:48:42

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

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16494)
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo (
    id integer NOT NULL,
    nombre character varying,
    capitan integer NOT NULL,
    fecha_alta date
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16492)
-- Name: equipo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_id_seq OWNER TO postgres;

--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 204
-- Name: equipo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_seq OWNED BY public.equipo.id;


--
-- TOC entry 206 (class 1259 OID 16508)
-- Name: equipo_jugador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo_jugador (
    id_equipo integer NOT NULL,
    id_jugador integer NOT NULL
);


ALTER TABLE public.equipo_jugador OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16486)
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jugador (
    id integer NOT NULL,
    apellido character varying(20) NOT NULL,
    nombre character varying(20) NOT NULL,
    documento character varying(8) NOT NULL,
    edad integer,
    posicion integer
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16484)
-- Name: jugador_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jugador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jugador_id_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 202
-- Name: jugador_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jugador_id_seq OWNED BY public.jugador.id;


--
-- TOC entry 208 (class 1259 OID 16523)
-- Name: posicion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posicion (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.posicion OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16521)
-- Name: posicion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.posicion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.posicion_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 207
-- Name: posicion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.posicion_id_seq OWNED BY public.posicion.id;


--
-- TOC entry 2706 (class 2604 OID 16497)
-- Name: equipo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo ALTER COLUMN id SET DEFAULT nextval('public.equipo_id_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 16489)
-- Name: jugador id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador ALTER COLUMN id SET DEFAULT nextval('public.jugador_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 16526)
-- Name: posicion id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posicion ALTER COLUMN id SET DEFAULT nextval('public.posicion_id_seq'::regclass);


--
-- TOC entry 2847 (class 0 OID 16494)
-- Dependencies: 205
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.equipo VALUES (2, 'C.A. Cachos', 7, '2021-07-07');


--
-- TOC entry 2848 (class 0 OID 16508)
-- Dependencies: 206
-- Data for Name: equipo_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2845 (class 0 OID 16486)
-- Dependencies: 203
-- Data for Name: jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.jugador VALUES (1, 'Perez', 'Juan', '12619350', 28, 1);
INSERT INTO public.jugador VALUES (2, 'Paredes', 'Armando', '23845114', 30, 4);
INSERT INTO public.jugador VALUES (7, 'Fuente', 'Carlos', '26887445', 32, 3);


--
-- TOC entry 2850 (class 0 OID 16523)
-- Dependencies: 208
-- Data for Name: posicion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.posicion VALUES (1, 'Arquero');
INSERT INTO public.posicion VALUES (2, 'Defensor');
INSERT INTO public.posicion VALUES (3, 'Mediocampista');
INSERT INTO public.posicion VALUES (4, 'Delantero');


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 204
-- Name: equipo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipo_id_seq', 2, true);


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 202
-- Name: jugador_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jugador_id_seq', 7, true);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 207
-- Name: posicion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.posicion_id_seq', 1, false);


--
-- TOC entry 2711 (class 2606 OID 16502)
-- Name: equipo pk_id_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT pk_id_equipo PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 16491)
-- Name: jugador pk_id_jugador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT pk_id_jugador PRIMARY KEY (id);


--
-- TOC entry 2713 (class 2606 OID 16531)
-- Name: posicion posicion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posicion
    ADD CONSTRAINT posicion_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 16511)
-- Name: equipo_jugador fk_id_equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo_jugador
    ADD CONSTRAINT fk_id_equipo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id);


--
-- TOC entry 2715 (class 2606 OID 16503)
-- Name: equipo fk_id_jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fk_id_jugador FOREIGN KEY (capitan) REFERENCES public.jugador(id);


--
-- TOC entry 2717 (class 2606 OID 16516)
-- Name: equipo_jugador fk_id_jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo_jugador
    ADD CONSTRAINT fk_id_jugador FOREIGN KEY (id_jugador) REFERENCES public.jugador(id);


--
-- TOC entry 2714 (class 2606 OID 16532)
-- Name: jugador fk_posicion_jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT fk_posicion_jugador FOREIGN KEY (posicion) REFERENCES public.posicion(id) NOT VALID;


-- Completed on 2021-07-22 20:48:42

--
-- PostgreSQL database dump complete
--

