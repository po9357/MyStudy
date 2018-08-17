--  서브쿼리(부속질의, subquery)
-- SQL문(SELECT, INSERT, UPDATE, DELETE) 내에 있는 쿼리문(SELECT)
-----------------------------------
--  '박지성'이 구입한 내역을 검색
SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER WHERE NAME = '박지성';      --  CUSTID : 1
SELECT * FROM ORDERS 
 WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME IN '박지성', '김연아');       --  CUSTID가 2개가 와서 앞의 = 로 비교할 수 없다.
 SELECT * FROM ORDERS 
 WHERE CUSTID IN (SELECT CUSTID FROM CUSTOMER WHERE NAME IN ('박지성', '김연아'));
----
SELECT C.NAME, O.*
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
      AND C.NAME = '박지성';
-----------------------
--  가장 비싼 도서의 이름을 구하시오
SELECT MAX (PRICE) FROM BOOK;       --  35000
SELECT * FROM BOOK
 WHERE PRICE = 35000;
 --
 SELECT * FROM BOOK
  WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK);
-----------------------
--  서브쿼리 사용
SELECT *
   FROM BOOK B,
                (SELECT MAX(PRICE) MAX_PRICE FROM BOOK) M
 WHERE B.PRICE = M.MAX_PRICE; 
SELECT * FROM ORDERS WHERE SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS);
--
SELECT * 
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
        AND C.NAME IN ('박지성', '김연아');
-------------------------------
--  SELECT절에 서브쿼리 사용예
SELECT O.ORDERID,
             (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUSTNAME,
             (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOKNAME,
             O.SALEPRICE, O.ORDERDATE
   FROM ORDERS O;
-------------------------------
--  박지성이 구매한 책 목록(제목)
SELECT BOOKNAME
   FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID
                                  FROM ORDERS
                                WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성'));
--  판매가가 제일 높은 책
--  (서브쿼리)
SELECT * FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID 
                                  FROM ORDERS
                                WHERE SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS));
                                --                  서브쿼리는 안쪽에 있는 문장부터 연산
--  (조인문)
SELECT * FROM BOOK B, ORDERS O WHERE B.BOOKID = O.BOOKID AND O.SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS);
                                
--------------------------------
--  서브쿼리 이용
--1.  한 번이라도 구매한 내역이 있는 사람
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);
SELECT DISTINCT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE 
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID 
 ORDER BY C.CUSTID;
 -- 번외 : 한 번도 구매한 내역이 없는 사람
SELECT * FROM CUSTOMER WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS);
SELECT * FROM CUSTOMER WHERE NOT EXISTS (SELECT CUSTID FROM ORDERS WHERE ORDERS.CUSTID = CUSTOMER.CUSTID);
--2.  20000원 이상되는 책을 구입한 고객 명단 조회 (서브쿼리, 조인문)
--  (서브쿼리)
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000);
 -- (조인문)
 SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND O.SALEPRICE >= 20000;
--3.  '대한미디어' 출판사의 도서를 구매한 고객이름 조회 (서브쿼리, 조인문)
--  (서브쿼리)
SELECT NAME FROM CUSTOMER 
 WHERE CUSTID IN (SELECT CUSTID 
                                  FROM ORDERS 
                                WHERE BOOKID IN (SELECT BOOKID 
                                                                  FROM BOOK 
                                                                WHERE PUBLISHER = '대한미디어'));
--  (조인문)
SELECT C.NAME FROM CUSTOMER C, ORDERS O, BOOK B 
                        WHERE C.CUSTID = O.CUSTID
                             AND O.BOOKID = B.BOOKID
                             AND B.PUBLISHER = '대한미디어';
--4.  전체 책가격 평균보다 비싼 책의 목록 조회 (서브쿼리, 조인문)
--  (서브쿼리)
SELECT * FROM BOOK 
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK);
SELECT * FROM BOOK
 WHERE PRICE > (SELECT AVG(SALEPRICE) FROM ORDERS);
--  (조인문)
SELECT * FROM BOOK B, (SELECT AVG(PRICE) AVG_PRICE FROM BOOK) AVG
 WHERE B.PRICE > AVG.AVG_PRICE;
SELECT DISTINCT B.BOOKID, B.BOOKNAME, B.PUBLISHER, B.PRICE, (SELECT AVG(SALEPRICE) FROM ORDERS) "판매가 평균" FROM BOOK B, ORDERS O 
 WHERE B.BOOKID = O.BOOKID (+)
             AND B.PRICE > (SELECT AVG(SALEPRICE) FROM ORDERS)
ORDER BY B.BOOKID;
