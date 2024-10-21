DROP database IF EXISTS dbpractice;
CREATE DATABASE dbpractice DEFAULT CHARACTER SET utf8mb4;
use dbpractice;
drop table if exists board_file;
drop table if exists board;


create TABLE board (
    no INT PRIMARY KEY AUTO_INCREMENT,  
    title VARCHAR(100) not null,
    content VARCHAR(100) not null,
    writer VARCHAR(100) not null,
    reg_date timestamp not null default now()
);

create table borad_file (
	no int primary key auto_increment,
    path varchar(100) not null,
    ori_name varchar(100) not null,
    system_name varchar(100) not null,
    board_no int,
    foreign key(board_no) references board(no)
);

