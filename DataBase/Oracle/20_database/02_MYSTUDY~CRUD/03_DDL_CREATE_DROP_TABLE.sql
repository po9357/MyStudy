--  =========================================================
/* (실습) 테이블명 : TEST2
        NO : 숫자타입 5자리, PRIMARY KEY 선언
        ID : 문자타입 10자리 (영문 10자리), 값이 반드시 존재
        NAME : 한글 10자리 저장 가능토록 설정, 값이 반드시 존재
        EMAIL : 영문, 숫자, 특수문자 포함 30자리
        ADDRESS : 한글 100자리
        IDNUM : 숫자타입 정수부 7자리, 소수부 3자리 EX) 1234567.789
        REGDATE : 날짜타입
**********************************/
CREATE TABLE TEST2 (
        NO NUMBER (5, 0) PRIMARY KEY,       --PRIMARY KEY는 테이블에 1나만 존재할 수 있다.
        ID VARCHAR2(10) NOT NULL,
        NAME VARCHAR2(30) NOT NULL,
        EMAIL VARCHAR2(30),
        ADDRESS VARCHAR2(300),
        IDNUM NUMBER (10, 3),
        REGDATE DATE
) ;
INSERT INTO TEST2 VALUES (12345, 20180001, '홍길동', 'po9357@naver.com', '마포구 망원동 382-3 201호', 1234567.8908, SYSDATE);
SELECT * FROM TEST2;
UPDATE TEST2 SET NO = 56789 WHERE NAME = '홍길동';
INSERT INTO TEST2 (NO, ID, NAME)
    VALUES (47895, '7895133801', '가나다라마바사아자차');
DELETE TEST2 WHERE IDNUM IS NULL;
DELETE TEST2 WHERE NO = 12345;

INSERT INTO TEST2
    VALUES (11111, 'TEST1', '홍길동1', 'test@test.com', '서울시 종로구', 1234567.6789, SYSDATE);
INSERT INTO TEST2
    VALUES (22222, 'TEST2', '홍길동2', 'test@test.com', '서울시 종로구', 1234567.6789, SYSDATE);
SELECT * FROM TEST2;
INSERT  INTO TEST2 (NO, ID, NAME)
    VALUES (11, 'TEST3', '홍길동11');
--  숫자 타입(NUMBER, NUMBERIC 등)은 오른쪽 정렬
--  문자 타입(VARCHAR2, CHAR, DATE 등)은 왼쪽 정렬
--------------------------------------------------------------------------------------------------------------------
DELETE FROM TEST2 WHERE ID = 'TEST3';
                                             --  테이블 전체 데이터 삭제
DELETE FROM TEST2;                               --전체 데이터 삭제
                                             -- DELETE FROM 명령어를 이용하면 ROLLBACK 사용 가능 (전 COMMIT 시점으로 돌아감)
TRUNCATE TABLE TEST2;                          --ROLLBACK 불가. 데이터를 잘라냄.
ROLLBACK;
                                            --  DROP TABLE 문은 테이블의 구종과 데이터를 함께 삭제처리
DROP TABLE TEST2;                                 --테이블 객체 자체를 삭제 처리
--  =================================================================================================================
SELECT * FROM TEST2;

--  특정 테이블의 데이터와 테이블 구조를 함께 복사
--  TEST2   ->  TEST3
CREATE TABLE TEST3                          --  TEST2를 TEST3로 복사
    AS SELECT * FROM TEST2;
SELECT * FROM TEST3;
SELECT * FROM TEST2;
--  NOT NULL 조건은 복사.  PRIMARY KEY 조건은 복사하지 않음.

----------------------------------------
--  특정 테이블의 구조만 복사
--  TEST2   ->  TEST4 : 데이터는 복사 안함
CREATE TABLE TEST4
    AS SELECT * FROM TEST2 WHERE 1  =   2;              
                                                            --  일부로 FALSE값을 넣어 테이블의 컬럼 구조만 복사
SELECT * FROM TEST4;


--  =================================================================================================================
/****   테이블의 컬럼 추가, 수정, 삭제
DDL : ALTER TABLE
-   ADD : 추가
-   MODIFY : 수정
         --  컬럼 사이즈 작은  ->  큰 : 언제든 가능
         --  컬럼 사이즈 큰  ->  작은 : 데이터 상태에 따라 다름
-   DROP COLUMN : 삭제
**********************************/
--  DROP TABLE TEST4;       테이블 자체 삭제
--  컬럼 추가   TEST3 테이블에 ADDCOL 컬럼 추가
SELECT * FROM TEST3;
ALTER TABLE TEST3 ADD ADDCOL VARCHAR2(10); 

--  컬럼 수정 TEST3 테이블의 ADDCOL  ->  VARCHAR2(20)
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(20);
UPDATE TEST3 SET ADDCOL = '123456789012345';
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(15);
                                                            --  오류발생 : 저장된 데이터 보다 작게 컬럼의 크기 수정
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(10);       --  데이터의 길이가 15이기 떄문에 그 아래로 수정 불가

--  컬럼의 삭제
ALTER TABLE TEST3 DROP COLUMN ADDCOL;                   --  데이터의 유무와 상관 없이 해당 컬럼 삭제