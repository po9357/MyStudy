/*******************************************
<�ε��� - INDEX>
���̺� �ִ� ������(�ο�, ���ڵ�)�� ������ ã�� ���� ������� ������ ����
- �ڵ��ε��� : PRIMARY KEY ����� �Ǵ� UNIQUE �������� ���� �� �����Ǵ� �ε���
- �����ε��� : CREATE INDEX ��ɹ��� ����ؼ� ����� �ε���

<�ε��� ������ �������>
- �ε����� WHERE���� ���� ���Ǵ� �÷��� ����
- �������ǿ� ���� ���Ǵ� �÷��� ����
- ���� ���̺� �ε����� �ʹ� ���Ƶ� �ӵ� ���� ���� �߻� (���̺�� 4~5 ����)
- �÷��� �����Ͱ� ����(�Է�, ����, ����)�Ǵ� ��찡 ������ �������
- �÷��� ������ �������� ���� �� ȿ�� ����

<�ε��� ���� ����>
CREATE INDEX �ε����� ON ���̺�� (�÷���1[, �÷���2, ..., �÷���n]);
CREATE [UNIQUE] INDEX ON ���̺�� (�÷���1 [ASC | DESC], �÷���2, ..., �÷���n);

<�ε��� ���� ����>
DROP INDEX �ε�����;

<�ε��� �籸�� ����>
ALTER INDEX �ε����� REBUILD;
ALTER [UNIQUE] INDEX �ε����� [ON ���̺�� (�÷���, ..., �÷���n)] REBUILD;
*******************************************/
-- �ε��� ���� : BOOK ���̺��� ���ǻ�(PUBLISHER) �÷��� IX_BOOK �ε��� ����
CREATE INDEX IX_BOOK ON BOOK (PUBLISHER);
SELECT * FROM BOOK ORDER BY PUBLISHER;
SELECT * FROM BOOK WHERE PUBLISHER = '�½�����';
DROP INDEX IX_BOOK;

-- �ε��� ���� (2�� �÷�����)
-- BOOK ���̺��� PUBLISHER, PRICE �÷��� ������� IX_BOOK2 �ε��� ����
CREATE INDEX IX_BOOK2 ON BOOK (PUBLISHER, PRICE);
SELECT PUBLISHER, PRICE FROM BOOK ORDER BY PUBLISHER, PRICE;
-- �ε��� ���� ��
SELECT * FROM BOOK WHERE PUBLISHER = '�½�����' AND PRICE = 8000;
-- PUBLISHER, PRICE �� �̿��� ������ �ε��� ��� ����
SELECT * FROM BOOK WHERE PUBLISHER = '���ѹ̵��'; -- �ε��� �����
SELECT * FROM BOOK WHERE PUBLISHER BETWEEN '�½�����' AND '���ѹ̵��'; -- �ε��� �����
-- PUBLISHER, PRICE �� �̿��� ������ �ε����� 2��° �׸���ʹ�
-- �ܵ� �ε����� ����ȵ�(���� ���� ���)
SELECT * FROM BOOK WHERE PRICE = 8000; -- �ε��� ���� �ȵ�

-- LIKE���� ���� �ε����� ���� ����
-- �ε����� ���ĵǾ� '����%'�� ��� '����'���� �����ϴ� �����͸� ������� ã�� �ε��� ���� O
SELECT * FROM BOOK WHERE PUBLISHER LIKE '����%'; -- �ε��� �����
-- �ε����� ���� �Ǿ�����, '%����%'�� ��� ������ �� �� ���� �ε��� ���� X
SELECT * FROM BOOK WHERE PUBLISHER LIKE '%����%'; -- �ε��� ���� �ȵ�

-- ���� �����͸� ������ ����ϱ⿡ �ε��� ���� X
SELECT * FROM BOOK WHERE SUBSTR(PUBLISHER,1,2) = '����';

----------------------------------
/* *** �ε��� �ǽ� ****************************
���缭�� �����ͺ��̽����� ���� SQL ���� �����ϰ� 
�����ͺ��̽��� �ε����� ����ϴ� ������ Ȯ���Ͻÿ�.
(1) ���� SQL ���� �����غ���.
	SELECT name FROM Customer WHERE name LIKE '�ڼ���';
(2) ���� ��ȹ�� ���캻��. ���� ��ȹ�� [F10]Ű�� ���� �� 
    [��ȹ ����]���� �����ϸ� ǥ�õȴ�.
(3) Customer ���̺� name���� �ε���(ix_customber_name)�� �����Ͻÿ�. 
    ���� �� (1)���� ���Ǹ� �ٽ� �����ϰ� ���� ��ȹ�� ���캸�ÿ�.
(4) ���� ���ǿ� ���� �� ���� ���� ��ȹ�� ���غ��ÿ�.
(5) (3)������ ������ �ε����� �����Ͻÿ�.
******************************************/
-- (1) ���� SQL ���� �����غ���.
-- SELECT name FROM Customer WHERE name LIKE '�ڼ���';
-- (2) ���� ��ȹ�� ���캻��. ���� ��ȹ�� [F10]Ű�� ���� �� 
-- [��ȹ ����]���� �����ϸ� ǥ�õȴ�.
SELECT NAME FROM CUSTOMER WHERE NAME LIKE '�ڼ���';
-- (3) Customer ���̺� name���� �ε���(ix_customber_name)�� �����Ͻÿ�. 
-- ���� �� (1)���� ���Ǹ� �ٽ� �����ϰ� ���� ��ȹ�� ���캸�ÿ�.
-- (4) ���� ���ǿ� ���� �� ���� ���� ��ȹ�� ���غ��ÿ�.
CREATE INDEX IX_CUSTOMER_NAME ON CUSTOMER (NAME);
SELECT NAME FROM CUSTOMER WHERE NAME LIKE '�ڼ���';
-- (5) (3)������ ������ �ε����� �����Ͻÿ�.
DROP INDEX IX_CUSTOMER_NAME;