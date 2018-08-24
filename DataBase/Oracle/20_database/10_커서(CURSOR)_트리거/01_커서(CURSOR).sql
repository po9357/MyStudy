/********* CURSOR(Ŀ��) **************
�����ͺ��̽� Ŀ��(Cursor)�� �Ϸ��� �����Ϳ� ���������� �׼����� �� 
�˻� �� "���� ��ġ"�� �����ϴ� ������ ���

������Ŀ�� : SELECT, INSERT, UPDATE, DELETE ������ ����� ��
     DBMS�� CURSOR(Ŀ��)�� Open, Fetch, Close �ڵ� ó��
�����Ŀ�� : ���α׷������� ��������� Ŀ��(CURSOR)�� ������ ���

<Ŀ��(CURSOR) ��� ����>
1. ����(CURSOR Ŀ���� IS SELECT��)
2. Ŀ������(OPEN Ŀ����)
3. ����Ÿ����(FETCH Ŀ���� INTO)
4. Ŀ���ݱ�(CLOSE)
*************************************/
-- �ֹ����̺�(ORDERS)�� �ִ� ��ü �����͸� �����ͼ� ȭ�����
CREATE OR REPLACE PROCEDURE DISP_ORDERS 
AS
    -- 1.Ŀ�� ����
    CURSOR C_ORDERS IS 
    SELECT ORDERID, GET_CUSTNAME(CUSTID) CUSTNAME
           , GET_BOOKNAME(BOOKID) AS BOOKNAME
           , SALEPRICE, ORDERDATE
      FROM ORDERS
     ORDER BY ORDERID;
     
     -- ����� ���� ����
     V_ORDERID ORDERS.ORDERID%TYPE;
     V_CUSTNAME CUSTOMER.NAME%TYPE;
     V_BOOKNAME BOOK.BOOKNAME%TYPE;
     V_SALEPRICE ORDERS.SALEPRICE%TYPE;
     V_ORDERDATE ORDERS.ORDERDATE%TYPE;
BEGIN
    -- 2.Ŀ��(CURSOR) ����(OPEN)
    OPEN C_ORDERS;
    
    -- 3.������ ����(FETCH Ŀ���� INTO)
    LOOP 
        FETCH C_ORDERS
        INTO V_ORDERID, V_CUSTNAME, V_BOOKNAME, V_SALEPRICE, V_ORDERDATE;
        
        -- Ŀ���� �����Ͱ� ���� ��� �ݺ����� ���� ����
        EXIT WHEN C_ORDERS%NOTFOUND;    -- Ŀ������ �����͸� ã�� ���ϸ� ����
        
        -- Ŀ������ ������ ������ ȭ�� ���
        DBMS_OUTPUT.PUT_LINE(V_ORDERID||' '||V_CUSTNAME||' '||V_BOOKNAME||' '||V_SALEPRICE||' '||V_ORDERDATE);
    END LOOP;
    -- 4.Ŀ���ݱ�(CLOSE)
    CLOSE C_ORDERS;
END;

-----------------------
-- Ŀ�� ���� ���
CREATE OR REPLACE PROCEDURE DISP_ORDERS_SELECT AS 
    V_CNT NUMBER;
    I NUMBER;
     V_ORDERID ORDERS.ORDERID%TYPE;
     V_CUSTNAME CUSTOMER.NAME%TYPE;
     V_BOOKNAME BOOK.BOOKNAME%TYPE;
     V_SALEPRICE ORDERS.SALEPRICE%TYPE;
     V_ORDERDATE ORDERS.ORDERDATE%TYPE;
     V_RNO NUMBER;
BEGIN
  SELECT COUNT(*) INTO V_CNT
    FROM ORDERS;
    
    DBMS_OUTPUT.PUT_LINE('ORDERS ���̺� �Ǽ� : '||V_CNT);
    
    FOR I IN 1..V_CNT LOOP
        SELECT RNO, ORDERID, CUSTNAME, BOOKNAME, SALEPRICE, ORDERDATE
          INTO V_RNO, V_ORDERID, V_CUSTNAME, V_BOOKNAME, V_SALEPRICE, V_ORDERDATE
          FROM (SELECT ROWNUM AS RNO
                       , A.ORDERID
                       , GET_CUSTNAME(CUSTID) CUSTNAME
                       , GET_BOOKNAME(BOOKID) BOOKNAME
                       , A.SALEPRICE, A.ORDERDATE
                  FROM (SELECT * 
                          FROM ORDERS
                      ORDER BY SALEPRICE DESC) A  
        )
        WHERE RNO = I;
        
        DBMS_OUTPUT.PUT_LINE(V_RNO ||' '|| V_ORDERID ||' '|| V_CUSTNAME ||' '|| 
                V_BOOKNAME ||' '|| V_SALEPRICE ||' '|| V_ORDERDATE);
    END LOOP;
    
END;