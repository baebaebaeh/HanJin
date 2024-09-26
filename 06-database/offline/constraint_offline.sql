/*
	NOT NULL
	
    UNIQUE
    
    CHECK
    
    PRIMARY KEY(PK) : NOT NULL + UNIQUE
    
    누군가를 참조해서 값을 받겠다
    FOREIGN KEY(FK) :  다른테이블 또는 같은 테이블의 컬럼의 값을 참조
    
    값이 안들어오면 값을 넣어주겠다
    DEFAULT
*/

USE ssafy;

create TABLE tb_null (
	id int not null,
    name varchar(20) default null
--    name varchar(20) 위 아래가 같다
);

# 파라미터 이름을 명시해주자.
insert into tb_null(
	id, name
) values (
	1, 'a'
);
insert into tb_null values(2, 'b');
insert into tb_null (id) values (3);
insert into tb_null (name) values ('d');
-- Error Code: 1364. Field 'id' doesn't have a default value
SELECT * from tb_null;

DROP TABLE tb_unique;

create TABLE tb_unique (
	id int not null,
    name varchar(20) unique
);

insert into tb_unique (id, name) values (1, 'a');
insert into tb_unique (id, name) values (2, 'a');

-- 아래와 같이 null값은 unique에서 같은값으로 취급하지 않는다
insert into tb_unique (id) values (3);
insert into tb_unique (id) values (4);

SELECT * from tb_unique;


create TABLE tb_pk (
	id int primary key,
    name varchar(20)
);

insert into tb_pk (id, name) values (1, 'a');
insert into tb_pk (id, name) values (1, 'b'); -- unique에러 
insert into tb_pk (name) values ('b'); -- null 에러

select * from tb_pk;

create TABLE tb_check (
	id int primary key,
    name varchar(20),
    price int check(price >= 0)
);

insert into tb_check (id, name, price) values (1, 'a', 100);
insert into tb_check (id, name, price) values (1, 'a', -100);
-- Error Code: 3819. Check constraint 'tb_check_chk_1' is violated.
-- tb_check_chk_1 여기서 chk_1은 내부적으로 제약조건에 이름을 만들어줌.


-- forein 연습
create TABLE tb_parent (
	id int primary key
);

-- 반드시 parent에 id가 같은게 있어야 child를 만들 수 있다.
create TABLE tb_child (
	child_id int primary key,
    name varchar(20) not null,
    id int,
    foreign key (id) REFERENCES tb_parent(id) on delete CASCADE
);
drop table tb_child;
-- on delete cascade 는 참조값이 삭제되면 자신도 삭제하겠다는 말


insert into tb_parent (id) values (1);
insert into tb_parent (id) values (2);
select * from tb_parent;

insert into tb_child (child_id, name, id) values (100, 'a', 1); -- ok
insert into tb_child (child_id, name, id) values (100, 'a', 3); -- error
insert into tb_child (child_id, name, id) values (200, 'b', 2); -- error
insert into tb_child (child_id, name, id) values (300, 'c', 2); -- error
select * from tb_child;

UPDATE tb_parent # 수정시 문제 발생
	set id = 3
    where id = 2;

delete
  from tb_parent
 where id = 2;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`ssafy`.`tb_child`, CONSTRAINT `tb_child_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_parent` (`id`))

delete
  from tb_child
 where id = 2;

delete
  from tb_parent
 where id = 2;

-- 아래는 시간정보
select now(), sysdate(), current_timestamp
from dual;

select year(now());

select *
from emp
where year(HIREDATE) = 1980;

















