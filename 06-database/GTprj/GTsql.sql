create schema gt;

drop table tb_review;
drop table tb_video;
drop table tb_user;
SET AUTOCOMMIT = 1;
SELECT *
FROM tb_review;

create table tb_video(
    video_id varchar(300) primary key,
    video_title VARCHAR(300) not null,
    video_part VARCHAR(300) not null,
    video_viewcnt int not null DEFAULT 0,
    video_length int not null,
    video_reviewcnt int not null DEFAULT 0,
    channel_name VARCHAR(300) not null
);
INSERT INTO tb_video (
	video_id,
    video_title,
    video_part,
    channel_name,
    video_length
) VALUES (
            "D3yExRi7EME",
            "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기",
            "상체",
            "Mindful Yoga with Eileen",
            1
);
INSERT INTO tb_video (
	video_id,
    video_title,
    video_part,
    channel_name,
    video_length
) VALUES (
            "https://www.youtube.com/watch?v=utIbM9Iua-k",
            "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기",
            "상체",
            "Mindful Yoga with Eileen",
            1
);
create table tb_user(
    user_email varchar(300) primary key,
    user_password VARCHAR(300) not null,
    user_name VARCHAR(300) not null,
    is_user int not null default 1
);

insert into tb_user values ('123', '123', '1', '1');

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

create table tb_video_mark (
	user_email varchar(300) not null,
    video_id VARCHAR(300) not null,
    FOREIGN KEY (user_email) REFERENCES tb_user(user_email) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES tb_video(video_id) ON DELETE CASCADE
)