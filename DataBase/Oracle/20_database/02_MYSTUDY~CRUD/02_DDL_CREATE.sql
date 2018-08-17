/************************************************************
������ ���Ǿ�
-   DDL (Data Dfinition Language) : �����͸� �����ϴ� ���
-   CREATE (����), DROP (����), ALTER(����)
-   { } �ݺ� ����, [ ] ���� ����, | �Ǵ� (����)
CREATE TABLE ���̺�� (
{�÷��� ������Ÿ��                                       
       [ NOT NULL | UNIQUE | DEFAULT �⺻�� | CHECK üũ���� ]        
}
    [ PRIMARY KEY �÷��� ]                                                                                                     
    { [FOREIGN KEY �÷��� REFERENCES ���̺�� (�÷���) ]
    [ ON DELETE [CASCADE | SET NULL]
    }                                                                                                       
) ;
-----------------
�÷��� �⺻ ������ Ÿ��
VARCHAR2 (n) : ���ڿ� ��������
CHAR (n) : ���ڿ� ��������
NUMBER (p, s) : ����Ÿ�� p : ��ü����, s : �Ҽ��� ���� �ڸ���
    ��)  (5, 2) : ������ 3�ڸ�, �Ҽ��� 2�ڸ�   -   ��ü 5�ڸ�
DATE : ��¥�� ��, ��, �� �ð� �� ����

���ڿ� ó�� : UTF-8 ���·� ����
-   ����, ���ĺ�, Ư������ : 1  byte ó��(Ű���� ���� ���ڵ�)
-   �ѱ� : 3  byte ó��
************************************************************/
CREATE TABLE MEMBER (
    ID VARCHAR2 (20) PRIMARY KEY,
    NAME VARCHAR2 (30) NOT NULL,
    PASSWORD VARCHAR2 (20) NOT NULL,
    PHONE VARCHAR2 (20),
    ADDRESS VARCHAR2 (200)
) ;
INSERT INTO MEMBER 
            (ID, NAME, PASSWORD)
VALUES ('hong', 'ȫ�浿', '1234');
SELECT * FROM MEMBER ;
COMMIT;
INSERT INTO MEMBER
            (ID, NAME, PASSWORD)
VALUES ('hong2', 'ȫ�浿', '1234') ;
---
INSERT INTO MEMBER
            (ID, NAME)
VALUES ('hong3', 'ȫ�浿3') ;      --cannot insert NULL into ("MYSTUDY"."MEMBER"."PASSWORD")

------
INSERT INTO MEMBER
            (ID, NAME, PASSWORD)
VALUES ('hong4', 'ȫ�浿4', 1234) ;
-------------------------------------
SELECT * FROM MEMBER;
--�÷��� ��������� ���� �ʰ� INSERT �� ����
--���̺� �ִ� ��� �÷��� ���Ͽ� ������� ������ �Է��ؾ� ��
INSERT INTO MEMBER
VALUES ('hong5', 'ȫ�浿', '1234', '010-1111-1111', '�����') ;
COMMIT;
INSERT INTO MEMBER (ID, NAME, PASSWORD, PHONE, ADDRESS)
VALUES ('hong6', 'ȫ�浿5', '1234', '�����', '010-1111-1111') ;
UPDATE MEMBER SET NAME = 'ȫ�浿5' WHERE ID = 'hong5';
UPDATE MEMBER SET NAME = 'ȫ�浿6' WHERE ID = 'hong6';
INSERT INTO MEMBER (ID, NAME, PASSWORD, ADDRESS, PHONE)
VALUES ('hong7', 'ȫ�浿7', '1234', '�����', '010-1234-5678');


-----------------------------------------
--�÷� Ư���� Ȯ���ϱ� ���� ���̺�
CREATE TABLE TEST (
        NUM NUMBER (5,2),    --��ü �ڸ��� 5, ������ 3, �Ҽ��� 2
        STR1 CHAR(10),          --��������
        STR2 VARCHAR(10),    -- ��������
        DATE1 DATE                  
);
INSERT INTO TEST VALUES (100.456, 'ABC', 'ABC', SYSDATE) ;
INSERT INTO TEST VALUES (100.454, 'ABC', 'ABC', SYSDATE) ;
INSERT INTO TEST VALUES (100.454, 'DEF', 'DEF  ', SYSDATE) ;
SELECT TO_CHAR (SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT * FROM TEST;
SELECT '-' || STR1 || '-', '-' || STR2 || '-' FROM TEST;
--STR1�� CHAR Ÿ�� (��������) �� ������ ä���� �� '-'�� ��
--STR2�� VARCHAR Ÿ�� (��������) �� ������ ä������ ����.
--'DEF  '�� ��� '  '�����̽� (�� ����)�� ���� ����� �ȴ� (VARCHAR Ÿ��)
--------------------
SELECT * FROM TEST WHERE STR1 = STR2;    --��ȸ�� ������ ����
SELECT * FROM TEST WHERE STR1 = 'ABC';     --����Ŭ������ ��ȸ �� (�� ���ڿ��� �� ������ ��ȸ ����)
--'ABC' ���ڿ� ��  'ABC       '
SELECT * FROM TEST WHERE STR1 = 'ABC       ';   --��� DB ����
-------------
SELECT * FROM TEST WHERE NUM = 100.45;      --NUMBER = NUMBER
SELECT * FROM TEST WHERE NUM = '100.45';      --NUMBER = VARCHAR (CHAR) ��ȸ ����(����Ŭ������)
SELECT * FROM TEST WHERE NUM = '100.45A';   --�翬�� ��ȸ �ȵ� (CHAR Ȥ�� VARCHARŸ�Կ��� NUMBERŸ������ �ٲ� �� ����)
----
INSERT INTO TEST (STR1, STR2)
VALUES ('1234567890', '1234567890');
SELECT * FROM TEST;
SELECT * FROM TEST WHERE STR1 = STR2;       --STR1 �� STR2 ��� 10�ڸ� (CHAR(10)�� VARCHAR(10))
SELECT '-' || STR1 || '-', '-' || STR2 || '-' FROM TEST;
----------------------------------------------
--UTF-8 Ÿ������ ������ ����
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', 'ABCDEFGHIJ');      
-- 1234567890�� �������� ����� ���� (UTF-8 Ÿ���� ����, ���ĺ� ��� 1����Ʈ)
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '���ѹα�');
--  ABCDEFGHIJ = 10����Ʈ          ���ѹα�  =  12����Ʈ (UTF-8 Ÿ�Կ��� �ѱ��� ���ڴ� 3 ����Ʈ)
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', 'ȫ�浿');
COMMIT;
--  ===================================================================================
--  NULL (��) : �� ���ڿ�('')�� �ƴϰ�, Ư�� ���� �ƴ� �����Ͱ� ���� ����
--  NULL�� ��ó���� �ȵ�  :  =, <>, >, <, >=, <= ��ó���� �ǹ� ����
--  NULL ���� ���� ����� �׻� NULL(���� �ǹ� ����)
--  NULL ���� ���� ��ȸ�� IS NULL, IS NOT NULL �������� ��ȸ
--------------------------------
SELECT * FROM TEST WHERE NUM = NULL;                --��ȸ ������ ����
SELECT * FROM TEST WHERE NUM IS NULL;
SELECT * FROM TEST WHERE NUM <> NULL;              --��ȸ �ȵ�
SELECT * FROM TEST WHERE NUM IS NOT NULL;
--NULL���� ���õ� �����͸� ��ȸ�ϰ� ���� ���� IS NULL Ȥ�� IS NOT NULL�� ��ȸ
--NULL ���� ���� ���
SELECT NUM + 10 FROM TEST;
SELECT NUM + NULL FROM TEST;          -- NULL���� ���� ����� ��� NULL
--� �÷� ���� ������ ���� �� NULL�� ���ԵǾ� ������ �ش� �ο�� ��� ���� NULL�� ��. (����)
--���Ľ� NULL
SELECT * FROM TEST ORDER BY STR1;               --ASC (�������� ����) Ű���� ����
SELECT * FROM TEST ORDER BY STR1 DESC;     --DESC (�������� ����)
--����Ŭ������ �⺻ NULL ���� ���� ū ������ ���� ó�� (�� ������ ����)
SELECT * FROM TEST ORDER BY NUM;
SELECT * FROM TEST ORDER BY NUM DESC;
--NULL ���� ���� ���� ó�� : NULLS FIRST, NULLS LAST 
SELECT * FROM TEST ORDER BY NUM NULLS FIRST;    --NULL���� �� ó�� ǥ��
SELECT * FROM TEST ORDER BY NUM DESC NULLS LAST;

--
SELECT NUM FROM TEST;
--�����Լ� NVL (�÷�, ������)    �÷��� NULL�̸� ���������� ��ȯ
SELECT NUM, NUM + 10, NVL (NUM, 0) + 100 FROM TEST;
----------------------------
SELECT * FROM TEST;
INSERT INTO TEST (NUM, STR1, STR2) VALUES (200, '', NULL);
SELECT * FROM TEST WHERE STR1 = '';
SELECT STR1, STR1 || '-�׽�Ʈ',
            NVL (STR1, '�������') || '-�׽�Ʈ'
FROM TEST;
