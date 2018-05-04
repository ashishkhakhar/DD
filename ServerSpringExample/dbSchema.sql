drop database if exists servers;
create database if not exists servers;
use servers;
drop table if exists server;
create table SERVER  (ID CHAR(128) NOT NULL, NAME varchar(255) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
