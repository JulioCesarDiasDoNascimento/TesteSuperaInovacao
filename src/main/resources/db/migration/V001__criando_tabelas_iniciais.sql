create table departamento (
    id serial primary key,
    nome varchar(255) not null
);

create table modulo (
    id serial primary key,
    nome varchar(255) not null
);

create table usuario (
    id serial primary key,
    nome varchar(255) not null,
    email varchar(255) not null unique,
    senha varchar(255) not null,
    departamento_fk integer references departamento (id),
    validade_modulo date
);

create table permissao (
    departamento_fk integer not null references departamento (id),
    modulo_fk integer not null references modulo (id),
    primary key (departamento_fk, modulo_fk)
);

create table usuario_modulos (
    usuario_fk integer not null references usuario (id),
    modulo_fk integer not null references modulo (id),
    primary key (usuario_fk, modulo_fk)
);

create table solicitacao (
    id serial primary key,
    usuario_fk integer not null references usuario (id),
    modulo_fk integer not null references modulo (id),
    dataHora_solicitado timestamp not null,
    status varchar(255) not null
);