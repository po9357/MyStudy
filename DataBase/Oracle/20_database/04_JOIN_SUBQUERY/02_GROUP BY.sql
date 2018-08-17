/* ************************
SELECT [* | DISTINCT ]{컬럼명,컬럼명,...}
  FROM 테이블명
[WHERE 조건절
 GROUP BY {컬럼명,...}
 HAVING 조건  --GROUP BY 절에 대한 조건
 ORDER BY {컬럼명,... [ASC | DESC] --ASC : 오름차순(기본/생략가능)
                                  --DESC : 내림차순
]
***************************/
--  GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
--  GROUP BY 문을 사용하면 SELECT 항목은 GROUP BY 절에 사용된 컬럼
----    또는 그룹함수 (COUNT, SUM, AVG, MAX, MIN)만 사용할 수 있다.
-----------------
--  구매고객명별로 구매금액 합계를 구하시오
SELECT C.NAME, SUM(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY SUM(O.SALEPRICE)
;
--  주문 (판매)테이블의 고객별 데이터 조회 (건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
    FROM ORDERS
GROUP BY CUSTID
;
--  고객명 기준으로 고객별 건수, 합계, 평균, 최소, 최대금액
SELECT C.NAME,                                      --  이름
             COUNT(*),                                   --  건수
             SUM(O.SALEPRICE),                   --  구입(판매) 합계 금액
             TRUNC(AVG(O.SALEPRICE)),       --  구입(판매) 평균 금액
             MIN(SALEPRICE),                        --  구입(판매) 최소 금액   
             MAX(SALEPRICE)                        --  구입(판매) 최대 금액
FROM ORDERS O, CUSTOMER C                   
WHERE O.CUSTID = C.CUSTID
             AND COUNT(*) >= 3                     --  오류 발생 (HAVING 사용) 
GROUP BY C.NAME
ORDER BY SUM(O.SALEPRICE)
;
------------------------------------------------
--  HAVING절 : GROUP BY에 의해 만들어진 데이터에서 검색조건을 부여
--  HAVING절은 단독으로 쓰일 수 없다. (GROUP BY와 함께 사용해야 함)
SELECT C.NAME,                                      --  이름
             COUNT(*),                                   --  건수
             SUM(O.SALEPRICE),                   --  구입(판매) 합계 금액
             TRUNC(AVG(O.SALEPRICE)),       --  구입(판매) 평균 금액
             MIN(SALEPRICE),                        --  구입(판매) 최소 금액   
             MAX(SALEPRICE)                        --  구입(판매) 최대 금액
FROM ORDERS O, CUSTOMER C                   
WHERE O.CUSTID = C.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) >= 3                             -- HAVING절 사용
            AND SUM(O.SALEPRICE) > 31000
ORDER BY SUM(O.SALEPRICE)
;
----
--  판매(구입) 가격이 8000원 이상인 도서를 구매한 고객 대상으로
--  고객별 도서의 총 수량을 구하시오 (단 2권 이상 구매한 사람만)
SELECT CUSTID, COUNT(*)
   FROM ORDERS
 WHERE SALEPRICE >= 8000            --  판매(구매) 금액이 8000원 이상
GROUP BY CUSTID                          --  고객별
HAVING COUNT(*) >= 2;                    --  판매(구매)건수가 2 이상
--  구매자 이름 확인
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE)
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
             AND O.SALEPRICE >= 8000
 GROUP BY C.NAME
 HAVING COUNT(*) >= 2
 ;
 ----------------------------------------
 --실습 문제
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
--2. 고객별로 주문한 도서의 총 수량과 총 판매액을 구하시오.
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬하시오.
--5. 고객별로 주문한 건수와 합계금액, 평균 금액을 구하고 
---- (3권 보다 적게 구입한 사람 검색)
--번외문제: 고객테이블에 있는 사람중 책을 구입하지 않은 사람은 누구?
--  1번
SELECT B.BOOKNAME, COUNT(*), SUM(O.SALEPRICE), AVG(O.SALEPRICE), MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID
GROUP BY B.BOOKNAME;
--  2번
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE)
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
GROUP BY C.NAME;
--  3번
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE
   FROM ORDERS O, CUSTOMER C, BOOK B
 WHERE O.BOOKID = B.BOOKID
            AND O.CUSTID = C.CUSTID
ORDER BY C.NAME, O.SALEPRICE;
--  4번
SELECT C.NAME, SUM(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME;
--  5번
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), AVG(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) < 3;

SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE), AVG(O.SALEPRICE)
FROM CUSTOMER C INNER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) < 3;
--  번외문제
SELECT * FROM CUSTOMER
WHERE NOT EXISTS (SELECT * FROM ORDERS WHERE CUSTOMER.CUSTID = ORDERS.CUSTID);
