/********** �Լ�(FUNCTION) ***********
RETURN ������ ����(Ÿ��)   -- ���� �ʿ�
RETURN ���ϰ�;     -- ���� ������ �� ����
*************************************/
-- �Ķ���� ������ BOOKID�� �����ϰ�, å����(BOOKNAME)�� �����޴� �Լ�
CREATE OR REPLACE FUNCTION GET_BOOKNAME (
    IN_ID NUMBER        -- �Ű������� ������ IN, ���� �ʿ� ����
) RETURN VARCHAR2       -- ������ ������ Ÿ��
AS
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
BEGIN
    SELECT BOOKNAME INTO V_BOOKNAME
      FROM BOOK
     WHERE BOOKID = IN_ID;
     
    RETURN V_BOOKNAME;  -- ���ϰ� ����
END;

-----------------------------------
-- �Լ��� ���
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID)
  FROM BOOK;

SELECT * FROM BOOK
 WHERE GET_BOOKNAME(BOOKID) = '�౸�� ����';
-----------------------------------
-- (�ǽ�)�� ID���� �����ϰ�, ������ �������� �Լ�
-- �Լ��� : GET_CUSTNAME
-- CUSTOMER ���̺� ����

CREATE OR REPLACE FUNCTION GET_CUSTNAME (
    IN_ID NUMBER
) RETURN VARCHAR2
AS
    V_NAME CUSTOMER.NAME%TYPE;
BEGIN
    SELECT NAME INTO V_NAME
      FROM CUSTOMER
     WHERE CUSTID = IN_ID;
     
     RETURN V_NAME;
END;

SELECT CUSTID, NAME, GET_CUSTNAME(CUSTID) FROM CUSTOMER;
SELECT GET_CUSTNAME(2) FROM DUAL;

SELECT ORDERID
     , CUSTID, GET_CUSTNAME(CUSTID) AS CUST_NAME
     , BOOKID, GET_BOOKNAME(BOOKID) AS BOOKNAME
     , SALEPRICE, ORDERDATE
  FROM ORDERS
;