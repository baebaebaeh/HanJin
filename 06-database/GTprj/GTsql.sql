create schema gt;

drop table tb_review;
drop table tb_video;
drop table tb_user;

create table tb_video(
    video_id varchar(300) primary key,
    video_title VARCHAR(300) not null,
    video_part VARCHAR(300) not null,
    channel_name VARCHAR(300) not null
);

create table tb_user(
    user_email varchar(300) primary key,
    user_password VARCHAR(300) not null,
    user_name VARCHAR(300) not null,
    is_user int not null default 1
);

create table tb_review (
    review_no int PRIMARY KEY AUTO_INCREMENT,
    review_id VARCHAR(300) NOT NULL,
    review_title VARCHAR(300) NOT NULL,
    review_content VARCHAR(300) NOT NULL,
    review_score int NOT NULL,
    review_time timestamp,
    review_cnt int,
    review_email VARCHAR(300) NOT NULL,
    Foreign KEY (review_id) REFERENCES tb_video(video_id) on delete cascade,
    Foreign KEY (review_email) REFERENCES tb_user(user_email) on update cascade
);