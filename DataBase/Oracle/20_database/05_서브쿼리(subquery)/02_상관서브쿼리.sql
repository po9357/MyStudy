--  ����������� (���������� ���������� ���εǾ� ����)
----------------------------
--  ���ǻ纰�� ���ǻ纰 ��� �������ݺ��� ��� ���� ����� ���Ͻÿ�

SELECT * FROM BOOK B
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = B.PUBLISHER)
;
-----   JOIN��
--  ���ǻ纰 ��� ���� ����
SELECT PUBLISHER, AVG(PRICE)
   FROM BOOK
 GROUP BY PUBLISHER;
-- 
SELECT * FROM BOOK B, (SELECT PUBLISHER, AVG(PRICE) PUB_AVG_PRICE
                                            FROM BOOK
                                          GROUP BY PUBLISHER) AVG
 WHERE B.PUBLISHER = AVG.PUBLISHER
            AND B.PRICE > AVG.PUB_AVG_PRICE;
--  SELECT���� ���� �����������
SELECT O.*
           , (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUST_NAME
           , (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOK_NAME 
   FROM ORDERS O;
-------------------------------------------------
--  EXISTS : ���翩�� Ȯ�ν� ��� (������ TRUE)
--  NOT EXISTS : �������� ���� �� TRUE
SELECT '������ ����'
   FROM BOOK
 WHERE EXISTS (SELECT BOOKNAME FROM BOOK WHERE BOOKNAME LIKE '%�౸%');
 
--  �ֹ������� �ִ� ���� �̸��� ��ȭ��ȣ�� ã���ÿ�
SELECT NAME, PHONE FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS);
--  ===================> EXISTS�� ���
SELECT C.NAME, C.PHONE FROM CUSTOMER C
 WHERE EXISTS (SELECT C.CUSTID FROM ORDERS WHERE CUSTID = C.CUSTID);
--========================================
--  UNION, UNION ALL : ������ ó��
--  ��, ��ȸ�ϴ� �÷��� �̸�, ����, ����, Ÿ���� ��ġ�ϵ��� �ۼ�
--  UNION : �ߺ������͸� �����ϰ� ����
--  UNION ALL : �ߺ������͸� �����ؼ� ������
-----------------------------------
-- UNION ��뿹��
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
 ORDER BY NAME;
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;
-----
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
UNION                           --  �߰��� ORDER BY�� ����� �� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;         --  �ߺ� ������ (CUSTID = 3)�� �ϳ��� ó��
-----
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)
UNION  ALL                         --  �߰��� ORDER BY�� ����� �� ����
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)
 ORDER BY NAME;         --  �ߺ� �����͵� ��� ���ó��
-----------------------------
--  MINUS : ������ (���⿬��)
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)                          --  ���� ������ ����
MINUS                                                               
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)                          --  �Ʒ� ����� ���� �ߺ��� ����
 ORDER BY NAME;
-----------------------------
--  INTERSECT : ������ (�ߺ������� ��ȸ)    --  JOIN���� ����� ����� ����
SELECT CUSTID,  NAME FROM CUSTOMER
 WHERE CUSTID IN (1, 2, 3)                        
INTERSECT                    --  �ߺ��� �����͸� ���
SELECT CUSTID, NAME FROM CUSTOMER
 WHERE CUSTID IN (3, 4, 5)                         
 ORDER BY NAME;
--- JOIN��
SELECT A.* FROM 
    (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (1, 2, 3)) A,
    (SELECT CUSTID, NAME FROM CUSTOMER WHERE CUSTID IN (3, 4, 5)) B
 WHERE A.CUSTID = B.CUSTID
             AND A.NAME = B.NAME;