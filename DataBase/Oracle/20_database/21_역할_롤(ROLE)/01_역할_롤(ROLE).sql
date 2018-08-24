/*********** ����(ROLE) ******************
����(��, ROLE) : DB ��ü �� �ý��ۿ� ���� ������ ��Ƶ� ������ �ǹ�
���� ���� : CREATE ROLE �����̸�
���� ���� : DROP ROLE �����̸�
���ҿ� ���� �ο� : GRANT ���� [ON ��ü] TO �����̸�
������ ���� ȸ�� : REVOKE ���� [ON ��ü] FROM �����̸�
����ڿ��� ���� �ο� : GRANT �����̸� TO �����

<���� �������� ����� �߰������� �ܰ�>
CREATE ROLE - ���һ���
GRANT - ������� ���ҿ� ���� �ο�
GRANT - ����ڿ��� ���� �ο�
-->>���� ������ ��� �ݴ�� ����
DROP ROLE - ���� ����(����ڿ��� �ο��� ���ҿ� ���� ���� ���� ���ŵ�)
************************************/
-- (�� ���� SYSTEM ����) 'PROGRAMMER'��� ����(��, ROLE) ����
CREATE ROLE PROGRAMMER;

-- (SYSTEM ����) PROGRAMMER �ѿ� ���̺�, ��(VIEW) ���� ���� �ο�
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;

-- (SYSTEM ����) MDGUEST �������� PROGRAMMER �� �ο�
GRANT PROGRAMMER TO MDGUEST;
--
CREATE TABLE MDGUEST2.NEWTABLE (
    NAME VARCHAR2(30),
    PHONE VARCHAR2(30)
);
SELECT * FROM MDGUEST2.NEWTABLE;        -- ���̺� ���� ������ ������,
INSERT INTO MDGUEST2.NEWTABLE           -- ���̺� SELECT, INSERT���� ������ ����
    VALUES ('�ڼ���', '000-0000-0000');
--
-- ���� ȸ��, ���
REVOKE PROGRAMMER FROM MDGUEST;