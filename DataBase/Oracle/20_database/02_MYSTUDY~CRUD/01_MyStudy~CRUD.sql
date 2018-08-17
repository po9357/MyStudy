SELECT * FROM STUDENT;
--������ �߰� : ������ �Է�(INSERT)
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH) 
VALUES ('2018001', 'ȫ�浿', 100, 90, 80) ;

COMMIT; --COMMIT : ������ Ȯ�� ����

ROLLBACK; --���� Ŀ�� �������� �ѹ�

INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018002', '������', 95, 90, 80);
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018002', '������', 70, 90, 80);
COMMIT;
---------------
SELECT * FROM STUDENT;
-----------------------------------
--���� : ������ ���� (UPDATE)
--������ �������� : 80 -> 88 ����
SELECT * FROM STUDENT WHERE NAME = '������' ;
UPDATE STUDENT
    SET KOR = 90, MATH = 88, ENG = 77               --WHERE ������ ���� ������ �⺻������ ��ü �����͸� ����
    WHERE NAME = '������';     --UPDATE, DELETE ��ɾ�� �⺻������ WHERE�� �ٴ´� ���� (���� ����)
COMMIT;
UPDATE STUDENT 
    SET ID = 2018003
    WHERE NAME = '������';
------------------------------------------------------------------------
--������ -> �������� �̸� ����
SELECT * FROM STUDENT;
UPDATE STUDENT
    SET NAME = '��������'
WHERE ID = '2018002' ;                    --�ߺ��� �����͸� ��� �ٲ� �� �����Ƿ�, ID���� ���� �ߺ����� �ʴ� ������ ����� �����ϴ°��� ����
--  =, >, <, >=, <=, !=, <> ��� ��� ����
INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)
VALUES ('2018004', '������', 90, 90, 90);

SELECT * FROM STUDENT
ORDER by id;
COMMIT;
--------------------------------------
--���� : ������ ���� (DELETE)
SELECT * FROM STUDENT WHERE NAME = '������';
DELETE FROM STUDENT WHERE NAME = '������' ;
COMMIT;
DELETE STUDENT WHERE NAME = '������' ;             --FROM�� ���� �����ϳ� �����ϸ� ����Ұ�
-----------------------------------------------------------------
--SELECT �÷�, .., .. FROM ���̺� WHERE ...;
--INSERT INTO ���̺� (.., .., ..) VALUES (.., .., ..) ;
--UPDATE ���̺� SET �÷� = ��, �÷� = ��, ... , �÷� = �� WHERE ...;
--DELETE FROM ���̺� WHERE ...;
