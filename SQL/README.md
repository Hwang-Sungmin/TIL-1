## DBMS

###### (Data Base Managemnet System)

데이터베이스를 관리하기 위한 컴퓨터 시스템

DBMS 가 없는 데이터 관리 시스템의 단점

1.  다수의 사람이 데이터를 고유하기 어렵다.
2.  대량의 데이터를 다루기 어려운 형태
3.  읽기/쓰기를 자동화하려면 프로그래밍 기술이 필요
4. 만일의 사고에 대비하기 어렵다.

이러한 단점들을 해결하기 위해 나온것이 DBMS 이다.

###### 다양한 종류의 DBMS

데이터의 저장형식에 따라 분류된다.

- 계층형 DB

  가장 오래된 형태, 데이터를  계층 구조(트리)로 표현

- 관계형 DB

  관계 (Relation)DB라고도 불리며 열과 행, 2차원 표 형식으로 관리하기 때문에 이해하기 쉽다.

  `SQL` 이라는 전용 언어를 사용한다.

- 객체지향 DB

  데이터와 데이터 처리를 모아서 `객체` 단위로 관리한다.

- XML DB

  XML 형식을사용하고, 대량으로 빠르게처리 하기 위해 고안됐다.

- 키 - 밸류 형 데이터 스토어

  Key - Value 로 조합해 단순한 형태로 저장하는 DB. 해시(Hash)와 비슷한 구조

  대량의 데이터를 초고속으로 검색하는 서비스 등에 사용

  

## RDBMS

2차원 구조인 `테이블`로 데이터를 저장한다.

레코드( 행, 가로)

칼럼(열 , 세로)

## SQL

###### (Structed Query Language)

관계형 데이터베이스 구성에 사용되는 언어.

###### 종류

- DDL (Data Definition Lang)

  - CREATE - DB 나 테이블 생성한다.

  - DROP - DB 나 테이블 삭제한다.

  - ALTER - DB 나 테이블 등의 구성을 변경 한다.

    

- DML (Data Menipulation L)

  - SELECT -

  - INSERT - 

  - DELETE - 

  - UPDATE - 

    

- DCL (Data Control L)

  - COMMIT - 데이터베이스 변경 내용을 확정한다. - Transaction 에 사용
  - ROLLBACK - 데이터베이스 변경 내용을 취소한다.  - Transaction 에 사용
  - GRANT - 사용자에게 권한을 부여
  - REVOKE - 사용자에게 권한을 제거
  
- 

#### 코드

###### 테이블 생성 및 기본 명령어

```SQL
/*테이블 생성*/
CREATE TABLE T_USER(
    ID VARCHAR2(10), 
    PWD VARCHAR2(10),
    NAME VARCHAR2(20),
    AGE NUMBER(3),
    BALANCE NUMBER(10 , 4)
);
/*
CHAR- 고정 문자열 -- 글자수가 정해져있음
VARCHAR - 가변 문자열 -- 넣은 만큼 글자수를 가짐
NUMBER(10 , 4) -- 소숫점 4자리 까지 표현가능한 실수
*/
DESC T_USER; /*테이블 구성 출력*/
SELECT * FROM T_USER; /*테이블 내용 출력*/
DROP TABLE T_USER; /* 테이블 삭제 (데이터 모두 삭제)*/

CREATE TABLE T_PRODUCT(
   ID VARCHAR2(10) PRIMARY KEY,
NAME VARCHAR2(10) NOT NULL,
PRICE NUMBER(10,1) NOT NULL
);

```

##### ALTER TABLE

```SQL

ALTER TABLE T_PRODUCT ADD (REGDATE DATE); /*컬럼 추가*/

ALTER TABLE T_PRODUCT DROP (REGDATE); /*컬럼 삭제*/

ALTER TABLE T_PRODUCT RENAME COLUMN NAME TO UNAME; /* 컬럼 이름 변경*/

ALTER TABLE T_PRODUCT TO N_PRODUCT;/*테이블 이름 변경*/

ALTER TABLE T_PRODUCT ADD PRIMARY KEY(ID); /*Primary Key 추가*/

/*데이타 타입 변경 modify*/
ALTER TABLE T_PRODUCT MODIFY (NAME CHAR (10)); 
ALTER TABLE T_USER MODIFY (PWD NOT NULL);
ALTER TABLE T_PRODUCT MODIFY PRICE NUMBER  NULL;
ALTER TABLE T_PRODUCT MODIFY (PRICE DEFAULT 1000); /* 기본 값 설정( NOT NULL 인 것에 사용하면 좋음*/

```

##### INSERT

```SQL
/*데이터베이스에 입력 insert*/
INSERT INTO T_USER VALUES( 'ID01' , 'PWD01','이말년');
INSERT INTO T_USER( ID , PWD) VALUES( 'ID01' , 'PWD01');

```

##### DELETE & UPDATE

```SQL
/*데이터 삭제 delete */
DELETE FROM T_PRODUCT WHERE ID = 'ID02';
DELETE FROM T_PRODUCT;
/*데이터 갱신 update*/
UPDATE T_USER SET PWD = '111' WHERE ID = 'ID01';
UPDATE T_USER SET PWD = '111', NAME = '공말년' WHERE ID = 'ID01';
```

##### SELECT

```SQL
/*데이터 검색 select 문*/
Select ENAME , SAL , DEPTNO from emp; /*원하는 컬럼만 출력*/
Select * from emp where job = 'MANAGER' and sal > 2500; /*해당 조건 검색*/
Select ENAME AS "이름", SAL , DEPTNO from emp; /*컬럼에 별명 부여
컬럼에 별명을 부여했으면 후에 jdbc로 get할때 그 별명을 이용한다. */

Select SAL,SAL*12 as ASAL from emp; /*계산후 출력도 가능*/
SELECT ENAME || JOB FROM EMP; /*두개를 하나로 합칠 수도 있다.*/
SELECT ENAME ||' '|| JOB FROM EMP; /* 합친 사이에 공백 추가*/
SELECT DISTINCT JOB FROM EMP; /* 중복 제거*/
Select * from emp where ENAME like 'B%'; -- B~ 로 시작하는 값 검색
Select (SAL*12)*0.87 + (NVL(COMM,0)*0.88)  as ASAL from emp; -- NVL(COMM,0) == if(COMM == null) COMM=0;
SELECT * FROM EMP WHERE DEPTNO IN (20 , 30 ); -- ( )안의 값을 가진 것들만

Select * from emp where sal <> 5000; /* not equal*/
Select * from emp where sal != 5000; /* not equal*/
Select * from emp where comm IS NULL; -- null 은 비교연산이 불가하다.
Select * from emp where comm IS NOT NULL;

select ename , sal from emp order by sal DESC; -- SAL 내림차순 정렬 생략하면 기본인 오름차순(ASC)으로 된다
select ename ,SAL*12 from emp WHERE SAL > 1000 order by 2;-- 2번 쨰 컬럼을 기준으로...
select ename , sal ,SAL*12 AS ASAL from emp WHERE SAL > 1000 order by ASAL, ENAME DESC; -- 다중 정렬 조건
SELECT * FROM EMP ORDER BY NVL(COMM,0) DESC
INSERT INTO AAA SELECT HIREDATE , JOB ,DEPTNO ,SAL 
FROM EMP WHERE HIREDATE > '06/01/1981' AND (JOB = 'SALESMAN' OR JOB = 'CLERK')
```

###### FUNCTIONS

```SQL
-- SELECT 문을 통해 가져온 테이블을 다른 테이블에 INSERT 할 수 있다.
/* FUNCTION 함수도 존재한다. 
ABS( ) 절댓값, MOD (A,B) = A%B , ROUND(N , A) N의 소숫점 A자리수 표현
LENGTH( ) 길이 , LOWER( ) / UPPER( ) , REPLACE(STR, B ,C) 문자열 STR 에서 B 를 C 로 바꾼다.
SUBSTR(STR FROM N TO M) 문자열 STR의 N번째 부터 M개 추출
CURRENT_DATE , CURRENT_TIME , CURRENT_TIMESTAMP
DATE 타입은 모두 연산이 가능하다.
TO_CHAR(CURRENT_TIMESTAMP, 'HH:MM:SS') // 원하는 형식으로 시간 표현
TO_DATE(STR , 'YYYY/MM/DD')  STR 문자열을 DATE로 변환
MONTHS_BETWEEN( A, B) A 와 B 사이의 MONTH 카운트
CAST (X AS Y) X를 Y 타입으로 변환
NVL(A , X)  A 가 NULL이면 X 로 치환
NVL2(A, X, Y ) A 가 NULL 이면 X, 아니면 Y 로 치환

BETWEEN A AND B --  A <= X <= B
IN(A , B, C , ...) --  A OR B OR C OR ...
EXISTS ( A )  A조건이 참이라면 TRUE 리턴
*/

SELECT ENAME, JOB FROM EMP 
WHERE JOB IN ( SELECT JOB FROM EMP  WHERE ENAME = 'JONES' )
SELECT ENAME, JOB FROM EMP E 
WHERE EXISTS ( SELECT JOB FROM EMP E2 WHERE ENAME = 'JONES'
              AND E.JOB = E2.JOB )
-- 두 구문은 같다.

SELECT ENAME , REPLACE(ENAME, SUBSTR(ENAME,2,LENGTH(ENAME)) , LOWER(SUBSTR(ENAME,2,LENGTH(ENAME)))) FROM EMP

```



###### CASE

```SQL
-- CASE 각 조건에 대해 새로운 컬럼을 만들어 분류 할 때 사용.
SELECT ENAME, JOB , SAL , 
CASE WHEN SAL >= 5000
THEN '왕'
WHEN SAL BETWEEN 3000 AND 5000
THEN '관리자'
ELSE '직원'
END AS CLASS
FROM EMP
```



###### GROUP 함수

​	모든 그룹함수는 NULL값을 제외하고 계산한다.

​	결과 값이 항상 1행이기 때문에 다른 컬럼들과 함께 사용되는 것이 제한된다.

​	COUNT 

​	SUM , AVG - 숫자만 계산가능

​	MAX , MIN - 문자 ,날짜 또한 계산가능

```SQL
SELECT COUNT(*) AS CNT FROM EMP
SELECT SUM(SAL) AS SUM , AVG(SAL) AS AVG FROM EMP
SELECT MAX(SAL) AS MAX , MIN(SAL) AS MIN FROM EMP

```

###### GROUP BY (        )  ~ 를 기준으로 나누어 출력

```SQL
SELECT JOB , SUM(SAL) FROM EMP GROUP BY JOB -- JOB이 같은 녀석들의 SAL 합 출력
SELECT DEPTNO , JOB FROM EMP GROUP BY DEPTNO , JOB ORDER BY DEPTNO --DEPTNO 와 JOB 조합 별로 구분

```

###### HAVING

```SQL
SELECT DEPTNO , JOB FROM EMP GROUP BY DEPTNO , JOB HAVING DEPTNO = 10 ORDER BY DEPTNO -- GROUP BY 의 조건을 HAVING 을 통해 준다.
-- HAVING 조건을 줄수 있는건 출력을 하는 COLUMN만 가능하다.

SELECT JOB , AVG(SAL) FROM EMP WHERE DEPTNO = 10 GROUP BY JOB HAVING JOB LIKE '%E%'
-- GROUP 되어진 것들의 조건은 HAVING , ~중에서 고를때 는 WHERE
-- DEPTNO 가 10 인 것들 중, E가 들어간 직업별 AVG(SAL)을 출력

SELECT DEPTNO , JOB , AVG(SAL) FROM EMP WHERE ENAME LIKE '%A%' AND COMM IS NULL GROUP BY DEPTNO, JOB HAVING DEPTNO IN (20,30) AND AVG(SAL) > 1100

```

SELECT  -> FROM  ->  WHERE -> HAVING 순.

HAVING 과 WHERE 양쪽 모두 사용가능한 조건일 경우 WHERE 절에 쓰는것이 처리 속도 면에서 유리하다.

#### VIEW

테이블과 동일하지만, 일반 테이블의 값들을 참조하고 있는 가상의 테이블이다.

실제 데이터가 저장되어 있지는 않다.

VIEW는 참조될 때 마다 SELECT문을 실행하여 가상테이블을 만든다.

```SQL
CREATE VIEW T_EMP (ENO,EN,SAL,DNO)
AS(
SELECT EMPNO ,ENAME,SAL, DEPTNO FROM EMP
)
```



#### Primary Key

테이블 내에서 unique 하게 각 객체들을 구별할수 있을 만한 값. (ID)

#### Foriegn key

외부 테이블의 PK를 참조하는 컬럼.

RDBMS 의 Relation 특징

```SQL
ALTER TABLE ITEM ADD FOREIGN KEY (CATE)
REFERENCES CATEGORY (NO)
```

##### 서브 쿼리 

쿼리문 안에 쿼리문이 들어가 있는 형태

###### 스칼라 서브쿼리

서브쿼리 문의 결과 값이 한가지인 것

따라서 결과값을 비교연산에 사용할 수 있다.

- 반드시 FOREIGN KEY 로 연결되어 있어야 한다.

```SQL
SELECT ENAME , SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND 
(DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC IN ('DALLAS','CHICAGO')))
-- 스칼라의 리턴 값은 한번에 한개니 여러개인 경우 = 을 쓰는 대신에 IN을 써주는게 적절하다.
SELECT ENAME , SAL , (SELECT AVG(SAL) FROM EMP) FROM EMP

```

###### 상관 서브커리

```SQL

SELECT JOB , ENAME , SAL ,
(SELECT AVG(SAL) FROM EMP S2 WHERE S1.JOB = S2.JOB GROUP BY JOB) AS AVGJOBSAL
FROM EMP S1
WHERE SAL > 
(SELECT AVG(SAL) FROM EMP S2 WHERE S1.JOB = S2.JOB GROUP BY JOB)

/*ACCOUNTING 부서를 제외한 부서별 월급을 가장 많이 받는 사람을 조회하라.*/
SELECT DEPTNO , ENAME ,SAL FROM EMP S1
WHERE SAL = 
(SELECT MAX(SAL) FROM EMP S2
WHERE S1.DEPTNO = S2.DEPTNO AND S2.DEPTNO NOT IN (SELECT DEPTNO FROM DEPT WHERE DNAME = 'ACCOUNTING')
GROUP BY DEPTNO)

SELECT EMPNO , ENAME , (SELECT DNAME FROM DEPT S2 WHERE S1.DEPTNO = S2.DEPTNO)AS DNAME FROM EMP S1
```

##### 결합 (JOIN)

두개이상의 테이블을 합친다. 완전한 통합을 위해서는 PK와 FK의 연결(일치) 가 필요하다

만약 연결이 없다면 모든 경우의 수를 통합한 결과가 출력된다.

```SQL
SELECT E.EMPNO , E.ENAME ,D.DNAME , D.LOC FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO

/* DALLAS를 제외한 지역별 월급의 평균보다 많이받는 사람 출력*/
SELECT D.LOC , E.ENAME , E.SAL FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.LOC NOT IN ('DALLAS') AND SAL >
(SELECT AVG(E1.SAL) FROM EMP E1, DEPT D1
WHERE E1.DEPTNO = D1.DEPTNO AND D.LOC = D1.LOC
GROUP BY D1.LOC)
```

###### INNER JOIN 

```SQL
SELECT E.ENO , E.EN , E.SAL , S.ASAL , D.DN, D.LOC 
FROM T_EMP E , T_SAL S, T_DEPT D
WHERE E.ENO = S.ENO AND E.DNO = D.DNO

SELECT E.ENO , E.EN , E.SAL , S.ASAL , D.DN, D.LOC 
FROM T_EMP E INNER JOIN T_SAL S ON (E.ENO = S.ENO) 
INNER JOIN T_DEPT D USING(DNO)
--ANCI 표준.
```

###### SELF JOIN

```SQL
SELECT E1.ENAME, E1.EMPNO ,E2.ENAME AS MNAME 
FROM EMP E1,EMP E2
WHERE E1.MGR = E2.EMPNO
```



###### OUTTER JOIN

```SQL
SELECT E.ENAME, E.JOB , D.DNAME, D.LOC FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO(+)
-- (+)의 반대쪽의 값을 갖고 있지 않은 녀석들도 모두 출력한다.( DEPTNO 가 없는 EMP도 출력~)
SELECT E.ENAME, E.JOB , D.DNAME, D.LOC FROM EMP E LEFT OUTER JOIN DEPT D
USING (DEPTNO)
-- ANCI 표준 LEFT OR RIGHT 기준. 만약 FULL OUTER JOIN 을 한다면 모두 출력이 된다.

```

## 집합연산

##### UNION

두 구문의 결과를 합친다 

단, 출력하는 Column의 수와 데이터 형이 일치해야한다.

기본적으로 중복행을 제거한다.

```sql
SELECT ENAME,  JOB FROM EMP
WHERE JOB = 'MANAGER'
UNION
SELECT ENAME,  JOB FROM EMP
WHERE JOB = 'SALESMAN'
```

중복허용을 위해선 UNION ALL 을 사용한다.

```SQL
UNION ALL
```

INTERSECT - 테이블간 공통부분 선택

EXCEPT - 레코드 뺄셈



## 윈도우 함수

###### RANK()

​	같은 값을 갖고 있으면 동위, 다음 순위를 밀어낸다

```SQL
SELECT RANK() OVER (ORDER BY SAL DESC)  AS RANKING, ENAME ,SAL
FROM EMP ORDER BY SAL DESC
```

###### DENSE_RANK()

​	다음 순위를 밀어내지 않는다.

```SQL
SELECT DENSE_RANK() OVER (ORDER BY SAL DESC)  AS RANKING, ENAME ,SAL
FROM EMP ORDER BY SAL DESC
```

###### ROW_NUMBER()

​	동위 없이 순서만 센다.

```SQL
SELECT ROW_NUMBER() OVER (ORDER BY SAL DESC)  AS RANKING, ENAME ,SAL
FROM EMP ORDER BY SAL DESC

SELECT RANKING , ENAME,SAL ,TOTAL FROM(
	SELECT ROW_NUMBER() OVER (ORDER BY SAL DESC)  AS RANKING, ENAME ,SAL ,
    (SELECT COUNT(*) FROM EMP ) AS TOTAL
	FROM EMP ORDER BY SAL DESC , ENAME
)
WHERE RANKING <= 5
```

###### ROLLUP()

```sql
SELECT JOB , SUM(SAL) FROM EMP
GROUP BY ROLLUP(JOB)
-- 총 합계를 나타내는행을 하나 더 추가한다.
```





20190605_Team6

```SQL
SELECT RANK() OVER  (ORDER BY S.ASAL DESC ) AS RANKING , E.EN , S.ASAL FROM T_EMP E INNER JOIN T_SAL S
USING (ENO)
WHERE S.ASAL >
(SELECT AVG(S2.ASAL) FROM T_SAL S2)


SELECT * FROM EMP
WHERE EMPNO IN(
	SELECT MGR FROM(
		SELECT MGR , AVG(SAL) AS AVG , ROW_NUMBER() OVER(ORDER BY AVG(SAL) DESC) AS RANK 
        FROM EMP E
        WHERE E.MGR IN (
			SELECT EMPNO FROM EMP E2
			WHERE E2.JOB = 'MANAGER'
        )		
        GROUP BY MGR
	)
	WHERE RANK = 1
)

```

###### SEQUENCE

자동적으로 값이 변화하도록 해준다.

```SQL
create sequence pseq
increment by 1 start with 100
/* 100 부터 시작하여 1씩 증가하는 시퀀스를 만든다.*/

insert into t_product values(PSEQ.NEXTVAL,'K1',1000, SYSDATE,'a.jpg')
/*1씩 증가하는 값을 넣는다.*/

Drop sequence pseq
/*drop 을 이용해 시퀀스를 삭제한다. */
```



MYSQL 에서 변수 사용하기

```mysql
SET @hour = -1; 
SELECT @hour := @hour + 1 AS HOUR, /* 변수 선언과 1씩 증가 시키기*/
( SELECT COUNT(DATETIME) FROM ANIMAL_OUTS B WHERE HOUR(DATETIME) = @hour ) 
AS COUNT FROM ANIMAL_OUTS A 
WHERE @hour < 23
```

