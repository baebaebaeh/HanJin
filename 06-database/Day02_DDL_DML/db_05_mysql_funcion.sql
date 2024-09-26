# Q1. 숫자관련 함수 사용
-- 2의 3제곱
-- from은 안써도 작동하지만 써주는것이 문법에 맞다.
SELECT pow(2, 3) AS '2**3'
FROM dual;

-- 8 나누기 3의 나머지
SELECT mod(8, 3) AS '8%3'
FROM dual;

-- 최대값, 최솟값
SELECT greatest(12,123,1234, 12, 4, 6, 7 ,4), least(12, 3, 4, 65, 7);

-- 반올림
SELECT round(3.141592), round(3.141592, 3), round(3.141592, 2), round(3.141592, 1);

# Q2. 문자 관련 함수
-- 아스키 코드값 얻기
SELECT ascii('0'), ascii('a'), ascii('A');

-- concat 메서드를 써보자.
SELECT concat('3번유저의이름은', user_name, '입니다')
FROM ssafy_user
WHERE user_num = 3;

-- 이름의 길이가 6인 직원의 이름을 조회
SELECT *
FROM ssafy_user
WHERE length(user_id) = 6;

-- 김싸피
SELECT length('김싸피'), char_length('김싸피');
SELECT length('📌'), char_length('📌');

-- 문자열 변경
SELECT replace('Hello abc abc !!', 'abc', 'ssafy');

-- 문자열 인덱스 db는 1부터 시작
SELECT instr('Hello SSAFY', 'SSAFY');

-- 모든 직원의 이름 3자리조회
SELECT substr(user_name, 1, 3)
FROM ssafy_user;

-- LPAD RPAD
SELECT lpad('ssafy', 10, '*');

-- REVERSE
SELECT reverse('Hello SSAFY');
SELECT reverse('수박이박수');
SELECT reverse('우영우역삼역기러기스위스토마토');

# Q3. 날짜 관련함수

-- 2초 더하기
SELECT addtime('2024-09-26 10:47:50', '10');
-- 날짜차이
SELECT datediff('2024-12-31', '2024-09-26');

-- 오늘은?
SELECT now();
SELECT yearweek(now());

# Q4. 트랜잭션 사용해보기
-- 오토커밋 해제
SET autocommit = 0;
create database ssafy;
USE ssafy;
CREATE TABLE test_table(
	val VARCHAR(2)
);
START TRANSACTION;
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('F');
INSERT INTO test_table VALUES ('Y');

COMMIT;

ROLLBACK;

SELECT * FROM test_table;  