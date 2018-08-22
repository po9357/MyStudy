-- PL/SQL ���ν��� 

DECLARE -- ��������
    V_EMPID NUMBER;
    V_NAME VARCHAR2(30);
BEGIN   -- ���๮ �ۼ� ����
    V_EMPID := 100;     -- ġȯ�� ��ȣ :=
    V_NAME := 'ȫ�浿';
    
    DBMS_OUTPUT.PUT_LINE(V_EMPID ||':'||V_NAME);
    
END;    -- ���๮ �ۼ� ��

----------------------
DECLARE 
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN
    -- SELECT ~ INTO ~ FROM ����
    -- (�ٸ� ���̺��� �Ҿ�� ����� ��)
    -- SELECT INTO���� �������� �����Ͱ� 1�Ǹ� ���
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
      INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
      FROM BOOK
     WHERE BOOKID = 3;
     
    DBMS_OUTPUT.PUT_LINE(V_BOOKID ||':'||V_BOOKNAME||':'||V_PUBLISHER||':'||V_PRICE);
END;

------------------------------
-- ���� ���ν��� (STORED PROCEDURE)
-- �Ű����� ����
------- IN : �Է� �ޱ⸸ �ϴ� ����
------- OUT : ��¸� �ϴ� ����
------- IN OUT : �Է�, ��� �� �� �ִ� ����
CREATE OR REPLACE PROCEDURE BOOK_DISP
(   -- �Ű����� ����� : ()�ȿ� �ۼ�
    IN_BOOKID IN NUMBER
)
AS
    -- ���� �����
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN  
    -- ����� ����
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
      INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
      FROM BOOK
     WHERE BOOKID = IN_BOOKID;
    
    DBMS_OUTPUT.PUT_LINE(V_BOOKID ||':'||V_BOOKNAME||':'||V_PUBLISHER||':'||V_PRICE);
END;

--------------------------
-- ���ν��� ���� (EXECUTE)
EXECUTE BOOK_DISP(2);

-- ���ν����� ����
DROP PROCEDURE BOOK_DISP2;
--------------------------
-- GET_BOOKINFO ���ν����� ȣ���ؼ� OUT�� Ȯ��
CREATE OR REPLACE PROCEDURE GET_BOOKINFO_TEST 
(
    IN_BOOKID IN NUMBER
) AS 
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
    V_PUBLISHER BOOK.PUBLISHER%TYPE;
    V_PRICE BOOK.PRICE%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('�Է¹��� �� : '||IN_BOOKID);
    
    -- GET_BOOKINFO ���ν��� ����(ȣ��)
    GET_BOOKINFO(IN_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE);
    
    -- ���� ��(OUT) ȭ�� ���
    DBMS_OUTPUT.PUT_LINE('>>BOOKINFO_TEST ��� : '||IN_BOOKID||':'||V_BOOKNAME||':'||V_PUBLISHER||':'||V_PRICE);
END;

----------------------------------------
-- (�ǽ�) : �����̺�(CUSTOMER)�� �ִ� ������ ��ȸ ���ν��� �ۼ�
-- ���ν����� : GET_CUSTINFO
-- �Է¹޴� �� : ��ID��
-- ó�� : ȭ�鿡 �� ID, ����, �ּ�, ��ȭ��ȣ ���
CREATE OR REPLACE PROCEDURE GET_CUSTINFO (
    IN_CUSTID IN NUMBER,
    
    OUT_NAME OUT VARCHAR,
    OUT_ADDRESS OUT VARCHAR,
    OUT_PHONE OUT VARCHAR
    
) AS
    V_NAME CUSTOMER.NAME%TYPE;
    V_ADDRESS CUSTOMER.ADDRESS%TYPE;
    V_PHONE CUSTOMER.PHONE%TYPE;
BEGIN
    SELECT NAME, ADDRESS, PHONE
      INTO V_NAME, V_ADDRESS, V_PHONE
      FROM CUSTOMER
     WHERE CUSTID = IN_CUSTID;
     
     OUT_NAME := V_NAME;
     OUT_ADDRESS := V_ADDRESS;
     OUT_PHONE := V_PHONE;
    DBMS_OUTPUT.PUT_LINE(IN_CUSTID||' : '||V_NAME||' : '||V_ADDRESS||' : '||V_PHONE);
END;

EXECUTE GET_CUSTINFO(3);
CREATE OR REPLACE PROCEDURE GET_CUSTINFO_TEST (
    IN_CUSTID IN NUMBER
) AS
    V_NAME CUSTOMER.NAME%TYPE;
    V_ADDRESS CUSTOMER.ADDRESS%TYPE;
    V_PHONE CUSTOMER.PHONE%TYPE;
BEGIN
    GET_CUSTINFO(V_NAME, V_ADDRESS, V_PHONE);
    
    DBMS_OUTPUT.PUT_LINE(V_NAME||' '||V_ADDRESS||' '||V_PHONE);
END;