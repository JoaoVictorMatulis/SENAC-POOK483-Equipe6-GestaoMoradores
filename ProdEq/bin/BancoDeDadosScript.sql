create database mydba;
use mydba;
create table pessoa (
   id_pessoa int primary key auto_increment,
   nome_pessoa varchar(40) not null,
   senha varchar(40) not null,
   ap int not null,
   bloco int not null,
   cpf varchar(40) not null,
   fone varchar(20),
   email varchar(50) not null
);

create table registros(
    id_registro int primary key auto_increment,
    fk_id_pessoa int not null,
    entrada datetime default now(),
    saida datetime default now(),
    foreign key (fk_id_pessoa) references pessoa (id_pessoa)
);
select * from pessoa;
select * from registros
/*insert into pessoa (nome_pessoa, senha, ap, bloco, cpf, fone, email) values ('bonas',"senha",203,2,108329123,3123123,"teste@gmail.com");
select * from pessoa;
delete from pessoa where id_pessoa = 2;
insert into registros(fk_id_pessoa, saida) value(1,null);
update registros set saida = now() where id_registro = 1 and saida = null;
update pessoa set nome_pessoa = 'teste', senha = 'senha', ap = '1', bloco = '1', cpf = '1', fone = '1', email = 'email' where id_pessoa = 3; 
select * from registros;
select * from registros where fk_id_pessoa = 1 and saida is null;
update registros set saida = now() where id_registro = 8;
select * from registros;
DELETE FROM registros WHERE fk_id_pessoa = "2";
insert into registros(fk_id_pessoa, saida) value(12,null);*/