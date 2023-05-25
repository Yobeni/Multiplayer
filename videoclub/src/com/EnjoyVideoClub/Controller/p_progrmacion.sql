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

CREATE TABLE socio(
	 NIF			varchar(50) primary key;
     	 nombre			varchar(50);
    	 apellidos		varchar(50);
         fechaNac		varchar(50);
    	 poblacion		varchar(50);
    	 dineroDeuda		integer;
)

CREATE TABLE alquileres (
	fecha_inicio		varchar(50),
	fecha_fin			varchar(50),
	nif_socio			varchar(50),
	tipo_mult			varchar(50),
	precio				varchar(10),
	titulo_mult			varchar(50),

	primary key (nif_socio, titulo_mult),
	foreign key (nif_socio) references socios(nif)
);
