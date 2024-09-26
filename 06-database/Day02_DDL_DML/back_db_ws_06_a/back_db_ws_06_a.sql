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
# SELECT 구조
# SELECT [DISTINCT] { * | column_name| expresions [alias] }
# FROM table_references
# [WHERE where_condition]
# [GROUP BY {col_name | expr | position},] 
# [HAVING where_condition]
# [ORDER BY {col_name | expr | position} [ASC | DESC]] 
# [LIMIT {[offset,] row_count | row_count OFFSET offset}]

# 집계함수(aggregate function)는 여러 행의 값을 하나의 결과 집계하는데 사용된다.
# COUNT() : 특정 열의 데이터의 개수를 세는 데 사용
# SUM() : 숫자 열의 값을 모두 더하는 데 사용
# AVG() : 숫자 열의 평균을 계산하는 데 사용
# MAX() : 숫자 또는 문자열에서 최댓값을 찾는 데 사용
# MIN() : 숫자 또는 문자열에서 최솟값을 찾는 데 사용

# GROUP BY : 특정 열(컬럼명, 위치 등)을 값에 따라 그룹화 할때 사용이 가능.
# HAVING : WHERE 절과 유사하지만 그룹을 필터링 할 때 사용
# ORDER BY : 결과를 특정 열의 값에 따라 정렬하는 데 사용. 기본은 오름차순(ASC), 내림차순(DESC)도 사용 가능
# LIMIT : 쿼리 결과에서 반환되는 행의 수를 제한하는 데 사용

SELECT *
FROM PERSON;

# Q. person 테이블의 전체 데이터 개수를 조회해 봅시다.
SELECT count(id) AS '데이터 수'
FROM person;

# Q. person 테이블에서 birth_year의 최고령과 최연소를 조회해 봅시다.
SELECT max(year(now()) - birth_year + 1) AS '최고령', min(year(now()) - birth_year + 1) AS '최연소'
FROM person;

# Q. person 테이블에서 2024년 기준 평균 나이를 계산해 봅시다.
SELECT avg(2024-birth_year+1) AS '평균나이'
FROM person;

# Q. person 테이블에서 각 직업 별 인원을 조회해 봅시다.
SELECT job, count(job) AS '사람 수' 
FROM person
GROUP BY job;

# Q. person 테이블에서 평균 나이가 40 이상인 직업과 평균 나이를 정수로 계산하여 조회해 봅시다
# hint. CAST, CONVERT 메서드를 사용하면 변환이 가능합니다.
SELECT job, cast(avg(2024-birth_year+1) as UNSIGNED) AS '평균나이'
FROM person
group by job
having avg(2024-birth_year+1) >= 40;

# Q. person 테이블에서 성별이 ‘여’인 경우 이름 순으로 정렬하여 조회해 봅시다.
SELECT * FROM person
WHERE gender = '여'
order by name;

# Q. person 테이블에서 MBTI가 ‘E’인 사람들을 내림차순 정렬하고, 같다면 blood_type 순으로 조회해 봅시다.
SELECT *
FROM person
WHERE MBTI LIKE 'E%'
ORDER BY birth_year DESC, blood_type;

# Q. person 테이블에서 가장 빨리 태어난 5명을 조회해 봅시다.
SELECT *
FROM person
ORDER BY birth_year
limit 5;
