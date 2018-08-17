--  ��������(�μ�����, subquery)
-- SQL��(SELECT, INSERT, UPDATE, DELETE) ���� �ִ� ������(SELECT)
-----------------------------------
--  '������'�� ������ ������ �˻�
SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER WHERE NAME = '������';      --  CUSTID : 1
SELECT * FROM ORDERS 
 WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME IN '������', '�迬��');       --  CUSTID�� 2���� �ͼ� ���� = �� ���� �� ����.
 SELECT * FROM ORDERS 
 WHERE CUSTID IN (SELECT CUSTID FROM CUSTOMER WHERE NAME IN ('������', '�迬��'));
----
SELECT C.NAME, O.*
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
      AND C.NAME = '������';
-----------------------
--  ���� ��� ������ �̸��� ���Ͻÿ�
SELECT MAX (PRICE) FROM BOOK;       --  35000
SELECT * FROM BOOK
 WHERE PRICE = 35000;
 --
 SELECT * FROM BOOK
  WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK);
-----------------------
--  �������� ���
SELECT *
   FROM BOOK B,
                (SELECT MAX(PRICE) MAX_PRICE FROM BOOK) M
 WHERE B.PRICE = M.MAX_PRICE; 
SELECT * FROM ORDERS WHERE SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS);
--
SELECT * 
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
        AND C.NAME IN ('������', '�迬��');
-------------------------------
--  SELECT���� �������� ��뿹
SELECT O.ORDERID,
             (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUSTNAME,
             (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOKNAME,
             O.SALEPRICE, O.ORDERDATE
   FROM ORDERS O;
-------------------------------
--  �������� ������ å ���(����)
SELECT BOOKNAME
   FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID
                                  FROM ORDERS
                                WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������'));
--  �ǸŰ��� ���� ���� å
--  (��������)
SELECT * FROM BOOK
 WHERE BOOKID IN (SELECT BOOKID 
                                  FROM ORDERS
                                WHERE SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS));
                                --                  ���������� ���ʿ� �ִ� ������� ����
--  (���ι�)
SELECT * FROM BOOK B, ORDERS O WHERE B.BOOKID = O.BOOKID AND O.SALEPRICE = (SELECT MAX(SALEPRICE) FROM ORDERS);
                                
--------------------------------
--  �������� �̿�
--1.  �� ���̶� ������ ������ �ִ� ���
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);
SELECT DISTINCT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE 
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID 
 ORDER BY C.CUSTID;
 -- ���� : �� ���� ������ ������ ���� ���
SELECT * FROM CUSTOMER WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS);
SELECT * FROM CUSTOMER WHERE NOT EXISTS (SELECT CUSTID FROM ORDERS WHERE ORDERS.CUSTID = CUSTOMER.CUSTID);
--2.  20000�� �̻�Ǵ� å�� ������ �� ��� ��ȸ (��������, ���ι�)
--  (��������)
SELECT * FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000);
 -- (���ι�)
 SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
 AND O.SALEPRICE >= 20000;
--3.  '���ѹ̵��' ���ǻ��� ������ ������ ���̸� ��ȸ (��������, ���ι�)
--  (��������)
SELECT NAME FROM CUSTOMER 
 WHERE CUSTID IN (SELECT CUSTID 
                                  FROM ORDERS 
                                WHERE BOOKID IN (SELECT BOOKID 
                                                                  FROM BOOK 
                                                                WHERE PUBLISHER = '���ѹ̵��'));
--  (���ι�)
SELECT C.NAME FROM CUSTOMER C, ORDERS O, BOOK B 
                        WHERE C.CUSTID = O.CUSTID
                             AND O.BOOKID = B.BOOKID
                             AND B.PUBLISHER = '���ѹ̵��';
--4.  ��ü å���� ��պ��� ��� å�� ��� ��ȸ (��������, ���ι�)
--  (��������)
SELECT * FROM BOOK 
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK);
SELECT * FROM BOOK
 WHERE PRICE > (SELECT AVG(SALEPRICE) FROM ORDERS);
--  (���ι�)
SELECT * FROM BOOK B, (SELECT AVG(PRICE) AVG_PRICE FROM BOOK) AVG
 WHERE B.PRICE > AVG.AVG_PRICE;
SELECT DISTINCT B.BOOKID, B.BOOKNAME, B.PUBLISHER, B.PRICE, (SELECT AVG(SALEPRICE) FROM ORDERS) "�ǸŰ� ���" FROM BOOK B, ORDERS O 
 WHERE B.BOOKID = O.BOOKID (+)
             AND B.PRICE > (SELECT AVG(SALEPRICE) FROM ORDERS)
ORDER BY B.BOOKID;
