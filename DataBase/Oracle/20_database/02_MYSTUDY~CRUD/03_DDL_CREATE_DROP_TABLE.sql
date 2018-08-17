--  =========================================================
/* (�ǽ�) ���̺�� : TEST2
        NO : ����Ÿ�� 5�ڸ�, PRIMARY KEY ����
        ID : ����Ÿ�� 10�ڸ� (���� 10�ڸ�), ���� �ݵ�� ����
        NAME : �ѱ� 10�ڸ� ���� ������� ����, ���� �ݵ�� ����
        EMAIL : ����, ����, Ư������ ���� 30�ڸ�
        ADDRESS : �ѱ� 100�ڸ�
        IDNUM : ����Ÿ�� ������ 7�ڸ�, �Ҽ��� 3�ڸ� EX) 1234567.789
        REGDATE : ��¥Ÿ��
**********************************/
CREATE TABLE TEST2 (
        NO NUMBER (5, 0) PRIMARY KEY,       --PRIMARY KEY�� ���̺� 1���� ������ �� �ִ�.
        ID VARCHAR2(10) NOT NULL,
        NAME VARCHAR2(30) NOT NULL,
        EMAIL VARCHAR2(30),
        ADDRESS VARCHAR2(300),
        IDNUM NUMBER (10, 3),
        REGDATE DATE
) ;
INSERT INTO TEST2 VALUES (12345, 20180001, 'ȫ�浿', 'po9357@naver.com', '������ ������ 382-3 201ȣ', 1234567.8908, SYSDATE);
SELECT * FROM TEST2;
UPDATE TEST2 SET NO = 56789 WHERE NAME = 'ȫ�浿';
INSERT INTO TEST2 (NO, ID, NAME)
    VALUES (47895, '7895133801', '�����ٶ󸶹ٻ������');
DELETE TEST2 WHERE IDNUM IS NULL;
DELETE TEST2 WHERE NO = 12345;

INSERT INTO TEST2
    VALUES (11111, 'TEST1', 'ȫ�浿1', 'test@test.com', '����� ���α�', 1234567.6789, SYSDATE);
INSERT INTO TEST2
    VALUES (22222, 'TEST2', 'ȫ�浿2', 'test@test.com', '����� ���α�', 1234567.6789, SYSDATE);
SELECT * FROM TEST2;
INSERT  INTO TEST2 (NO, ID, NAME)
    VALUES (11, 'TEST3', 'ȫ�浿11');
--  ���� Ÿ��(NUMBER, NUMBERIC ��)�� ������ ����
--  ���� Ÿ��(VARCHAR2, CHAR, DATE ��)�� ���� ����
--------------------------------------------------------------------------------------------------------------------
DELETE FROM TEST2 WHERE ID = 'TEST3';
                                             --  ���̺� ��ü ������ ����
DELETE FROM TEST2;                               --��ü ������ ����
                                             -- DELETE FROM ��ɾ �̿��ϸ� ROLLBACK ��� ���� (�� COMMIT �������� ���ư�)
TRUNCATE TABLE TEST2;                          --ROLLBACK �Ұ�. �����͸� �߶�.
ROLLBACK;
                                            --  DROP TABLE ���� ���̺��� ������ �����͸� �Բ� ����ó��
DROP TABLE TEST2;                                 --���̺� ��ü ��ü�� ���� ó��
--  =================================================================================================================
SELECT * FROM TEST2;

--  Ư�� ���̺��� �����Ϳ� ���̺� ������ �Բ� ����
--  TEST2   ->  TEST3
CREATE TABLE TEST3                          --  TEST2�� TEST3�� ����
    AS SELECT * FROM TEST2;
SELECT * FROM TEST3;
SELECT * FROM TEST2;
--  NOT NULL ������ ����.  PRIMARY KEY ������ �������� ����.

----------------------------------------
--  Ư�� ���̺��� ������ ����
--  TEST2   ->  TEST4 : �����ʹ� ���� ����
CREATE TABLE TEST4
    AS SELECT * FROM TEST2 WHERE 1  =   2;              
                                                            --  �Ϻη� FALSE���� �־� ���̺��� �÷� ������ ����
SELECT * FROM TEST4;


--  =================================================================================================================
/****   ���̺��� �÷� �߰�, ����, ����
DDL : ALTER TABLE
-   ADD : �߰�
-   MODIFY : ����
         --  �÷� ������ ����  ->  ū : ������ ����
         --  �÷� ������ ū  ->  ���� : ������ ���¿� ���� �ٸ�
-   DROP COLUMN : ����
**********************************/
--  DROP TABLE TEST4;       ���̺� ��ü ����
--  �÷� �߰�   TEST3 ���̺� ADDCOL �÷� �߰�
SELECT * FROM TEST3;
ALTER TABLE TEST3 ADD ADDCOL VARCHAR2(10); 

--  �÷� ���� TEST3 ���̺��� ADDCOL  ->  VARCHAR2(20)
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(20);
UPDATE TEST3 SET ADDCOL = '123456789012345';
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(15);
                                                            --  �����߻� : ����� ������ ���� �۰� �÷��� ũ�� ����
ALTER TABLE TEST3 MODIFY ADDCOL VARCHAR2(10);       --  �������� ���̰� 15�̱� ������ �� �Ʒ��� ���� �Ұ�

--  �÷��� ����
ALTER TABLE TEST3 DROP COLUMN ADDCOL;                   --  �������� ������ ��� ���� �ش� �÷� ����