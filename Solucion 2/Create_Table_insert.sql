-- Table: public.provincia

-- DROP TABLE public.provincia;

CREATE TABLE public.provincia
(
  idprovincia serial NOT NULL,
  descripcion character varying(150),
  CONSTRAINT pkprovincia PRIMARY KEY (idprovincia)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.provincia
  OWNER TO postgres;



-- Table: public.producto

-- DROP TABLE public.producto;

CREATE TABLE public.producto
(
  idproducto character varying(150) NOT NULL,
  descripcion character varying(250),
  precio numeric(11,2),
  CONSTRAINT pkproducto PRIMARY KEY (idproducto)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.producto
  OWNER TO postgres;

-- Table: public.cliente

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
  idcliente serial NOT NULL,
  nombre character varying(150),
  idprovincia integer,
  CONSTRAINT pkcliente PRIMARY KEY (idcliente),
  CONSTRAINT idprovincia FOREIGN KEY (idprovincia)
      REFERENCES public.provincia (idprovincia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cliente
  OWNER TO postgres;


-- Table: public.compra

-- DROP TABLE public.compra;

CREATE TABLE public.compra
(
  idcompra serial NOT NULL,
  idcliente integer,
  idproducto character varying(250),
  fecha date,
  CONSTRAINT pkcompra PRIMARY KEY (idcompra),
  CONSTRAINT compra_idcliente_fkey FOREIGN KEY (idcliente)
      REFERENCES public.cliente (idcliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkproducto FOREIGN KEY (idproducto)
      REFERENCES public.producto (idproducto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.compra
  OWNER TO postgres;


INSERT INTO public.provincia(idprovincia,descripcion) VALUES
(1,'Zaragoza'),(2,'Huesca'),(3,'Teruel');


INSERT INTO public.producto(idproducto, descripcion, precio) VALUES 
('A', 'Playmobil', 5),('B', 'Puzzle', 10.25),('C', 'Peonza', 3.65);

INSERT INTO public.cliente(nombre, idprovincia) VALUES 
('Juan Palomo', 1),('Armando Ruido', 2),('Carmelo Cotón', 1),('Dolores Fuertes', 3),
('Alberto Mate', 3);


INSERT INTO public.compra(idcompra, idcliente, idproducto, fecha) VALUES
(1, 1, 'C', '01/01/2022'),(2, 2, 'B', '15/01/2022'), (3, 2, 'C', '22/01/2022'),(4, 4, 'A', '03/02/2022'),(5, 3, 'A', '05/02/2022'),(6, 1, 'B', '16/02/2022'),(7, 1, 'B', '21/02/2022'),(8, 4, 'A', '21/02/2022'),(9, 5, 'C', '01/03/2022'),(10, 3, 'A', '01/03/2022'),(11, 3, 'C', '05/03/2022'),(12, 2, 'B', '07/03/2022'),(13, 2, 'B', '11/03/2022'),(14, 1, 'A', '18/03/2022'),(15, 1, 'C', '29/03/2022'),(16, 5, 'B', '08/04/2022'),(17, 5, 'C', '09/04/2022'),(18, 4, 'C', '09/04/2022'),(19, 1, 'A', '12/04/2022'),(20, 2, 'A', '19/04/2022');

