create database examdb;

use examdb;

#
--
/*
	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
*/
-- 적어도 한개의 컬럼이 존재해야 table을 만들 수 있다.
-- 한글은 3바이트 300 이면 10자까지 쓸 수 있다.
create table board (
    no int auto_increment,
    title VARCHAR(300) not null,
    writer VARCHAR(30) not null,
    content VARCHAR(1000) not null,
	view_Cnt int default 0,
    reg_date TIMESTAMP default CURRENT_TIMESTAMP,
    primary key(no) #no컬럼을 primary key로 주겠다. 겹치지 않게
    
);

#직접입력 받는것만 넣어놓는다.
insert into board(title, content, writer)
values ('연습', 'ssaft', '연습2입니다');

commit;

select * from board;



