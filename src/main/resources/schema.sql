CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE  IF NOT EXISTS fabricante 
(
	id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	nome varchar(255) NOT NULL
);