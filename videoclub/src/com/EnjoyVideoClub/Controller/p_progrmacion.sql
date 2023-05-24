CREATE TABLE pelicula(
	titulo		varchar(50) primary key,
	director	varchar(50),
	formato		varchar(50),
	fecha		varchar(50),
	duracion	integer,
	actor_p		varchar(50),
	actriz_p	varchar(50)
);

CREATE TABLE videojuego(
	titulo			varchar(50) primary key,
	desarrollador	varchar(50),
	formato			varchar(50),
	fecha			varchar(50),
	plataformas		varchar(50),
	duracion		integer
);