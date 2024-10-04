drop table tb_review;
drop table tb_video;
drop table tb_user;


SET AUTOCOMMIT = 1;


create table tb_video(
    video_id varchar(300) primary key,
    video_title VARCHAR(300) not null,
    video_part VARCHAR(300) not null,
    video_viewcnt int not null DEFAULT 0,
    video_length VARCHAR(300) not null,
    video_reviewcnt int not null DEFAULT 0,
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
    review_user_name VARCHAR(300) NOT NULL,
    review_score VARCHAR(300) NOT NULL,
    review_time timestamp DEFAULT CURRENT_TIMESTAMP,
    review_email VARCHAR(300) NOT NULL,
    Foreign KEY (review_id) REFERENCES tb_video(video_id) on delete cascade,
    Foreign KEY (review_email) REFERENCES tb_user(user_email) on update cascade
);


insert into tb_user values ('123', '123', '1', '1');

INSERT INTO tb_video (
	video_id,
    video_title,
    video_part,
    channel_name,
    video_length
) VALUES
    ("D3yExRi7EME", "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기", "상체", "Mindful Yoga with Eileen", "27:00"),
    ("50WCSpZtdmA", "Shim EuDdeum 10 Minute Morning Stretch Everydayㅣ2023 Renewal", "전신", "힘으뜸", "10:24"),
    ("Kk7TQGqQ3nA","하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 Ep.08 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과 (Whole body stretch)","전신","빵느","22:18"),
    ("02K-k6daPb4","15 MIN Fat Burning Cardio - 서서하는 유산소 - 다이어트 운동","전신","빅씨스 Bigsis","16:05"),
    ("tzN6ypk6Sps","하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]","하체","김강민","20:15"),
    ("7TLk7pscICk","(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)","복부","SomiFit","6:05");
    

select *
from tb_review;
select *
from tb_video;