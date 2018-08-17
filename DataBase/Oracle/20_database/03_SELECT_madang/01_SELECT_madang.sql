/****************************************
SELECT [ * | DISTINCT ]{ 컬럼명, 컬럼명, ..., 컬럼명 }
    FROM 테이블명
[ WHERE 조건절
  GROUP BY { 컬럼명, 컬럼명, ..., 컬럼명 }
  HAVING 조건
  ORDER BY { 컬럼명, 컬럼명, ..., 컬럼명 } [ ASC  |  DESC ]             
  --    ORDER BY 명령어는 맨 마지막에 위치해야 한다          --   ASC : 오름차순 ( 기본 / 생략 가능 )
                                                                            --   DESC : 내림차순
]
****************************************/
SELECT * FROM BOOK
ORDER BY BOOKNAME;          --  책 이름 기준 가나다순 정렬
SELECT * FROM BOOK ORDER BY BOOKNAME DESC;
--  출판사 기준 오름차순, 금액 큰금액 부터
SELECT * FROM BOOK
ORDER BY PUBLISHER, PRICE DESC;
------------------------------------
--  AND, OR, NOT : 자바에서 &&, ||, ! 등 (SQL에선 사용하지 않고 AND, OR, NOT으로 사용)
--  AND : 출판사 대한미디어, 금액이 3만원 이상인 책 조회
SELECT * FROM BOOK
    WHERE PUBLISHER = '대한미디어' AND PRICE >= 30000;
    
--  OR : 출판사 대한미디어 또는 이상미디어에서 출판한 책
SELECT * FROM BOOK 
    WHERE PUBLISHER = '대한미디어' OR PUBLISHER = '이상미디어';
    
--  NOT : 출판사 굿스포츠를 제외하고 나머지 전체
SELECT * FROM BOOK
    WHERE NOT PUBLISHER = '굿스포츠';
SELECT * FROM BOOK
    WHERE PUBLISHER != '굿스포츠';
SELECT * FROM BOOK
    WHERE PUBLISHER <> '굿스포츠';
    
SELECT * FROM BOOK
    WHERE NOT PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어' ;       --  NOT을 묶어줘야 모두 제외
SELECT * FROM BOOK
    WHERE NOT (PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어') ;

SELECT * FROM BOOK
    WHERE PUBLISHER <> '굿스포츠' AND PUBLISHER <> '대한미디어';
-----------------------------------------------------------
--  IN : 안에 있냐? (OR문을 단순화)

--  (실습) 출판사 : 나무수, 대한미디어, 삼성당 에서 출판한 책 조회
SELECT * FROM BOOK
    WHERE PUBLISHER = '나무수' OR PUBLISHER = '대한미디어' OR PUBLISHER = '삼성당';
SELECT * FROM BOOK
    WHERE PUBLISHER IN ('나무수', '대한미디어', '삼성당');

--  (실습) 출판사 : 나무수, 대한미디어, 삼성당을 제외한 출판사의 책 조회
SELECT * FROM BOOK
    WHERE NOT (PUBLISHER = '나무수'OR PUBLISHER = '대한미디어' OR PUBLISHER = '삼성당');
SELECT * FROM BOOK
    WHERE PUBLISHER <> '나무수' AND PUBLISHER <> '대한미디어' AND PUBLISHER <> '삼성당';
SELECT * FROM BOOK
    WHERE PUBLISHER NOT IN ('나무수', '대한미디어', '삼성당')
        ORDER BY PUBLISHER, PRICE;
        
----------------------------------------------------------
--    =,     >,   <,         >=,         <=,         <>, !=
--  같다, 크다, 작다, 크거나 같다, 작거나 같다, 같지 않다 ( <>표준, != DB에 따라 지원 )
--  출판된 책 중에 1만원 이상 25000원 이하인 책
SELECT * FROM BOOK
    WHERE PRICE >= 8000 AND PRICE <= 22000
        ORDER BY PRICE;

--  BETWEEN a AND b : a부터 b까지 형태로 사용
SELECT * FROM BOOK
    WHERE PRICE BETWEEN 8000 AND 22000              --  경계값 포함 ( 8000, 22000원 포함 )
        ORDER BY PRICE;

SELECT * FROM BOOK
    WHERE PRICE NOT BETWEEN 8000 AND 22000     
        ORDER BY PRICE;
        
        
--  책 제목이 '야구' ~ '올림픽'
SELECT * FROM BOOK
    WHERE BOOKNAME BETWEEN '야구' AND '올림픽'
        ORDER BY BOOKNAME;
        
--  출판사 나무수 ~ 삼성당 책 조회
SELECT * FROM BOOK
    WHERE PUBLISHER BETWEEN '나무수' AND '삼성당'
        ORDER BY PUBLISHER;
------------------------------------------
--  LIKE : '%', '_' 부호와 함께 사용
--  % : 전체(모든것)를 의미
--  _ (언더바) : 문자 하나에 대해 모든 것을 의미
-----------
--  출판사 명에 '미디어' 라는 단어가 있는 출판사에서 출판한 책 전체 조회
SELECT * FROM BOOK
    WHERE PUBLISHER LIKE '%미디어';        --  출판사 이름이 '미디어'로 끝나는 것

SELECT * FROM BOOK
    WHERE BOOKNAME LIKE '야구%';           --  책 제목이 '야구'로 시작하는 것

SELECT * FROM BOOK
    WHERE BOOKNAME LIKE '%단계%';         --  책 제목에 '단계'가 포함되어있는 것
-------------------------------------------
--  책 제목에 '구' 문자가 있는 책 목록 조회
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%구%';

--  책 제목의 두번째 문자가 '구'인 책 목록 조회
--  UPDATE BOOK SET BOOKNAME = '우리 야구의 추억' WHERE BOOKID = 7;
SELECT * FROM BOOK WHERE BOOKNAME LIKE '_구%';

--  책 제목이 2, 3번째 문자가 '구의' 인 책 목록 조회
SELECT * FROM BOOK WHERE BOOKNAME LIKE '_구의%';
----------------------------------------------
--============================================
--  그룹 함수 : 하나 이상의 행을 그룹으로 묶어서 연산
--  COUNT (*) : 데이터 갯수 조회 (전체 컬럼에 대해)
--  COUNT (컬럼명) : 데이터 갯수 조회 (지정된 컬럼에 한하여)
--  SUM (컬럼) : 합계 값 구하기
--  AVG (컬럼) : 평균 값 구하기
--  MAX (컬럼) : 최대 값 구하기
--  MIN (컬럼) : 최소 값 구하기
---------------------------
SELECT COUNT (*) FROM BOOK;                         --  BOOK 테이블의 데이터 건수
SELECT * FROM BOOK;
SELECT COUNT (*) FROM CUSTOMER;                --  CUSTOMER 테이블의 데이터 건수
SELECT * FROM CUSTOMER;
SELECT COUNT (NAME) FROM CUSTOMER;         --  5건 조회
SELECT COUNT (PHONE) FROM CUSTOMER;       --  4건 조회 ( NULL값은 조회하지 않음 )
------------------------------
--  SUM (컬럼) : 컬럼의 합계값 구할 때
SELECT * FROM BOOK;
SELECT SUM (PRICE) FROM BOOK;                     --  144500  PRICE 컬럼의 모든 데이터를 합침
SELECT SUM (PRICE) FROM BOOK
    WHERE PUBLISHER IN ('대한미디어', '이상미디어');
--WHERE PUBLISHER LIKE ('%미디어');

--  AVG (컬럼) : 컬럼의 평균값을 구할 떄
SELECT * FROM BOOK;
SELECT AVG (PRICE) FROM BOOK;
SELECT AVG (PRICE) AS AVG_PRICE FROM BOOK;      --  AS로 별칭을 부여할 수 있음
SELECT AVG (PRICE)  AVG_PRICE FROM BOOK;          --  AS 생략 가능
SELECT AVG (PRICE) FROM BOOK
    WHERE PUBLISHER IN ('대한미디어', '이상미디어');

--  MAX (컬럼) : 컬럼의 최대값을 구할 떄
--  MIN (컬럼) : 컬럼의 최소값을 구할 때
SELECT * FROM BOOK ORDER BY PRICE DESC;
SELECT MAX (PRICE) FROM BOOK;
SELECT MIN (PRICE) FROM BOOK;
SELECT MAX (PRICE), MIN (PRICE) FROM BOOK;
SELECT MAX (PRICE), MIN (PRICE) FROM BOOK
    WHERE PUBLISHER = '굿스포츠';
    
SELECT COUNT(*), SUM(PRICE), AVG(PRICE), MAX(PRICE), MIN(PRICE)
    FROM BOOK;
    
--------------------------------------------
SELECT * FROM CUSTOMER WHERE NAME = '박지성';
SELECT * FROM CUSTOMER;
--  (실습) 
--  1.  박지성의 총 구매액 (박지성의 고객번호 (CUSTID = 1))
SELECT SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = 1;
SELECT '박지성', SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = 1;

--  2.  박지성이 구매한 도서의 수
SELECT COUNT(*) FROM ORDERS WHERE CUSTID = 1;
SELECT '박지성', COUNT(*) FROM ORDERS WHERE CUSTID = 1;

--  3.  성이 '김'씨인 고객의 이름과 주소
SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '김%';
SELECT '김 씨', NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '김%';

--  4.  성이 '박'씨이고 이름이 '성'로 끝나는 고객의 이름과 주소
SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '박%성';
SELECT '박 % 성', NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '박%성';
---------------------------------------------
--  LIKE 알아보기
CREATE TABLE TEST_LIKE (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO test_like (ID, NAME) VALUES (1, '홍길동');
INSERT INTO test_like (ID, NAME) VALUES (2, '홍길동2');    
INSERT INTO test_like (ID, NAME) VALUES (3, '홍길동구');
INSERT INTO test_like (ID, NAME) VALUES (4, '홍길동대문');
INSERT INTO test_like (ID, NAME) VALUES (5, '홍길동2다');
INSERT INTO test_like (ID, NAME) VALUES (6, '김홍길동');
INSERT INTO test_like (ID, NAME) VALUES (7, '김만홍길동');
INSERT INTO test_like (ID, NAME) VALUES (8, '김홍길동만');
INSERT INTO test_like (ID, NAME) VALUES (9, '김홍길동만이다');
INSERT INTO TEST_LIKE (ID) VALUES (10);
SELECT * FROM TEST_LIKE;
SELECT * FROM TEST_LIKE WHERE NAME LIKE '홍길동';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '홍길동%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '홍길동2%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '%홍길동%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_홍길동_';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_홍길동%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_홍길동_%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '__홍길동%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '%';