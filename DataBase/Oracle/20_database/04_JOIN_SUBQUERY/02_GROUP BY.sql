/* ************************
SELECT [* | DISTINCT ]{�÷���,�÷���,...}
  FROM ���̺��
[WHERE ������
 GROUP BY {�÷���,...}
 HAVING ����  --GROUP BY ���� ���� ����
 ORDER BY {�÷���,... [ASC | DESC] --ASC : ��������(�⺻/��������)
                                  --DESC : ��������
]
***************************/
--  GROUP BY : �����͸� �׷����ؼ� ó���� ��� ���
--  GROUP BY ���� ����ϸ� SELECT �׸��� GROUP BY ���� ���� �÷�
----    �Ǵ� �׷��Լ� (COUNT, SUM, AVG, MAX, MIN)�� ����� �� �ִ�.
-----------------
--  ���Ű����� ���űݾ� �հ踦 ���Ͻÿ�
SELECT C.NAME, SUM(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY SUM(O.SALEPRICE)
;
--  �ֹ� (�Ǹ�)���̺��� ���� ������ ��ȸ (�Ǽ�, �հ�, ���, �ּ�, �ִ�ݾ�)
SELECT CUSTID, COUNT(*), SUM(SALEPRICE), TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
    FROM ORDERS
GROUP BY CUSTID
;
--  ���� �������� ���� �Ǽ�, �հ�, ���, �ּ�, �ִ�ݾ�
SELECT C.NAME,                                      --  �̸�
             COUNT(*),                                   --  �Ǽ�
             SUM(O.SALEPRICE),                   --  ����(�Ǹ�) �հ� �ݾ�
             TRUNC(AVG(O.SALEPRICE)),       --  ����(�Ǹ�) ��� �ݾ�
             MIN(SALEPRICE),                        --  ����(�Ǹ�) �ּ� �ݾ�   
             MAX(SALEPRICE)                        --  ����(�Ǹ�) �ִ� �ݾ�
FROM ORDERS O, CUSTOMER C                   
WHERE O.CUSTID = C.CUSTID
             AND COUNT(*) >= 3                     --  ���� �߻� (HAVING ���) 
GROUP BY C.NAME
ORDER BY SUM(O.SALEPRICE)
;
------------------------------------------------
--  HAVING�� : GROUP BY�� ���� ������� �����Ϳ��� �˻������� �ο�
--  HAVING���� �ܵ����� ���� �� ����. (GROUP BY�� �Բ� ����ؾ� ��)
SELECT C.NAME,                                      --  �̸�
             COUNT(*),                                   --  �Ǽ�
             SUM(O.SALEPRICE),                   --  ����(�Ǹ�) �հ� �ݾ�
             TRUNC(AVG(O.SALEPRICE)),       --  ����(�Ǹ�) ��� �ݾ�
             MIN(SALEPRICE),                        --  ����(�Ǹ�) �ּ� �ݾ�   
             MAX(SALEPRICE)                        --  ����(�Ǹ�) �ִ� �ݾ�
FROM ORDERS O, CUSTOMER C                   
WHERE O.CUSTID = C.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) >= 3                             -- HAVING�� ���
            AND SUM(O.SALEPRICE) > 31000
ORDER BY SUM(O.SALEPRICE)
;
----
--  �Ǹ�(����) ������ 8000�� �̻��� ������ ������ �� �������
--  ���� ������ �� ������ ���Ͻÿ� (�� 2�� �̻� ������ �����)
SELECT CUSTID, COUNT(*)
   FROM ORDERS
 WHERE SALEPRICE >= 8000            --  �Ǹ�(����) �ݾ��� 8000�� �̻�
GROUP BY CUSTID                          --  ����
HAVING COUNT(*) >= 2;                    --  �Ǹ�(����)�Ǽ��� 2 �̻�
--  ������ �̸� Ȯ��
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE)
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
             AND O.SALEPRICE >= 8000
 GROUP BY C.NAME
 HAVING COUNT(*) >= 2
 ;
 ----------------------------------------
 --�ǽ� ����
--1. ���� �ֹ��� ������ ���ǸŰǼ�, �Ǹž�, ��հ�, ������, �ְ� ���ϱ�
--2. ������ �ֹ��� ������ �� ������ �� �Ǹž��� ���Ͻÿ�.
--3. ���� �̸��� ���� �ֹ��� ������ �ǸŰ����� �˻�
--4. ������ �ֹ��� ��� ������ �� �Ǹž��� ���ϰ�, ������ �����Ͻÿ�.
--5. ������ �ֹ��� �Ǽ��� �հ�ݾ�, ��� �ݾ��� ���ϰ� 
---- (3�� ���� ���� ������ ��� �˻�)
--���ܹ���: �����̺� �ִ� ����� å�� �������� ���� ����� ����?
--  1��
SELECT B.BOOKNAME, COUNT(*), SUM(O.SALEPRICE), AVG(O.SALEPRICE), MIN(O.SALEPRICE), MAX(O.SALEPRICE)
  FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID
GROUP BY B.BOOKNAME;
--  2��
SELECT C.NAME, COUNT(*), SUM(O.SALEPRICE)
   FROM ORDERS O, CUSTOMER C
 WHERE O.CUSTID = C.CUSTID
GROUP BY C.NAME;
--  3��
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE
   FROM ORDERS O, CUSTOMER C, BOOK B
 WHERE O.BOOKID = B.BOOKID
            AND O.CUSTID = C.CUSTID
ORDER BY C.NAME, O.SALEPRICE;
--  4��
SELECT C.NAME, SUM(O.SALEPRICE)
   FROM CUSTOMER C, ORDERS O
 WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME;
--  5��
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
--  ���ܹ���
SELECT * FROM CUSTOMER
WHERE NOT EXISTS (SELECT * FROM ORDERS WHERE CUSTOMER.CUSTID = ORDERS.CUSTID);
