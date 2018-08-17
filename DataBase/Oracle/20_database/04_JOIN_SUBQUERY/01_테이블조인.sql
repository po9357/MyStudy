SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
----------------------------
--  박지성이 구입한 금액 합계
SELECT NAME, CUSTID FROM CUSTOMER WHERE NAME = '박지성';
SELECT '박지성', SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = '1';
--  별칭을 붙이려면 '박지성' 같은 상수는 그냥, AS NAME과 같이 NAME컬럼을 불러옴 (AS 생략 가능)
 --------------------------------------------------------------
 -- 서브쿼리 (subquery) 방식
SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성';
SELECT * FROM ORDERS
    WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성');
                                    --  서브 쿼리, 부분 쿼리 
---------------------------------------------------------------
--  조인 (join) 방식
SELECT *
    FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
ORDER BY CUSTOMER.CUSTID;

SELECT CUSTOMER.CUSTID, CUSTOMER.NAME,
             ORDERS.CUSTID ORD_CUSTID, ORDERS.SALEPRICE
   FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
     AND CUSTOMER.NAME = '박지성'
ORDER BY CUSTOMER.CUSTID;

SELECT * FROM ORDERS, CUSTOMER WHERE CUSTOMER.CUSTID = ORDERS.CUSTID AND CUSTOMER.NAME = '박지성';
SELECT SUM (SALEPRICE) FROM ORDERS, CUSTOMER WHERE CUSTOMER.CUSTID = ORDERS.CUSTID AND CUSTOMER.NAME = '박지성';
----------------------------------------------------------------
SELECT CUSTOMER.CUSTID, CUSTOMER.NAME, CUSTOMER.ADDRESS,
                ORDERS.SALEPRICE, ORDERS.ORDERDATE
 FROM CUSTOMER, ORDERS
 WHERE CUSTOMER.CUSTID = ORDERS.CUSTID      --  조인조건 ( 테이블 결합시 사용 )
 AND CUSTOMER.NAME = '박지성'                             --  검색 조건 ( WHERE )
 ;
                                                --      중복되지 않는 컬럼은 테이블을 지정해주지 않아도 된다.
 SELECT CUSTOMER.CUSTID, NAME, ADDRESS,
                SALEPRICE, ORDERDATE
 FROM CUSTOMER, ORDERS                                   --  위와 동일한 결과 출력
 WHERE CUSTOMER.CUSTID = ORDERS.CUSTID      --  위는 어느 테이블에 있는 컬럼인지 알 수 있지만,
 AND NAME = '박지성'                                                --  아래는 컬럼이 어느 테이블에 있는지 알 수 없다.
 ;
----------------------------------------------------------------
--  별칭 (alias) 사용으로 단순화
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE,
                O.SALEPRICE, O.ORDERDATE
 FROM CUSTOMER C, ORDERS O                          --  별칭을 선언 ( FROM 절에서 )
 WHERE C.CUSTID = O.CUSTID
 AND C.NAME = '박지성'
 ;
 ---------------------------------------------------------------
 SELECT B.BOOKID, BOOKNAME, B.PRICE, O.SALEPRICE, O.ORDERDATE FROM BOOK B, ORDERS O WHERE B.BOOKID = O.BOOKID ORDER BY O.ORDERDATE;
 ---------------------------------------------------------------
 //////////////////////////////////////////////////////////////////////////////////////////////
 -- 주의 : 조인 조건을 명시하지 않는 경우 ( 카티션곱 catesian product )
 -- 조인 대상 테이블의 각 데이터건수 * 데이터건수 결과 발생
 --                                                        중복되지 않는 모든 데이터 출력
 SELECT * 
    FROM BOOK B, ORDERS O 
ORDER BY B.BOOKID, O.ORDERID;
------------------
--  조인 : 3개의 테이블 조인
SELECT O.CUSTID, B.BOOKID, PUBLISHER, BOOKNAME, SALEPRICE, NAME 
    FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID   --  O = B 연결
    AND O.CUSTID = C. CUSTID;   --  O = C 연결
--  고객명, 구입한 책 제목, 구입가격, 구입일자, 출판사명
SELECT NAME, BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND O.BOOKID = B.BOOKID;
---------------------
--  장미란이 구입한 책제목, 구입가격, 구입일자, 출판사
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE, PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
    AND O.BOOKID = B.BOOKID
    AND NAME = '장미란'
;
--------------------
--  장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 자료
SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE, PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
    AND O.BOOKID = B.BOOKID
    AND NAME = '장미란'
    AND ORDERDATE BETWEEN TO_DATE('2014/01/01', 'YYYY/MM/DD') 
                                        AND TO_DATE('2014/07/08', 'YYYY/MM/DD')
;
-- ===============================================
--(문제해결) 테이블 조인을 통해서 문제해결(안되면 단일 SELECT문으로 단계적으로)
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인해주세요.
--실습 : '야구를 부탁해'라는 책이 팔린 날짜를 구하세요
--실습 : '야구를 부탁해'라는 책(BOOK)을 구입한(ORDERS) 사람(CUSTOMER)은 누구인지 확인
--실습 : '추신수'가 구입한 책값과 구입일자 확인
--실습 : '추신수'가 구입한 책값의 합계금액 구하세요
--실습 : '야구를 부탁해'라는 책(BOOK)을 구입한(ORDERS) 사람(CUSTOMER)과 구입일자를 구하세요.
--실습 : '추신수', '장미란'이 구입한 책과 구입금액, 구입일자를 확인
--------------------------------------------------
SELECT BOOKNAME 책_이름, COUNT(*) 판매합계, SUM (SALEPRICE) 총_금액 
   FROM ORDERS O, BOOK B 
 WHERE O.BOOKID = B.BOOKID AND B.BOOKNAME = '야구를 부탁해' 
 GROUP BY BOOKNAME;
SELECT B.BOOKNAME 제목, C.NAME 구매자,  O.ORDERDATE 구입날짜 FROM ORDERS O ,CUSTOMER C, BOOK B
WHERE O.CUSTID = C.CUSTID
       AND O.BOOKID = B.BOOKID
       AND B.BOOKNAME = '야구를 부탁해';
SELECT NAME 구매자, O.SALEPRICE 구입가격, O.ORDERDATE 구입일자 FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID AND C.NAME = '추신수';
SELECT '추신수', SUM (SALEPRICE) FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID AND C.NAME = '추신수' GROUP BY NAME;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE 
  FROM ORDERS O, BOOK B, CUSTOMER C 
WHERE O.CUSTID = C.CUSTID 
       AND O.BOOKID = B.BOOKID 
       AND C.NAME IN('추신수', '장미란') 
ORDER BY C.NAME, O.ORDERDATE;
SELECT NAME, SUM(SALEPRICE) FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID GROUP BY NAME;
--======================================================
--  각 이름별 데이터를 모아서 합계
SELECT C.NAME, SUM(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME;

SELECT C.NAME, SUM(O.SALEPRICE), 
        COUNT(*), ROUND(AVG(O.SALEPRICE), 2),  
        MIN(O.SALEPRICE), MAX(O.SALEPRICE)
FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME;

