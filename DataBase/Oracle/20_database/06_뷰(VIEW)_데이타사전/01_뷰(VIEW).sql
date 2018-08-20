/**********************************************
뷰(view) : 하나 또는 하나 이상의 테이블로 부터
           데이터의 부분집합을 테이블인것 처럼 사용하는 객체

-- 뷰(VIEW) 생성문
CREATE VIEW 뷰이름 [(컬럼 별칭1, 컬럼 별칭2, ... , 컬럼 별칭N)]
AS
SELECT 문장

-- 뷰(VIEW) 사용
기존 SELECT문에 서브쿼리처럼 사용 가능 (FROM절, WHERE절 등..)

-- 뷰(VIEW) 삭제문
DROP VIEW 뷰이름;
**********************************************/
SELECT O.*, B.BOOKNAME, C.NAME
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID;
-----------------------
CREATE VIEW VW_BOOK
AS                      -- 뷰 생성문 (DDL)
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%축구%';
------------------------
SELECT *
  FROM (SELECT * FROM BOOK WHERE BOOKNAME LIKE '%축구%')
 WHERE PUBLISHER = '대한미디어';
-- 뷰(VIEW) 사용
SELECT *               -- 뷰는 테이블의 데이터를 실시간으로 가져와 사용
  FROM VW_BOOK         -- 이후 테이블 수정이 일어나면 뷰에도 변경사항이 바로 적용됨
 WHERE PUBLISHER = '대한미디어';  
SELECT *
  FROM BOOK
 WHERE PUBLISHER = '대한미디어';
-------------------------
-- 뷰(VIEW) 생성문 (컬럼 별칭(alias) 사용)
CREATE VIEW VW_BOOK2 (BNAME, PB, PRICE)
AS
SELECT BOOKNAME, PUBLISHER, PRICE
  FROM BOOK
 WHERE BOOKNAME LIKE '%축구%';

SELECT * FROM VW_BOOK2;
-----------------------
-- 뷰(VIEW)생성 - 조인문으로 만든 데이터
CREATE VIEW VW_ORDERS
AS
SELECT B.BOOKNAME, C.NAME, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID
 ORDER BY O.ORDERID;
--------
-- 박지성이 구매한 책
SELECT * FROM VW_ORDERS
WHERE NAME = '박지성';
SELECT * FROM VW_ORDERS WHERE SALEPRICE >= 20000;
DROP VIEW MADANG.VW_ORDERS; -- 뷰(VIEW) 삭제

-------------------
--(실습) 뷰를 생성, 조회, 삭제
--1. VIEW 명칭 : VW_ORD_ALL
----주문정보, 책정보, 고객정보를 모두 조회할 수 있는 형태의 뷰

--2. 이상미디어에서 출판해서 판매된 책제목, 판매금액, 판매일 조회

--3. 이상미디어 출판사의 책 중에서 추신수, 장미란이 구매한 책 정보 조회
---- 출력항목 : 구입한사람이름, 책제목, 출판사, 원가, 판매가, 판매일자)
---- 정렬 : 구입한사람이름, 구입금액이 큰것부터

--4. 만들고 사용한 뷰(VW_ORD_ALL) 삭제
--------------------
--1. VIEW 명칭 : VW_ORD_ALL
----주문정보, 책정보, 고객정보를 모두 조회할 수 있는 형태의 뷰
SELECT * FROM BOOK;
SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER;
CREATE VIEW VW_ORD_ALL
AS
SELECT O.*, B.BOOKNAME, B.PUBLISHER, B.PRICE, C.NAME, C.ADDRESS, C.PHONE
  FROM ORDERS O, CUSTOMER C, BOOK B
 WHERE O.CUSTID = C.CUSTID
   AND B.BOOKID = O.BOOKID;
SELECT * FROM VW_ORD_ALL;
--2. 이상미디어에서 출판해서 판매된 책제목, 판매금액, 판매일 조회
SELECT BOOKNAME, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '이상미디어';
--3. 이상미디어 출판사의 책 중에서 추신수, 장미란이 구매한 책 정보 조회
---- 출력항목 : 구입한사람이름, 책제목, 출판사, 원가, 판매가, 판매일자)
---- 정렬 : 구입한사람이름, 구입금액이 큰것부터
SELECT NAME, BOOKNAME, PUBLISHER, PRICE, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '이상미디어'
AND NAME IN ('추신수', '장미란')
ORDER BY NAME, SALEPRICE DESC;
--4. 만들고 사용한 뷰(VW_ORD_ALL) 삭제
DROP VIEW MADANG.VW_ORD_ALL;