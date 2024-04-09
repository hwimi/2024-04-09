--유저 생성 구문
create user 'javaUser'@'localhost'indentified by'mysql';

--db생성
create database javadb;

--유저권한 부여
grant all privileges on javadb.*to 'javaUser'@'localhost' with grant option;
flush privileges;


create table board(
bno int not null auto_increment,
title varchar(50) not null,
writer varchar(30) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
primary key(bno));