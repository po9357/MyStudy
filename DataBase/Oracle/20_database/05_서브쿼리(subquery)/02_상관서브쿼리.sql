--  상관서브쿼리 (메인쿼리와 서브쿼리가 조인되어 동작)
----------------------------
--  출판사별로 출판사별 평균 도서가격보다 비싼 도서 목록을 구하시오

SELECT * FROM BOOK B
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = B.PUBLISHER)
;
-----   JOIN문
--  출판사별 평균 도서 가격
SELECT PUBLISHER, AVG(PRICE)
   FROM BOOK
 GROUP BY PUBLISHER;
-- 
SELECT * FROM BOOK B, (SELECT PUBLISHER, AVG(PRICE) PUB_AVG_PRICE
                                            FROM BOOK
                                          GROUP BY PUBLISHER) AVG
 WHERE B.PUBLISHER = AVG.PUBLISHER
            AND B.PRICE > AVG.PUB_AVG_PRICE;
--  SELECT절에 사용된 상관서브쿼리
SELECT O.*
           , (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUST_NAME
           , (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOK_NAME 
   FROM ORDERS O;
-------------------------------------------------
--  EXISTS : 존재여부 확인시 사용 (있으면 TRUE)
--  NOT EXISTS : 존재하지 않을 때 TRUE
SELECT '데이터 있음'
   FROM BOOK
 WHERE EXISTS (SELECT BOOKNAME FROM BOOK WHERE BOOKNAME LIKE '%축구%');
 
--  주문내역이 있는 고객의 이름과 전화번호를 찾으시오
SELECT NAME, PHONE FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);
--  ===================> EXISTS문 사용
SELECT C.NAME, C.PHONE FROM CUSTOMER C
 WHERE EXISTS (SELECT C.CUSTID FROM ORDERS WHERE CUSTID = C.CUSTID);
--========================================
--  UNION, UNION ALL : 합집합 처리
--  단, 조회하는 컬럼의 이름, 순서, 숫자, 타입이 일치하도록 작성
--  UNION : 중복데이터를 제외하고 합함
--  UNION ALL : 중복데이터를 포함해서 합해줌
-----------------------------------
-- UNION 사용예제
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
 ORDER BY NAME;
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;
-----
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
UNION                           --  중간에 ORDER BY는 사용할 수 없다
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;         --  중복 데이터 (CUSTID = 3)는 하나로 처리
-----
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
UNION  ALL                         --  중간에 ORDER BY는 사용할 수 없다
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;         --  중복 데이터도 모두 출력처리
-----------------------------
--  MINUS : 차집합 (빼기연산)
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)                          --  위에 문장이 기준
MINUS                                                               
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)                          --  아래 문장과 비교해 중복값 제거
 ORDER BY NAME;
-----------------------------
--  INTERSECT : 교집합 (중복데이터 조회)    --  JOIN문의 동등비교 결과와 동일
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)                        
INTERSECT                    --  중복된 데이터만 출력
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)                         
 ORDER BY NAME;
--- JOIN문
SELECT A.* FROM 
    (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)) A,
    (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)) B
 WHERE A.CUSTID = B.CUSTID
             AND A.NAME = B.NAME;