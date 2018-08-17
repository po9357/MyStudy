/****************************************
SELECT [ * | DISTINCT ]{ �÷���, �÷���, ..., �÷��� }
    FROM ���̺��
[ WHERE ������
  GROUP BY { �÷���, �÷���, ..., �÷��� }
  HAVING ����
  ORDER BY { �÷���, �÷���, ..., �÷��� } [ ASC  |  DESC ]             
  --    ORDER BY ��ɾ�� �� �������� ��ġ�ؾ� �Ѵ�          --   ASC : �������� ( �⺻ / ���� ���� )
                                                                            --   DESC : ��������
]
****************************************/
SELECT * FROM BOOK
ORDER BY BOOKNAME;          --  å �̸� ���� �����ټ� ����
SELECT * FROM BOOK ORDER BY BOOKNAME DESC;
--  ���ǻ� ���� ��������, �ݾ� ū�ݾ� ����
SELECT * FROM BOOK
ORDER BY PUBLISHER, PRICE DESC;
------------------------------------
--  AND, OR, NOT : �ڹٿ��� &&, ||, ! �� (SQL���� ������� �ʰ� AND, OR, NOT���� ���)
--  AND : ���ǻ� ���ѹ̵��, �ݾ��� 3���� �̻��� å ��ȸ
SELECT * FROM BOOK
    WHERE PUBLISHER = '���ѹ̵��' AND PRICE >= 30000;
    
--  OR : ���ǻ� ���ѹ̵�� �Ǵ� �̻�̵��� ������ å
SELECT * FROM BOOK 
    WHERE PUBLISHER = '���ѹ̵��' OR PUBLISHER = '�̻�̵��';
    
--  NOT : ���ǻ� �½������� �����ϰ� ������ ��ü
SELECT * FROM BOOK
    WHERE NOT PUBLISHER = '�½�����';
SELECT * FROM BOOK
    WHERE PUBLISHER != '�½�����';
SELECT * FROM BOOK
    WHERE PUBLISHER <> '�½�����';
    
SELECT * FROM BOOK
    WHERE NOT PUBLISHER = '�½�����' OR PUBLISHER = '���ѹ̵��' ;       --  NOT�� ������� ��� ����
SELECT * FROM BOOK
    WHERE NOT (PUBLISHER = '�½�����' OR PUBLISHER = '���ѹ̵��') ;

SELECT * FROM BOOK
    WHERE PUBLISHER <> '�½�����' AND PUBLISHER <> '���ѹ̵��';
-----------------------------------------------------------
--  IN : �ȿ� �ֳ�? (OR���� �ܼ�ȭ)

--  (�ǽ�) ���ǻ� : ������, ���ѹ̵��, �Ｚ�� ���� ������ å ��ȸ
SELECT * FROM BOOK
    WHERE PUBLISHER = '������' OR PUBLISHER = '���ѹ̵��' OR PUBLISHER = '�Ｚ��';
SELECT * FROM BOOK
    WHERE PUBLISHER IN ('������', '���ѹ̵��', '�Ｚ��');

--  (�ǽ�) ���ǻ� : ������, ���ѹ̵��, �Ｚ���� ������ ���ǻ��� å ��ȸ
SELECT * FROM BOOK
    WHERE NOT (PUBLISHER = '������'OR PUBLISHER = '���ѹ̵��' OR PUBLISHER = '�Ｚ��');
SELECT * FROM BOOK
    WHERE PUBLISHER <> '������' AND PUBLISHER <> '���ѹ̵��' AND PUBLISHER <> '�Ｚ��';
SELECT * FROM BOOK
    WHERE PUBLISHER NOT IN ('������', '���ѹ̵��', '�Ｚ��')
        ORDER BY PUBLISHER, PRICE;
        
----------------------------------------------------------
--    =,     >,   <,         >=,         <=,         <>, !=
--  ����, ũ��, �۴�, ũ�ų� ����, �۰ų� ����, ���� �ʴ� ( <>ǥ��, != DB�� ���� ���� )
--  ���ǵ� å �߿� 1���� �̻� 25000�� ������ å
SELECT * FROM BOOK
    WHERE PRICE >= 8000 AND PRICE <= 22000
        ORDER BY PRICE;

--  BETWEEN a AND b : a���� b���� ���·� ���
SELECT * FROM BOOK
    WHERE PRICE BETWEEN 8000 AND 22000              --  ��谪 ���� ( 8000, 22000�� ���� )
        ORDER BY PRICE;

SELECT * FROM BOOK
    WHERE PRICE NOT BETWEEN 8000 AND 22000     
        ORDER BY PRICE;
        
        
--  å ������ '�߱�' ~ '�ø���'
SELECT * FROM BOOK
    WHERE BOOKNAME BETWEEN '�߱�' AND '�ø���'
        ORDER BY BOOKNAME;
        
--  ���ǻ� ������ ~ �Ｚ�� å ��ȸ
SELECT * FROM BOOK
    WHERE PUBLISHER BETWEEN '������' AND '�Ｚ��'
        ORDER BY PUBLISHER;
------------------------------------------
--  LIKE : '%', '_' ��ȣ�� �Բ� ���
--  % : ��ü(����)�� �ǹ�
--  _ (�����) : ���� �ϳ��� ���� ��� ���� �ǹ�
-----------
--  ���ǻ� �� '�̵��' ��� �ܾ �ִ� ���ǻ翡�� ������ å ��ü ��ȸ
SELECT * FROM BOOK
    WHERE PUBLISHER LIKE '%�̵��';        --  ���ǻ� �̸��� '�̵��'�� ������ ��

SELECT * FROM BOOK
    WHERE BOOKNAME LIKE '�߱�%';           --  å ������ '�߱�'�� �����ϴ� ��

SELECT * FROM BOOK
    WHERE BOOKNAME LIKE '%�ܰ�%';         --  å ���� '�ܰ�'�� ���ԵǾ��ִ� ��
-------------------------------------------
--  å ���� '��' ���ڰ� �ִ� å ��� ��ȸ
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%��%';

--  å ������ �ι�° ���ڰ� '��'�� å ��� ��ȸ
--  UPDATE BOOK SET BOOKNAME = '�츮 �߱��� �߾�' WHERE BOOKID = 7;
SELECT * FROM BOOK WHERE BOOKNAME LIKE '_��%';

--  å ������ 2, 3��° ���ڰ� '����' �� å ��� ��ȸ
SELECT * FROM BOOK WHERE BOOKNAME LIKE '_����%';
----------------------------------------------
--============================================
--  �׷� �Լ� : �ϳ� �̻��� ���� �׷����� ��� ����
--  COUNT (*) : ������ ���� ��ȸ (��ü �÷��� ����)
--  COUNT (�÷���) : ������ ���� ��ȸ (������ �÷��� ���Ͽ�)
--  SUM (�÷�) : �հ� �� ���ϱ�
--  AVG (�÷�) : ��� �� ���ϱ�
--  MAX (�÷�) : �ִ� �� ���ϱ�
--  MIN (�÷�) : �ּ� �� ���ϱ�
---------------------------
SELECT COUNT (*) FROM BOOK;                         --  BOOK ���̺��� ������ �Ǽ�
SELECT * FROM BOOK;
SELECT COUNT (*) FROM CUSTOMER;                --  CUSTOMER ���̺��� ������ �Ǽ�
SELECT * FROM CUSTOMER;
SELECT COUNT (NAME) FROM CUSTOMER;         --  5�� ��ȸ
SELECT COUNT (PHONE) FROM CUSTOMER;       --  4�� ��ȸ ( NULL���� ��ȸ���� ���� )
------------------------------
--  SUM (�÷�) : �÷��� �հ谪 ���� ��
SELECT * FROM BOOK;
SELECT SUM (PRICE) FROM BOOK;                     --  144500  PRICE �÷��� ��� �����͸� ��ħ
SELECT SUM (PRICE) FROM BOOK
    WHERE PUBLISHER IN ('���ѹ̵��', '�̻�̵��');
--WHERE PUBLISHER LIKE ('%�̵��');

--  AVG (�÷�) : �÷��� ��հ��� ���� ��
SELECT * FROM BOOK;
SELECT AVG (PRICE) FROM BOOK;
SELECT AVG (PRICE) AS AVG_PRICE FROM BOOK;      --  AS�� ��Ī�� �ο��� �� ����
SELECT AVG (PRICE)  AVG_PRICE FROM BOOK;          --  AS ���� ����
SELECT AVG (PRICE) FROM BOOK
    WHERE PUBLISHER IN ('���ѹ̵��', '�̻�̵��');

--  MAX (�÷�) : �÷��� �ִ밪�� ���� ��
--  MIN (�÷�) : �÷��� �ּҰ��� ���� ��
SELECT * FROM BOOK ORDER BY PRICE DESC;
SELECT MAX (PRICE) FROM BOOK;
SELECT MIN (PRICE) FROM BOOK;
SELECT MAX (PRICE), MIN (PRICE) FROM BOOK;
SELECT MAX (PRICE), MIN (PRICE) FROM BOOK
    WHERE PUBLISHER = '�½�����';
    
SELECT COUNT(*), SUM(PRICE), AVG(PRICE), MAX(PRICE), MIN(PRICE)
    FROM BOOK;
    
--------------------------------------------
SELECT * FROM CUSTOMER WHERE NAME = '������';
SELECT * FROM CUSTOMER;
--  (�ǽ�) 
--  1.  �������� �� ���ž� (�������� ����ȣ (CUSTID = 1))
SELECT SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = 1;
SELECT '������', SUM (SALEPRICE) FROM ORDERS WHERE CUSTID = 1;

--  2.  �������� ������ ������ ��
SELECT COUNT(*) FROM ORDERS WHERE CUSTID = 1;
SELECT '������', COUNT(*) FROM ORDERS WHERE CUSTID = 1;

--  3.  ���� '��'���� ���� �̸��� �ּ�
SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '��%';
SELECT '�� ��', NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '��%';

--  4.  ���� '��'���̰� �̸��� '��'�� ������ ���� �̸��� �ּ�
SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '��%��';
SELECT '�� % ��', NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '��%��';
---------------------------------------------
--  LIKE �˾ƺ���
CREATE TABLE TEST_LIKE (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO test_like (ID, NAME) VALUES (1, 'ȫ�浿');
INSERT INTO test_like (ID, NAME) VALUES (2, 'ȫ�浿2');    
INSERT INTO test_like (ID, NAME) VALUES (3, 'ȫ�浿��');
INSERT INTO test_like (ID, NAME) VALUES (4, 'ȫ�浿�빮');
INSERT INTO test_like (ID, NAME) VALUES (5, 'ȫ�浿2��');
INSERT INTO test_like (ID, NAME) VALUES (6, '��ȫ�浿');
INSERT INTO test_like (ID, NAME) VALUES (7, '�踸ȫ�浿');
INSERT INTO test_like (ID, NAME) VALUES (8, '��ȫ�浿��');
INSERT INTO test_like (ID, NAME) VALUES (9, '��ȫ�浿���̴�');
INSERT INTO TEST_LIKE (ID) VALUES (10);
SELECT * FROM TEST_LIKE;
SELECT * FROM TEST_LIKE WHERE NAME LIKE 'ȫ�浿';
SELECT * FROM TEST_LIKE WHERE NAME LIKE 'ȫ�浿%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE 'ȫ�浿2%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '%ȫ�浿%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_ȫ�浿_';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_ȫ�浿%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '_ȫ�浿_%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '__ȫ�浿%';
SELECT * FROM TEST_LIKE WHERE NAME LIKE '%';