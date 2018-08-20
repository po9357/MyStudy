/**********************************************
��(view) : �ϳ� �Ǵ� �ϳ� �̻��� ���̺�� ����
           �������� �κ������� ���̺��ΰ� ó�� ����ϴ� ��ü

-- ��(VIEW) ������
CREATE VIEW ���̸� [(�÷� ��Ī1, �÷� ��Ī2, ... , �÷� ��ĪN)]
AS
SELECT ����

-- ��(VIEW) ���
���� SELECT���� ��������ó�� ��� ���� (FROM��, WHERE�� ��..)

-- ��(VIEW) ������
DROP VIEW ���̸�;
**********************************************/
SELECT O.*, B.BOOKNAME, C.NAME
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID;
-----------------------
CREATE VIEW VW_BOOK
AS                      -- �� ������ (DDL)
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%�౸%';
------------------------
SELECT *
  FROM (SELECT * FROM BOOK WHERE BOOKNAME LIKE '%�౸%')
 WHERE PUBLISHER = '���ѹ̵��';
-- ��(VIEW) ���
SELECT *               -- ��� ���̺��� �����͸� �ǽð����� ������ ���
  FROM VW_BOOK         -- ���� ���̺� ������ �Ͼ�� �信�� ��������� �ٷ� �����
 WHERE PUBLISHER = '���ѹ̵��';  
SELECT *
  FROM BOOK
 WHERE PUBLISHER = '���ѹ̵��';
-------------------------
-- ��(VIEW) ������ (�÷� ��Ī(alias) ���)
CREATE VIEW VW_BOOK2 (BNAME, PB, PRICE)
AS
SELECT BOOKNAME, PUBLISHER, PRICE
  FROM BOOK
 WHERE BOOKNAME LIKE '%�౸%';

SELECT * FROM VW_BOOK2;
-----------------------
-- ��(VIEW)���� - ���ι����� ���� ������
CREATE VIEW VW_ORDERS
AS
SELECT B.BOOKNAME, C.NAME, O.SALEPRICE, O.ORDERDATE
  FROM ORDERS O, BOOK B, CUSTOMER C
 WHERE O.BOOKID = B.BOOKID
   AND O.CUSTID = C.CUSTID
 ORDER BY O.ORDERID;
--------
-- �������� ������ å
SELECT * FROM VW_ORDERS
WHERE NAME = '������';
SELECT * FROM VW_ORDERS WHERE SALEPRICE >= 20000;
DROP VIEW MADANG.VW_ORDERS; -- ��(VIEW) ����

-------------------
--(�ǽ�) �並 ����, ��ȸ, ����
--1. VIEW ��Ī : VW_ORD_ALL
----�ֹ�����, å����, �������� ��� ��ȸ�� �� �ִ� ������ ��

--2. �̻�̵��� �����ؼ� �Ǹŵ� å����, �Ǹűݾ�, �Ǹ��� ��ȸ

--3. �̻�̵�� ���ǻ��� å �߿��� �߽ż�, ��̶��� ������ å ���� ��ȸ
---- ����׸� : �����ѻ���̸�, å����, ���ǻ�, ����, �ǸŰ�, �Ǹ�����)
---- ���� : �����ѻ���̸�, ���Աݾ��� ū�ͺ���

--4. ����� ����� ��(VW_ORD_ALL) ����
--------------------
--1. VIEW ��Ī : VW_ORD_ALL
----�ֹ�����, å����, �������� ��� ��ȸ�� �� �ִ� ������ ��
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
--2. �̻�̵��� �����ؼ� �Ǹŵ� å����, �Ǹűݾ�, �Ǹ��� ��ȸ
SELECT BOOKNAME, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '�̻�̵��';
--3. �̻�̵�� ���ǻ��� å �߿��� �߽ż�, ��̶��� ������ å ���� ��ȸ
---- ����׸� : �����ѻ���̸�, å����, ���ǻ�, ����, �ǸŰ�, �Ǹ�����)
---- ���� : �����ѻ���̸�, ���Աݾ��� ū�ͺ���
SELECT NAME, BOOKNAME, PUBLISHER, PRICE, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '�̻�̵��'
AND NAME IN ('�߽ż�', '��̶�')
ORDER BY NAME, SALEPRICE DESC;
--4. ����� ����� ��(VW_ORD_ALL) ����
DROP VIEW MADANG.VW_ORD_ALL;