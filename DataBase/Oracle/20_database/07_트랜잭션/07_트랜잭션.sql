/***** Ʈ�����(TRANSACTION) *******
Ʈ�����(TRANSACTION) : DBMS���� ����Ÿ�� �ٷ�� ������ �۾��� ����

<Ʈ������� ����>
COMMIT : �۾� ������ DB�� �ݿ��ϰ� Ʈ����� ����

<Ʈ����� �Ϻ� �Ǵ� ��ü ��ȿȭ>
ROLLBACK; --���� COMMIT �������� ��� ���
ROLLBACK TO ���̺�����Ʈ�̸�; --���̺� ����Ʈ ��ġ���� ���

<���̺�����Ʈ ����>
SAVEPOINT ���̺�����Ʈ�̸�;
**********************************/
SELECT * FROM DEPT;
SELECT * FROM DEPT1;
INSERT INTO DEPT1 VALUES ('40', '�λ��');
COMMIT;         -- ���������� SAVEPOINT ������
-- DEPT1 ���̺��� ID : 40 ������ ����
DELETE FROM DEPT1 WHERE ID = '40';

-- ���̺�����Ʈ ���� : S1 
SAVEPOINT S1;

-->> ���� ID : 20
DELETE FROM DEPT1 WHERE ID = '20';
SELECT * FROM DEPT1;

-- ���̺�����Ʈ ���� : S2
SAVEPOINT S2;

-->> ���� ID : 10
DELETE FROM DEPT1 WHERE ID = '10';
--------------------
-- Ʈ����� �ǵ����� (ROLLBACK)
-- ROLLBACK;                -- ���� COMMIT �������� �ǵ�����
-- ROLLBACK ���̺�����Ʈ;     -- ���̺�����Ʈ �������� ROLLBACK
SELECT * FROM DEPT1;

-- S2���� ROLLBACK
ROLLBACK TO S2;
SELECT * FROM DEPT1;        -- 10 �ѹ���    ������

-- S1���� ROLLBACK
ROLLBACK TO S1;
SELECT * FROM DEPT1;        -- 20 �޿���    ������

-- ���� COMMIT �������� ROLLBACK
ROLLBACK;
SELECT * FROM DEPT1;        -- 40 �λ��    ������