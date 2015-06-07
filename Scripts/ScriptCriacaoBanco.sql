CREATE TABLE Usuario (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IdTipoUsuario int,
Nome varchar(255),
CpfCnpj bigint,
Email varchar(255)
);

CREATE TABLE TipoUsuario (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
Tipo varchar(255)
);

CREATE TABLE Leilao (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IdUsuario int,
IdLote int,
IdNatureza int,
IdFormaLance int,
DataInicio timestamp,
DataTermino timestamp,
FOREIGN KEY(IdUsuario) REFERENCES Usuario (Id)
);

CREATE TABLE Natureza (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
Nome varchar(255)
);

CREATE TABLE FormaLance (
Id int PRIMARY KEY,
Forma varchar(255)
);

CREATE TABLE Lote (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IdBem int,
Preco decimal(10,2)
);

CREATE TABLE Bem (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IdCategoriaBem int,
Descricao varchar(255),
DescricaoCompleta long varchar
);

CREATE TABLE CategoriaBem (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
Categoria varchar(255)
);

CREATE TABLE Lance (
Id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
IdUsuario int,
IdLote int,
DataHora timestamp,
Valor decimal(10,2),
FOREIGN KEY(IdUsuario) REFERENCES Usuario (Id),
FOREIGN KEY(IdLote) REFERENCES Lote (Id)
);

ALTER TABLE Usuario ADD FOREIGN KEY(IdTipoUsuario) REFERENCES TipoUsuario (Id);
ALTER TABLE Leilao ADD FOREIGN KEY(IdLote) REFERENCES Lote (Id);
ALTER TABLE Leilao ADD FOREIGN KEY(IdNatureza) REFERENCES Natureza (Id);
ALTER TABLE Leilao ADD FOREIGN KEY(IdFormaLance) REFERENCES FormaLance (Id);
ALTER TABLE Lote ADD FOREIGN KEY(IdBem) REFERENCES Bem (Id);
ALTER TABLE Bem ADD FOREIGN KEY(IdCategoriaBem) REFERENCES CategoriaBem (Id);



--INSERTS
insert into tipousuario VALUES (default, 'COMPRADOR')
insert into tipousuario VALUES (default, 'VENDEDOR')