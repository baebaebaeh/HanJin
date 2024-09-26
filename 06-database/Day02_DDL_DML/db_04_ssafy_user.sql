# Q1. ssafydb 데이터 베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;
# Q2. ssafy_user 테이블 생성
CREATE TABLE ssafy_user (
# PRIMARY KEY는 not null의 특징을 가지고 있다.
# auto increment는 마지막 숫자를 기준으로 자동으로 증가된 num을 넣어준다.
    user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_email VARCHAR(30),
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
DESC ssafy_user;

# Q3. INSERT 쿼리를 사용해보자.
-- 모든 컬럼 입력을 하겠다.
INSERT INTO ssafy_user
VALUES (5, '행복', '배한진', '1234', 'godqhr@ssafy.com', now());
-- 원하는 컬럼만 작성(데이터타입에 맞춰서 작성)
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("kimssafy","김싸피","1q2w3e4r");
-- 여러행을 동시에 입력
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("kimssafy1","김싸피","1q2w3e4r"),
("kimssafy2","김싸피","1q2w3e4r"),
("kimssafy3","김싸피","1q2w3e4r"),
("kimssafy4","김싸피","1q2w3e4r");

# Q4. 데이터를 수정해보자
UPDATE ssafy_user
SET user_name = 'anonymous';

UPDATE ssafy_user
set user_password = 'ssafy'
WHERE user_num = 3;
/*
0	30	10:17:45	UPDATE ssafy_user
 SET user_name = 'anonymous'	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
 To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec
*/
# Q5. 데이터를 삭제해보자
DELETE FROM ssafy_user
WHERE user_num = 4;


SELECT *
FROM ssafy_user;
