USE `ssafy_corporation`;
select *
from emp;
select *
from dept;
-- 카타시안 곱--------------------------
SELECT empno, ename, job
FROM emp;

SELECT deptno, dname
FROM dept;

-- emp, dept 둘다 deptno를 가지고 있어서 아래처럼 쓰면 작동하지 않는다.
SELECT empno, ename, job, deptno, dname
FROM emp, dept;
-- 그래서 아래처럼 작성하면 작동한다.
SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept;
-- 하지만 위는 우리가 원하는 답이 아니다.
SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 7788번인 사원의 정보를 가지고 와보자 (부서 이름까지)--------------------------
SELECT ename, job, deptno
FROM emp
WHERE empno = 7788;
-- 위와 아래를 섞어서 쓰고 싶다.
SELECT dname
FROM dept
WHERE deptno = 20;

SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND empno = 7788;
-- 근데 1개를 가져오기 위해 두개의 테이블을 불러와야 하네?
-- 비효울적이니까 SubQuery에서 해결하자

-- INNER JOIN 키워드 사용--------------------------
SELECT empno, ename, job, emp.deptno, dname
FROM emp
INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE empno = 7788;

SELECT e.empno, ename, job, e.deptno, dname
FROM emp e
INNER JOIN dept
ON e.deptno = dept.deptno
WHERE empno = 7788;

SELECT empno, ename, job, deptno, dname
FROM emp
INNER JOIN dept
USING (deptno)
WHERE empno = 7788;

-- OUTER JOIN--------------------------
INSERT INTO emp
VALUES (7777, "양싸피", "MANAGER", 7839, "2022-09-13", 5000, NULL, NULL);

-- 왼쪽 테이블 기준!
SELECT ename, emp.deptno, dname
FROM emp LEFT OUTER JOIN dept
ON emp.deptno = dept.deptno;

-- 왼쪽 테이블 기준!
SELECT ename, emp.deptno, dname
FROM emp RIGHT OUTER JOIN dept
ON emp.deptno = dept.deptno;

-- 위와 다르게 기준을 바꿔주면 값이 달라진다.
SELECT ename, dept.deptno, dname
FROM emp RIGHT OUTER JOIN dept
ON emp.deptno = dept.deptno;

-- 셀프 조인--------------------------
SELECT e1.empno, e1.ename, e1.mgr, e2.ename AS mgrName
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT e1.empno, e1.ename, e1.mgr, e2.ename AS mgrName
FROM emp e1 INNER JOIN emp e2
on e1.mgr = e2.empno;

-- king이 등장하지않다.......
SELECT e1.empno, e1.ename, e1.mgr, e2.ename AS mgrName
FROM emp e1 LEFT OUTER JOIN emp e2
on e1.mgr = e2.empno;

-- 비 동등 조인(Non-Equi JOIN)
SELECT e.empno, e.ename, e.sal, sg.grade
FROM emp e, salgrade sg
-- WHERE e.sal >= sg.LOSAL AND e.sal <= sg.HISAL -- 아래와 같다.
WHERE e.sal BETWEEN sg.LOSAL AND e.sal <= sg.HISAL
ORDER BY sg.grade DESC, e.sal DESC;
