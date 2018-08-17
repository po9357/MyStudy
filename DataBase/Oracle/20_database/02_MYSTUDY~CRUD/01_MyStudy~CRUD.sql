SELECT * FROM STUDENT;
--데이터 추가 : 데이터 입력(INSERT)
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH) 
VALUES ('2018001', '홍길동', 100, 90, 80) ;

COMMIT; --COMMIT : 데이터 확정 저장

ROLLBACK; --이전 커밋 시점까지 롤백

INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018002', '김유신', 95, 90, 80);
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018002', '강감찬', 70, 90, 80);
COMMIT;
---------------
SELECT * FROM STUDENT;
-----------------------------------
--수정 : 데이터 수정 (UPDATE)
--강감찬 수학점수 : 80 -> 88 수정
SELECT * FROM STUDENT WHERE NAME = '강감찬' ;
UPDATE STUDENT
    SET KOR = 90, MATH = 88, ENG = 77               --WHERE 조건이 붙지 않으면 기본적으로 전체 데이터를 수정
    WHERE NAME = '강감찬';     --UPDATE, DELETE 명령어는 기본적으로 WHERE이 붙는다 생각 (범위 지정)
COMMIT;
UPDATE STUDENT 
    SET ID = 2018003
    WHERE NAME = '강감찬';
------------------------------------------------------------------------
--김유신 -> 을지문덕 이름 변경
SELECT * FROM STUDENT;
UPDATE STUDENT
    SET NAME = '을지문덕'
WHERE ID = '2018002' ;                    --중복된 데이터를 모두 바꿀 수 있으므로, ID같이 절대 중복되지 않는 값으로 대상을 지정하는것이 좋다
--  =, >, <, >=, <=, !=, <> 모두 사용 가능
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018004', '김유신', 90, 90, 90);

SELECT * FROM STUDENT
ORDER by id;
COMMIT;
--------------------------------------
--삭제 : 데이터 삭제 (DELETE)
SELECT * FROM STUDENT WHERE NAME = '강감찬';
DELETE FROM STUDENT WHERE NAME = '강감찬' ;
COMMIT;
DELETE STUDENT WHERE NAME = '김유신' ;             --FROM절 생략 가능하나 웬만하면 사용할것
-----------------------------------------------------------------
--SELECT 컬럼, .., .. FROM 테이블 WHERE ...;
--INSERT INTO 테이블 (.., .., ..) VALUES (.., .., ..) ;
--UPDATE 테이블 SET 컬럼 = 값, 컬럼 = 값, ... , 컬럼 = 값 WHERE ...;
--DELETE FROM 테이블 WHERE ...;
