use examdb;
drop table board_file;
create table board_file (
	file_no int auto_increment,
    file_path varchar(300) not null,
    ori_name varchar(100) not null,
    system_name varchar(100) not null,
    no int,
    
    
    foreign key(no) references board(no),
    primary key(file_no)
);
insert into board(title, writer, content)
values('aaa', 'bbb', 'ccc');

select last_insert_id() from dual;

select * from board_file;
select * from board;

desc board_file;
desc board;