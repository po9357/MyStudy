SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
----------------------------
--  �������� ������ �ݾ� �հ�
SELECT NAME, CUSTID FROM CUSTOMER WHERE NAME = '������';
SELECT '������', SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = '1';
--  ��Ī�� ���̷��� '������' ���� ����� �׳�, AS NAME�� ���� NAME�÷��� �ҷ��� (AS ���� ����)
 --------------------------------------------------------------
 -- �������� (subquery) ���
SELECT CUSTID FROM CUSTOMER WHERE NAME = '������';
SELECT * FROM ORDERS
    WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '������');
                                    --  ���� ����, �κ� ���� 
---------------------------------------------------------------
--  ���� (join) ���
SELECT *
    FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
ORDER BY CUSTOMER.CUSTID;

SELECT CUSTOMER.CUSTID, CUSTOMER.NAME,
             ORDERS.CUSTID ORD_CUSTID, ORDERS.SALEPRICE
   FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
     AND CUSTOMER.NAME = '������'
ORDER BY CUSTOMER.CUSTID;

SELECT * FROM ORDERS, CUSTOMER WHERE CUSTOMER.CUSTID = ORDERS.CUSTID AND CUSTOMER.NAME = '������';
SELECT SUM (SALEPRICE) FROM ORDERS, CUSTOMER WHERE CUSTOMER.CUSTID = ORDERS.CUSTID AND CUSTOMER.NAME = '������';
----------------------------------------------------------------
SELECT CUSTOMER.CUSTID, CUSTOMER.NAME, CUSTOMER.ADDRESS,
                ORDERS.SALEPRICE, ORDERS.ORDERDATE
 FROM CUSTOMER, ORDERS
 WHERE CUSTOMER.CUSTID = ORDERS.CUSTID      --  �������� ( ���̺� ���ս� ��� )
 AND CUSTOMER.NAME = '������'                             --  �˻� ���� ( WHERE )
 ;
                                                --      �ߺ����� �ʴ� �÷��� ���̺��� ���������� �ʾƵ� �ȴ�.
 SELECT CUSTOMER.CUSTID, NAME, ADDRESS,
                SALEPRICE, ORDERDATE
 FROM CUSTOMER, ORDERS                                   --  ���� ������ ��� ���
 WHERE CUSTOMER.CUSTID = ORDERS.CUSTID      --  ���� ��� ���̺� �ִ� �÷����� �� �� ������,
 AND NAME = '������'                                                --  �Ʒ��� �÷��� ��� ���̺� �ִ��� �� �� ����.
 ;
----------------------------------------------------------------
--  ��Ī (alias) ������� �ܼ�ȭ
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE,
                O.SALEPRICE, O.ORDERDATE
 FROM CUSTOMER C, ORDERS O                          --  ��Ī�� ���� ( FROM ������ )
 WHERE C.CUSTID = O.CUSTID
 AND C.NAME = '������'
 ;
 ---------------------------------------------------------------
 SELECT B.BOOKID, BOOKNAME, B.PRICE, O.SALEPRICE, O.ORDERDATE FROM BOOK B, ORDERS O WHERE B.BOOKID = O.BOOKID ORDER BY O.ORDERDATE;
 ---------------------------------------------------------------
 //////////////////////////////////////////////////////////////////////////////////////////////
 -- ���� : ���� ������ ������� �ʴ� ��� ( īƼ�ǰ� catesian product )
 -- ���� ��� ���̺��� �� �����ͰǼ� * �����ͰǼ� ��� �߻�
 --                                                        �ߺ����� �ʴ� ��� ������ ���
 SELECT * 
    FROM BOOK B, ORDERS O 
ORDER BY B.BOOKID, O.ORDERID;
------------------
--  ���� : 3���� ���̺� ����
SELECT O.CUSTID, B.BOOKID, PUBLISHER, BOOKNAME, SALEPRICE, NAME 
    FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID   --  O = B ����
    AND O.CUSTID = C. CUSTID;   --  O = C ����
--  ����, ������ å ����, ���԰���, ��������, ���ǻ��
SELECT NAME, BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND O.BOOKID = B.BOOKID;
---------------------
--  ��̶��� ������ å����, ���԰���, ��������, ���ǻ�
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE, PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
    AND O.BOOKID = B.BOOKID
    AND NAME = '��̶�'
;
--------------------
--  ��̶��� ������ å �߿� 2014-01-01 ~ 2014-07-08���� �ڷ�
SELECT NAME, BOOKNAME, SALEPRICE, ORDERDATE, PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
    AND O.BOOKID = B.BOOKID
    AND NAME = '��̶�'
    AND ORDERDATE BETWEEN TO_DATE('2014/01/01', 'YYYY/MM/DD') 
                                        AND TO_DATE('2014/07/08', 'YYYY/MM/DD')
;
-- ===============================================
--(�����ذ�) ���̺� ������ ���ؼ� �����ذ�(�ȵǸ� ���� SELECT������ �ܰ�������)
--�ǽ� : '�߱��� ��Ź��'��� å�� �� ���� �ȷȴ��� Ȯ�����ּ���.
--�ǽ� : '�߱��� ��Ź��'��� å�� �ȸ� ��¥�� ���ϼ���
--�ǽ� : '�߱��� ��Ź��'��� å(BOOK)�� ������(ORDERS) ���(CUSTOMER)�� �������� Ȯ��
--�ǽ� : '�߽ż�'�� ������ å���� �������� Ȯ��
--�ǽ� : '�߽ż�'�� ������ å���� �հ�ݾ� ���ϼ���
--�ǽ� : '�߱��� ��Ź��'��� å(BOOK)�� ������(ORDERS) ���(CUSTOMER)�� �������ڸ� ���ϼ���.
--�ǽ� : '�߽ż�', '��̶�'�� ������ å�� ���Աݾ�, �������ڸ� Ȯ��
--------------------------------------------------
SELECT BOOKNAME å_�̸�, COUNT(*) �Ǹ��հ�, SUM (SALEPRICE) ��_�ݾ� 
   FROM ORDERS O, BOOK B 
 WHERE O.BOOKID = B.BOOKID AND B.BOOKNAME = '�߱��� ��Ź��' 
 GROUP BY BOOKNAME;
SELECT B.BOOKNAME ����, C.NAME ������,  O.ORDERDATE ���Գ�¥ FROM ORDERS O ,CUSTOMER C, BOOK B
WHERE O.CUSTID = C.CUSTID
       AND O.BOOKID = B.BOOKID
       AND B.BOOKNAME = '�߱��� ��Ź��';
SELECT NAME ������, O.SALEPRICE ���԰���, O.ORDERDATE �������� FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID AND C.NAME = '�߽ż�';
SELECT '�߽ż�', SUM (SALEPRICE) FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID AND C.NAME = '�߽ż�' GROUP BY NAME;
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE 
  FROM ORDERS O, BOOK B, CUSTOMER C 
WHERE O.CUSTID = C.CUSTID 
       AND O.BOOKID = B.BOOKID 
       AND C.NAME IN('�߽ż�', '��̶�') 
ORDER BY C.NAME, O.ORDERDATE;
SELECT NAME, SUM(SALEPRICE) FROM ORDERS O, CUSTOMER C WHERE O.CUSTID = C.CUSTID GROUP BY NAME;
--======================================================
--  �� �̸��� �����͸� ��Ƽ� �հ�
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

