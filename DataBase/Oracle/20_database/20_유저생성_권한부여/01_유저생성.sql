/******* ����� ����, ���� **********
�����(DB)���� : CREATE USER
CREATE USER [������̸�] 
IDENTIFIED BY [��й�ȣ]
DEFALUT TABLESPACE [���̺����̽�];
--DEFALUT TABLESPACE �������� ������ ����Ŭ SYSTEM ����

����ڼ��� : ALTER USER - ��й�ȣ �����
ALTER USER ������̸� INDENTIFIED BY ��й�ȣ;

����ڻ��� : DROP USER
DROP USER ������̸� [CASCADE];
--CASCADE : ���������� ����ڰ� ������ ��� ����Ÿ�� ���� ����ó��
**********************************/

-- (�����ڰ��� SYSTEM���� �۾�) ���� ����
CREATE USER MDGUEST  IDENTIFIED BY "mdguest";
CREATE USER mdguest2 IDENTIFIED BY "mdguest2"
DEFAULT TABLESPACE USERS;

-- ���Ѻο�
GRANT CONNECT, RESOURCE TO MDGUEST;
GRANT CONNECT, RESOURCE TO MDGUEST2;

/****** ���� �ο�(GRANT), ���� ���(REVOKE) **********************
GRANT ���� [ON ��ü] TO {�����|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC�� ��� ����ڿ��� ������ �ǹ�

GRANT ���� TO �����; --������ ����ڿ��� �ο�
GRANT ���� ON ��ü TO �����; -��ü�� ���� ������ ����ڿ��� �ο�
-->> WITH GRANT OPTION :��ü�� ���� ������ ����ڿ��� �ο� 
-- ������ ���� ����ڰ� �ٸ� ����ڿ��� ���Ѻο��� �Ǹ� ����
GRANT ���� ON ��ü TO ����� WITH GRANT OPTION;
----------------------------
-->>>���� ���(REVOKE)
REVOKE ���� [ON ��ü] FROM {�����|ROLE|PUBLIC,.., n} CASCADE
--CASCADE�� ����ڰ� �ٸ� ����ڿ��� �ο��� ���ѱ��� ��ҽ�Ŵ
  (Ȯ�� �� ���� �� �۾�)

REVOKE ���� FROM �����; --������ ����ڿ��� �ο�
REVOKE ���� ON ��ü FROM �����; -��ü�� ���� ������ ����ڿ��� �ο�
*************************************************/

-- MADANG ������ ���(MADANG ������ ���� ����)
GRANT SELECT ON MADANG.BOOK TO MDGUEST;

REVOKE SELECT ON MADANG.BOOK FROM MDGUEST;
----------------------
-- MADANG.CUSTOMER ���̺� ���Ͽ� MDGUEST ��������
----------- SELECT, UPDATE ���� �ο�
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST;

SELECT * FROM MADANG.CUSTOMER;
UPDATE MADANG.CUSTOMER
   SET PHONE = '010-1111-1111'
 WHERE NAME = '�ڼ���'
;

-- SQL ����: ORA-01031: insufficient privileges
DELETE FROM MADANG.CUSTOMER    -- ���� ������ ������
 WHERE NAME = '�ڼ���'          -- ���� ������ ���� ���� �Ұ�
;

-- ORA-00942: table or view does not exist
SELECT * FROM MADANG.BOOK;      -- SELECT ������ ����
--------------------------------------------
-- WITH GRANT OPTION : �ٸ� �������� ���� �ο��� �� �ֵ��� ���� �ο�
GRANT SELECT, UPDATE ON MADANG.BOOK TO MDGUEST
WITH GRANT OPTION;
--
GRANT SELECT, UPDATE ON MADANG.BOOK TO MDGUEST2;
--------------------------
-- ���� ȸ�� REVOKE
REVOKE SELECT, UPDATE ON MADANG.BOOK FROM MDGUEST;