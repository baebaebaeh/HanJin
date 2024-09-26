
CREATE TABLE IF NOT EXISTS `person` (
	`id` int PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(10) NOT NULL,
    `birth_year` int NOT NULL,
    `gender` varchar(1) NOT NULL,
    `job` varchar(20) DEFAULT '무직',
    `blood_type` varchar(2) NOT NULL,
    `MBTI` varchar(4)
)ENGINE=InnoDB;

commit;

INSERT INTO `person` (`name`, `birth_year`, `gender`, `job`, `blood_type`, `MBTI`)
VALUES 
('표*희', 1961, '남', '무직', 'O', 'ISTP'),
('김*주', 1963, '남', '경비원', 'A', 'ENFP'),
('탁*진', 1977, '남', '무직', 'A', 'ESTP'),
('안*현', 1989, '여', '프로그래머', 'B', 'ESTJ'),
('이*훈', 1973, '남', '프로그래머', 'B', 'ENFJ'),
('노*주', 1999, '여', '프로그래머', 'B', 'ISTJ'),
('추*수', 2001, '남', '운동선수', 'AB', 'INFP'),
('풍*연', 2003, '여', '대학생', 'A', 'ISFJ'),
('송*진', 2000, '남', '대학생', 'A', 'ESFP'),
('임*진', 2012, '여', '학생', 'O', 'ENTJ'),
('양*선', 2019, '남', '유치원생', 'O', 'ENFJ'),
('황*호', 1992, '남', '회사원', 'O', 'ISFP'),
('하*영', 1981, '여', '회사원', 'O', 'ISFJ'),
('전*준', 1979, '남', '회사원', 'B', 'ESFJ'),
('황*윤', 1965, '남', '회사원', 'B', 'ESTP'),
('안*빈', 1997, '남', '가수', 'B', 'ESTJ'),
('표*곤', 1983, '남', '강사', 'B', 'INFJ'),
('설*호', 1981, '남', '운동선수', 'A', 'INFP'),
('서*영', 1972, '여', '무직', 'O', 'ENTJ'),
('정*현', 2000, '남', '학생', 'O', 'ISTP');
commit;
# MySQL은 많은 내장함수를 제공하고 있습니다.

# MySQL 숫자 함수
# ㄴABS(): 숫자의 절댓값을 반환
# ㄴROUND(): 숫자를 반올림
# ㄴCEILING(): 숫자를 올림
# ㄴFLOOR(): 숫자를 내림
# ㄴMOD(): 나눗셈의 나머지를 계산
# ㄴSQRT(): 숫자의 제곱근을 계산
# ㄴPOWER(): 숫자의 지수승을 계산

# MySQL 문자열 함수
# ㄴCONCAT(): 문자열을 연결
# ㄴSUBSTRING(): 문자열의 일부분을 추출
# ㄴUPPER(): 문자열을 모두 대문자로 변환
# ㄴLOWER(): 문자열을 모두 소문자로 변환
# ㄴLENGTH(): 문자열의 길이를 반환
# ㄴTRIM(): 문자열의 앞뒤 공백
# ㄴREPLACE(): 문자열에서 특정 문자열을 다른 문자열로 대체
# ㄴREPEAT(): 주어진 문자열을 지정된 횟수만큼 반복하여 반환
# ㄴREVERSE(): 문자열을 거꾸로 뒤집어서 반환

# MySQL 날짜 함수
# ㄴNOW(): 현재 날짜와 시간을 반환
# ㄴDATE(): 날짜 값에서 날짜 부분만 추출
# ㄴTIME(): 날짜 값에서 시간 부분만 추출
# ㄴYEAR(): 날짜 값에서 연도를 추출
# ㄴMONTH(): 날짜 값에서 월을 추출
# ㄴDAY(): 날짜 값에서 일을 추출
# ㄴDATE_FORMAT(): 날짜 값을 지정된 형식으로 포맷팅

# 설명한 것 이외에도 다양한 함수가 있으므로 찾아보면서 공부해보자.
SELECT * FROM person;

# Q. 절댓값 함수에 -10을 넣어 출력해 봅시다.
SELECT abs(-10) AS '결과';

# Q. 2의 2승, 3승, 4승을 차례대로 한번에 출력해 봅시다.
SELECT POWER(2, 2) AS '2^2', POWER(2, 3) AS '2^3', POWER(2, 4) AS '2^4';

# Q. 나의 BMI를 계산하여 소수점 첫번째 자리까지 출력해 봅시다.
# hint. BMI 공식 몸무게(KG) / 키(M) * 키(M)
SELECT truncate(94 / POWER(1.92, 2), 1) AS 'BMI';

# Q. person 테이블에서 MBTI를 중복제거 후 소문자로 변환하여 5개의 데이터만 출력해 봅시다.
SELECT DISTINCT lower(MBTI) 'mbti'
FROM person
LIMIT 5;

# Q. person 테이블에서 birty_year를 ‘OO 년생’으로 변환하여 5개의 데이터만 출력해 봅시다.
SELECT concat(mod(birth_year, 100), '년생') AS '생년'
FROM person
LIMIT 5;

# Q. 현재의 날짜를 출력해 봅시다.
SELECT date(now()) AS '현재날짜';

# Q. 현재의 날짜를 OOOO년 O월 O일로 변환해 출력해 봅시다.
SELECT date_format(date_format(date_format(birth_year)), '%Y년 %m월 %d일') AS '날짜';

# Q. 현재 날짜로부터 100일이 지난 날짜를 출력해 봅시다.
SELECT ____(____(____()), ____) AS '100일 뒤';
