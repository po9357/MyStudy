/************************************************************
데이터 정의어
-   DDL (Data Dfinition Language) : 데이터를 정의하는 언어
-   CREATE (생성), DROP (삭제), ALTER(수정)
-   { } 반복 가능, [ ] 생략 가능, | 또는 (선택)
CREATE TABLE 테이블명 (
{컬럼명 데이터타입                                       
       [ NOT NULL | UNIQUE | DEFAULT 기본값 | CHECK 체크조건 ]        
}
    [ PRIMARY KEY 컬럼명 ]                                                                                                     
    { [FOREIGN KEY 컬럼명 REFERENCES 테이블명 (컬럼명) ]
    [ ON DELETE [CASCADE | SET NULL]
    }                                                                                                       
) ;
-----------------
컬럼의 기본 데이터 타입
VARCHAR2 (n) : 문자열 가변길이
CHAR (n) : 문자열 고정길이
NUMBER (p, s) : 숫자타입 p : 전체길이, s : 소수점 이하 자리수
    예)  (5, 2) : 정수부 3자리, 소수부 2자리   -   전체 5자리
DATE : 날짜형 년, 월, 일 시간 값 저장

문자열 처리 : UTF-8 형태로 저장
-   숫자, 알파벳, 특수문자 : 1  byte 처리(키보드 자판 글자들)
-   한글 : 3  byte 처리
************************************************************/
CREATE TABLE MEMBER (
    ID VARCHAR2 (20) PRIMARY KEY,
    NAME VARCHAR2 (30) NOT NULL,
    PASSWORD VARCHAR2 (20) NOT NULL,
    PHONE VARCHAR2 (20),
    ADDRESS VARCHAR2 (200)
) ;
INSERT INTO MEMBER 
            (ID, NAME, PASSWORD)
VALUES ('hong', '홍길동', '1234');
SELECT * FROM MEMBER ;
COMMIT;
INSERT INTO MEMBER
            (ID, NAME, PASSWORD)
VALUES ('hong2', '홍길동', '1234') ;
---
INSERT INTO MEMBER
            (ID, NAME)
VALUES ('hong3', '홍길동3') ;      --cannot insert NULL into ("MYSTUDY"."MEMBER"."PASSWORD")

------
INSERT INTO MEMBER
            (ID, NAME, PASSWORD)
VALUES ('hong4', '홍길동4', 1234) ;
-------------------------------------
SELECT * FROM MEMBER;
--컬럼을 명시적으로 쓰지 않고 INSERT 문 사용시
--테이블에 있는 모든 컬럼에 대하여 순서대로 데이터 입력해야 함
INSERT INTO MEMBER
VALUES ('hong5', '홍길동', '1234', '010-1111-1111', '서울시') ;
COMMIT;
INSERT INTO MEMBER (ID, NAME, PASSWORD, PHONE, ADDRESS)
VALUES ('hong6', '홍길동5', '1234', '서울시', '010-1111-1111') ;
UPDATE MEMBER SET NAME = '홍길동5' WHERE ID = 'hong5';
UPDATE MEMBER SET NAME = '홍길동6' WHERE ID = 'hong6';
INSERT INTO MEMBER (ID, NAME, PASSWORD, ADDRESS, PHONE)
VALUES ('hong7', '홍길동7', '1234', '서울시', '010-1234-5678');


-----------------------------------------
--컬럼 특성을 확인하기 위한 테이블
CREATE TABLE TEST (
        NUM NUMBER (5,2),    --전체 자리수 5, 정수부 3, 소수부 2
        STR1 CHAR(10),          --고정길이
        STR2 VARCHAR(10),    -- 가변길이
        DATE1 DATE                  
);
INSERT INTO TEST VALUES (100.456, 'ABC', 'ABC', SYSDATE) ;
INSERT INTO TEST VALUES (100.454, 'ABC', 'ABC', SYSDATE) ;
INSERT INTO TEST VALUES (100.454, 'DEF', 'DEF  ', SYSDATE) ;
SELECT TO_CHAR (SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT * FROM TEST;
SELECT '-' || STR1 || '-', '-' || STR2 || '-' FROM TEST;
--STR1은 CHAR 타입 (고정길이) 빈 공간이 채워진 후 '-'가 들어감
--STR2는 VARCHAR 타입 (가변길이) 빈 공간은 채워지지 않음.
--'DEF  '의 경우 '  '스페이스 (빈 문자)도 문자 취급이 된다 (VARCHAR 타입)
--------------------
SELECT * FROM TEST WHERE STR1 = STR2;    --조회된 데이터 없음
SELECT * FROM TEST WHERE STR1 = 'ABC';     --오라클에서는 조회 됨 (빈 문자열이 들어가 있지만 조회 가능)
--'ABC' 문자열 비교  'ABC       '
SELECT * FROM TEST WHERE STR1 = 'ABC       ';   --모든 DB 적용
-------------
SELECT * FROM TEST WHERE NUM = 100.45;      --NUMBER = NUMBER
SELECT * FROM TEST WHERE NUM = '100.45';      --NUMBER = VARCHAR (CHAR) 조회 가능(오라클에서는)
SELECT * FROM TEST WHERE NUM = '100.45A';   --당연히 조회 안됨 (CHAR 혹은 VARCHAR타입에서 NUMBER타입으로 바꿀 수 없음)
----
INSERT INTO TEST (STR1, STR2)
VALUES ('1234567890', '1234567890');
SELECT * FROM TEST;
SELECT * FROM TEST WHERE STR1 = STR2;       --STR1 과 STR2 모두 10자리 (CHAR(10)과 VARCHAR(10))
SELECT '-' || STR1 || '-', '-' || STR2 || '-' FROM TEST;
----------------------------------------------
--UTF-8 타입으로 데이터 저장
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', 'ABCDEFGHIJ');      
-- 1234567890과 마찬가지 결과가 나옴 (UTF-8 타입은 숫자, 알파벳 모두 1바이트)
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '대한민국');
--  ABCDEFGHIJ = 10바이트          대한민국  =  12바이트 (UTF-8 타입에서 한글은 글자당 3 바이트)
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '홍길동');
COMMIT;
--  ===================================================================================
--  NULL (널) : 빈 문자열('')도 아니고, 특정 값이 아닌 데이터가 없는 상태
--  NULL은 비교처리가 안됨  :  =, <>, >, <, >=, <= 비교처리가 의미 없음
--  NULL 과의 연산 결과는 항상 NULL(연산 의미 없음)
--  NULL 값에 대한 조회는 IS NULL, IS NOT NULL 문장으로 조회
--------------------------------
SELECT * FROM TEST WHERE NUM = NULL;                --조회 데이터 없음
SELECT * FROM TEST WHERE NUM IS NULL;
SELECT * FROM TEST WHERE NUM <> NULL;              --조회 안됨
SELECT * FROM TEST WHERE NUM IS NOT NULL;
--NULL값과 관련된 데이터를 조회하고 싶을 때는 IS NULL 혹은 IS NOT NULL로 조회
--NULL 과의 연산 결과
SELECT NUM + 10 FROM TEST;
SELECT NUM + NULL FROM TEST;          -- NULL과의 연산 결과는 모두 NULL
--어떤 컬럼 간에 연산이 있을 시 NULL이 포함되어 있으면 해당 로우는 결과 값이 NULL이 됨. (주의)
--정렬시 NULL
SELECT * FROM TEST ORDER BY STR1;               --ASC (오름차순 정렬) 키워드 생략
SELECT * FROM TEST ORDER BY STR1 DESC;     --DESC (역순으로 정렬)
--오라클에서는 기본 NULL 값을 가장 큰 값으로 정렬 처리 (맨 마지막 순서)
SELECT * FROM TEST ORDER BY NUM;
SELECT * FROM TEST ORDER BY NUM DESC;
--NULL 값의 순서 변경 처리 : NULLS FIRST, NULLS LAST 
SELECT * FROM TEST ORDER BY NUM NULLS FIRST;    --NULL값을 맨 처음 표시
SELECT * FROM TEST ORDER BY NUM DESC NULLS LAST;

--
SELECT NUM FROM TEST;
--내장함수 NVL (컬럼, 설정값)    컬럼이 NULL이면 설정값으로 변환
SELECT NUM, NUM + 10, NVL (NUM, 0) + 100 FROM TEST;
----------------------------
SELECT * FROM TEST;
INSERT INTO TEST (NUM, STR1, STR2) VALUES (200, '', NULL);
SELECT * FROM TEST WHERE STR1 = '';
SELECT STR1, STR1 || '-테스트',
            NVL (STR1, '내용없음') || '-테스트'
FROM TEST;
