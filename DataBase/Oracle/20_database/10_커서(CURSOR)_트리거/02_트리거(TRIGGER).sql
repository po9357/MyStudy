/********** Ʈ����(TRIGGER) ******************
Ʈ����(TRIGGER) : Ư�� �̺�Ʈ�� DDL, DML ������ ����Ǿ��� ��,
   �ڵ������� � �Ϸ��� ����(Operation)�̳� ó���� �����ϵ��� �ϴ�
   ����Ÿ���̽� ��ü�� �ϳ�
  - �ι������� ������ ���̺� ����Ÿ�� �߰�(NSERT), ����(DELETE), ����(UPDATE) �� ��,
    �ٸ� ���� ���迡 �ִ� ���̺��� ����Ÿ�� �ڵ������� ������ ��쿡 ���

CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ�
  BEFORE [OR AFTER]
  UPDATE [OR DELETE OR INSERT] ON ���̺��
  [FOR EACH ROW]
DECLARE
  ���������;
BEGIN
  ���α׷� ���� ������;
END;  
-------------------------------
<Ʈ���� ����ñ� ����>
BEFORE : ������ ó���� ����Ǳ� �� ����(INSERT, UPDATE, DELETE �� ������)
AFTER : ������ ó���� ����� �� ����(INSERT, UPDATE, DELETE �� ������)

�̺�Ʈ ���� ���� : INSERT, UPDATE, DELETE
�̺�Ʈ �߻� ���̺� ���� : ON ���̺��

<ó������ ����>
FOR EACH ROW : ����Ÿ ó���� �ǰ��� Ʈ���� ����. �� �ɼ��� ������ 
  �⺻���� ���� ���� Ʈ���ŷ� ����Ǹ� ������, �Ŀ� �ѹ����� Ʈ���� ����

DECLARE : ���� ���� �� ��� Ű����

--------------------
<�÷��� ���>
OLD.�÷��� : SQL �ݿ� ���� �÷� ����Ÿ�� �ǹ�
NEW.�÷��� : SQL �ݿ� ���� �÷� ����Ÿ�� �ǹ�
*****************************************/
-- BOOK���̺� ���� �α�(LOG �̷�)�� ���� ���̺�(BOOK_LOG) �ۼ�
CREATE TABLE BOOK_LOG (
    BOOKID NUMBER,
    BOOKNAME VARCHAR2(100),
    PUBLISHER VARCHAR2(100),
    PRICE VARCHAR2(100),
    LOGDATE DATE DEFAULT SYSDATE,
    JOB_GUBUN VARCHAR2(100)
);

-- Ʈ���� �ۼ�
-- BOOK ���̺� �����Ͱ� �Է�(INSERT)�Ǹ� BOOK_LOG�� �̷� ����
-- Ʈ���Ÿ� : AFTER_INSERT_BOOK
CREATE OR REPLACE TRIGGER AFTER_INSERT_BOOK
    AFTER INSERT ON BOOK
    FOR EACH ROW
DECLARE

BEGIN
    -- �α� �Է�
    INSERT INTO BOOK_LOG
        (BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    VALUES (:NEW.BOOKID, :NEW.BOOKNAME, :NEW.PUBLISHER, :NEW.PRICE, 'INSERT');
END;
----------------------------
-- Ʈ���� ���۽�Ű��
SELECT * FROM BOOK;
SELECT * FROM BOOK_LOG;
INSERT INTO BOOK
VALUES (90, 'Ʈ���Ŷ� �����ΰ�?', 'ITBOOK', 33000);

INSERT INTO BOOK 
VALUES (91, 'Ʈ���Ŷ� �����ΰ�?(������)', 'ITBOOK', 33000);

--===========================
-- UPDATE Ʈ���� �ۼ� : AFTER_UPDATE_BOOK
-- BOOK ���̺� ����(UPDATE) �߻��� �̷� �����
CREATE OR REPLACE TRIGGER AFTER_UPDATE_BOOK
    AFTER UPDATE ON BOOK
    FOR EACH ROW        -- �����Ǵ� ��� �����Ϳ� ���Ͽ� Ʈ���� ����
DECLARE

BEGIN
    INSERT INTO BOOK_LOG
        (BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    VALUES (:OLD.BOOKID, :OLD.BOOKNAME||' > '||:NEW.BOOKNAME
            , :OLD.PUBLISHER||' > '||:NEW.PUBLISHER
            , :OLD.PRICE||' > '||:NEW.PRICE ,'UPDATE'); 
END;

---------------------------------------------
-- UPDATE Ʈ���� �׽�Ʈ : BOOK���̺� ������ ����
UPDATE BOOK 
   SET BOOKNAME = 'Ʈ���Ŷ� �����ΰ�?[Ư����]'
       , PRICE = 40000
 WHERE BOOKID = 91;

---------------------------------------------
-- DELETE Ʈ���� �ۼ��ϰ� �׽�Ʈ Ȯ��
-- Ʈ���Ÿ� : AFTER_DELETE_BOOK
-- ������ �����۾� �� �̷� ����� : ������ �����͸� ���
CREATE OR REPLACE TRIGGER AFTER_DELETE_BOOK
    AFTER DELETE ON BOOK
    FOR EACH ROW
DECLARE
    
BEGIN
    INSERT INTO BOOK_LOG
        (BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    VALUES
        (:OLD.BOOKID, :OLD.BOOKNAME, :OLD.PUBLISHER, :OLD.PRICE, 'DELETE');
END;
------------------------------------
-- DELETE Ʈ���� �׽�Ʈ : BOOK���̺� ����
DELETE FROM BOOK WHERE BOOKID = 91;
SELECT * FROM BOOK;
SELECT * FROM BOOK_LOG;