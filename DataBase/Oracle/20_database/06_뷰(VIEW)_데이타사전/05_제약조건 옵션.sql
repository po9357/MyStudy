/*****************************************
�������� �ɼ�
CASCADE : �θ����̺��� �������� ��Ȱ��ȭ(����) ��Ű�鼭 �����ϰ� �ִ�
          �ڳ�(SUB)���̺��� �������Ǳ��� ��Ȱ��ȭ(����)
*****************************************/
-- �θ����̺� DEPT�� PK ��Ȱ��ȭ ��Ű�鼭 �ڳ����̺��� ��������(FK)�� ��Ȱ��ȭ
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE; -- CASCADE�� ������ �ڳ�鵵 ��� ��Ȱ��ȭ
ALTER TABLE EMP01 DISABLE CONSTRAINT EMP01_DEPTNO_FK;
-- DEPT ���̺��� PRIMARY KEY DISABLE ó���� ���
-- �ܷ�Ű ����� ���̺��� ���������� ��Ȱ��ȭ �� �Ŀ� ó��
ALTER TABLE DEPT DISABLE PRIMARY KEY;
ALTER TABLE DEPT ENABLE PRIMARY KEY;
-- �θ�� �ڽ� ��� ��Ȱ��ȭ �Ǹ�, �θ� ���� Ȱ��ȭ�� �Ǿ�� �ڽĵ� Ȱ��ȭ ����.
-- �ݴ�� CASCADE�� ������ �ڽĵ��� ��� ��Ȱ��ȭ �Ǿ�� �θ� ��Ȱ��ȭ ����
ALTER TABLE EMP01 DISABLE CONSTRAINT EMP01_DEPTNO_FK;
ALTER TABLE EMP02 DISABLE CONSTRAINT SYS_C007033;
ALTER TABLE EMP03 DISABLE CONSTRAINT EMP03_DEPTNO_FK;

ALTER TABLE EMP01 ENABLE CONSTRAINT EMP01_DEPTNO_FK;
ALTER TABLE EMP02 ENABLE CONSTRAINT SYS_C007033;
ALTER TABLE EMP03 ENABLE CONSTRAINT EMP03_DEPTNO_FK;

-- CASCADE �ɼ� ���
-- �ܷ�Ű ������ �ڳ����̺��� �ܷ�Ű ������ ���ÿ� ��Ȱ��ȭ �ϸ鼭
-- �θ� ���̺��� ���������� ��Ȱ��ȭ ó��(�ϰ��۾�)
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE;

-- 
CREATE TABLE C_TEST_MAIN (
    MAIN_PK NUMBER PRIMARY KEY,
    MAIN_DATE VARCHAR2(30)
);
CREATE TABLE C_TEST_SUB (
    SUB_PK NUMBER PRIMARY KEY,
    SUB_DATA VARCHAR2(30),
    SUB_FK NUMBER,
    CONSTRAINT C_TEST_SUB_FK FOREIGN KEY (SUB_FK)
    REFERENCES C_TEST_MAIN (MAIN_PK) ON DELETE CASCADE  -- ON DELETE CASCADE��
);                              -- �θ� ���̺��� PK�� �����Ǹ� PK�� ���� �����͸� ���� �ڽ����̺��� FK�� �Բ� ����
INSERT INTO C_TEST_MAIN VALUES (1111, '1��° ���� ������');
INSERT INTO C_TEST_MAIN VALUES (2222, '2��° ���� ������');
INSERT INTO C_TEST_MAIN VALUES (3333, '3��° ���� ������');
SELECT * FROM C_TEST_MAIN;
COMMIT;
----
INSERT INTO C_TEST_SUB VALUES (1, '1��° SUB ������', 1111);
INSERT INTO C_TEST_SUB VALUES (2, '2��° SUB ������', 2222);
INSERT INTO C_TEST_SUB VALUES (3, '3��° SUB ������', 3333);
INSERT INTO C_TEST_SUB VALUES (4, '4��° SUB ������', 3333);
SELECT * FROM C_TEST_SUB;
--------------
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 1111;
COMMIT;
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 3333;
-----------------------------------------
-- ���̺� ���� : �θ����̺� - �ڳ����̺� ���迡�� �θ����̺� ����
DROP TABLE C_TEST_MAIN;  -- 02449. 00000 -  "unique/primary keys in table referenced by foreign keys"
-- ���1 : �������̺� �ִ� FK ������ ��� ���� �� �θ����̺� ����
-- FK ��Ȱ��ȭ �������δ� �ȵ�. FK ����ó�� �ؾ���
ALTER TABLE C_TEST_SUB DROP CONSTRAINT C_TEST_SUB_FK;
DROP TABLE C_TEST_MAIN;

-- ���2 : �������̺��� ��� ���� �� �θ����̺� ����
DROP TABLE C_TEST_SUB;
DROP TABLE C_TEST_MAIN;

-- ���3 : �θ����̺� ������ CASCADE CONSTRAINTS �ɼ� ���
-- �������̺��� �������� ���� �� �������̺� ����ó�� 
DROP TABLE C_TEST_MAIN CASCADE CONSTRAINTS;


------------------- ����ð� -------------------
SELECT * FROM C_TEST_MAIN;
SELECT * FROM C_TEST_SUB;
-- ���� : ORA-02292: integrity constraint (MADANG.C_TEST_SUB_FK) violated - child record found
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 1111;       -- �ڽ� ���̺� FK ����
DELETE FROM C_TEST_SUB WHERE SUB_FK = 1111;         -- ���� �����͸� ���� FK ������ �θ����̺��� PK ���� ����
                                                    -- ON DELETE CASCADE�ɼ��� �ɾ�θ� PK������ �ڽ����̺��� FK�� ����
                                                    
ALTER TABLE C_TEST_MAIN DISABLE PRIMARY KEY;        -- �ڽ����̺��� FK�� Ȱ��ȭ�� ���¿��� �θ����̺� PK ��Ȱ��ȭ �Ұ�
ALTER TABLE C_TEST_SUB DISABLE CONSTRAINT C_TEST_SUB_FK;   

ALTER TABLE C_TEST_MAIN ENABLE PRIMARY KEY;         
ALTER TABLE C_TEST_SUB ENABLE CONSTRAINT C_TEST_SUB_FK; -- �θ����̺��� ��Ȱ��ȭ�� ���¿��� �ڽ����̺� FK Ȱ��ȭ �Ұ�