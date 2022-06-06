/*
loja de games
@author guifrans
*/

show databases;

create database lojagames;
use lojagames;

-- tabela produtos
create table produtos(
codigo int primary key auto_increment,
barcode varchar(255),
produtos varchar(255)not null,
descricao varchar(255)not null,
fabricante varchar(255)not null,
datacad timestamp default current_timestamp,
dataval date not null,
estoque int not null,
estoquemin int not null,
unidade varchar(255) not null,
localizacao varchar(255),
custo decimal(10,2),
lucro decimal(10,2),
venda decimal(10,2),
idfor int not null,
foreign key (idfor) references fornecedores(idfor)
);
-- tabela usuarios
create table usuarios(
idus int primary key auto_increment,
usuario varchar(255)not null,
login varchar (255) not null unique,/* valor unico*/
senha varchar (255) not null,
perfil varchar (255) not null
);
-- tabela fornecedores
 create table fornecedores(
idfor int primary key auto_increment,
cnpj varchar(255)not null unique,
ie varchar(255)unique,
im varchar(255)unique,
razao varchar(255) not null , 
fantasia varchar(255)not null,
site varchar(255),
fone varchar(255) not null,
contato varchar(255),
email varchar(255),   
cep varchar(255) not null,
endereco varchar(255) not null,
numero varchar(255)not null,
complemento varchar(255), 
bairro varchar(255)not null,
cidade varchar(255) not null,
uf char(2)not null,
obs varchar(255)
 );
-- tabela clientes
 create table clientes(
 idcli int primary key auto_increment,
 nome varchar(255) not null,
 fone varchar(255) not null,
 cpf varchar(255) unique,
 email varchar(255),
 marketing varchar(255) not null,
 cep varchar(255),
 endereco varchar(255),
 numero varchar(255),
 complemento varchar(255),
 bairro varchar(255),
 cidade varchar(255),
 uf char(2)
 );
-- tabela pedidos
create table pedidos(
pedido int primary key auto_increment,
dataped timestamp default current_timestamp,
total decimal(10,2),
idcli int not null,
foreign key(idcli) references clientes(idcli)
);
-- tabela carrinho 
 create table carrinho(
 pedido int not null,
 codigo int not null,
 quantidade int not null,
 foreign key (pedido) references pedidos(pedido),
  foreign key (codigo) references produtos(codigo)
 );