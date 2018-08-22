-- �񱳱��� : IF��
-- IF () THEN ~ END IF;
-- IF () THEN ~ ELSE ~ END IF;
-- IF () THEN ~ ELSIF ~ ELSIF ~ ELSE ~ END IF;
CREATE OR REPLACE PROCEDURE PRC_IF (
    IN_NUM NUMBER
) AS
    V_STR VARCHAR2(1000);
BEGIN
    -- ¦��, Ȧ�� �Ǻ�
    IF (MOD(IN_NUM, 2) = 0) THEN 
        V_STR := V_STR || '¦��';
    ELSE
        V_STR := V_STR || 'Ȧ��';
    END IF;
    DBMS_OUTPUT.PUT_LINE(IN_NUM || V_STR || '�Դϴ�');
    -- 4���� ���� ������ �� Ȯ��
    IF (MOD(IN_NUM, 4) = 0) THEN
        V_STR := V_STR || ', 4���� ���� ������ 0';
    ELSIF (MOD(IN_NUM, 4) = 1) THEN
        V_STR := V_STR || ', 4���� ���� ������ 1';
    ELSIF (MOD(IN_NUM, 4) = 2) THEN
        V_STR := V_STR || ', 4���� ���� ������ 2';
    ELSE
        V_STR := V_STR || ', 4���� ���� ������ 3';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(IN_NUM || V_STR);
        
END;

--------------------------------------------------
-- �ݺ��� : FOR, WHILE
-- FOR��
-- ����
CREATE OR REPLACE PROCEDURE PRC_FOR_SUM (
    IN_NUM NUMBER
) AS
    V_SUM NUMBER := 0;      -- ���� �ʱⰪ ����
    I NUMBER := 0;
BEGIN
    -- �Է¹��� ���ڱ����� �հ� ���ϱ� (1 ~ IN_NUM����)
    DBMS_OUTPUT.PUT('1 ���� '||IN_NUM||'������ �� : ');
    
    -- FOR������ �ݺ�ó��
    -- FOR ���� IN �ʱⰪ..������ LOOP ~ END LOOP;
    FOR I IN 1..IN_NUM LOOP
        V_SUM := V_SUM+I;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(V_SUM);
END;
------------------------------------
-- WHILE��
CREATE OR REPLACE PROCEDURE PRC_WHILE_SUM (
    IN_NUM NUMBER
) AS
    V_SUM NUMBER := 0;      -- ���� �ʱⰪ ����
    I NUMBER := 0;
BEGIN
    -- �Է¹��� ���ڱ����� �հ� ���ϱ� (1 ~ IN_NUM����)
    DBMS_OUTPUT.PUT('1 ���� '||IN_NUM||'������ �� : ');
    
   --WHILE��
    WHILE (I <= IN_NUM) LOOP
        V_SUM := V_SUM + I;
        I := I+1;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(V_SUM);
END;

-----------------------------------------
-- (�ǽ�) ���ڸ� �ϳ� �Է¹޾� 0 ���� ���ڰ����� �հ� ���ϱ�
-- �Է°��� Ȧ���̸� Ȧ������ ���ϰ�,
-- �Է°��� ¦���̸� ¦������ ���ؼ�
-- ���� ����� ȭ�鿡 ���
-- ��� ����
-- �Է¼��� : �Է¹��� ��, Ȧ��/¦��, �հ� : �հ� �����
-- ��� ��) �Է¼��� : 4, ¦��, �հ� : 6
CREATE OR REPLACE PROCEDURE PRC_SUM_EVENODD (
    IN_NUM IN NUMBER
) AS
    V_ODD_SUM NUMBER := 0;
    V_EVEN_SUM NUMBER := 0;
    I NUMBER := 0;
BEGIN
    FOR I IN 1..IN_NUM LOOP
        IF (MOD(I, 2) = 0) THEN
            V_EVEN_SUM := V_EVEN_SUM+I;
        ELSE
            V_ODD_SUM := V_ODD_SUM+I;
        END IF;
    END LOOP;

    IF (MOD(IN_NUM, 2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE('�Է� ���� : '||IN_NUM||', ¦��, �հ� : '||V_EVEN_SUM);
    ELSE 
        DBMS_OUTPUT.PUT_LINE('�Է� ���� : '||IN_NUM||', Ȧ��, �հ� : '||V_ODD_SUM);
    END IF;    
   -- DBMS_OUTPUT.PUT_LINE('�Է� ���� : '||IN_NUM||', ¦�� �հ� : '||V_EVEN_SUM||', Ȧ�� �հ� : '||V_ODD_SUM);
END;

/*
    V_NUM := MOD(IN_NUM, 2);        -- 0, 1
    IF (MOD(IN_NUM, 2) = 0) THEN
        V_EVEN_ODD := '¦��';
    ELSE
        V_EVEN_ODD := 'Ȧ��';
    END IF;
    
    FOR I IN 0..IN_NUM LOOP
        IF (MOD(I, 2) = V_NUM) THEN
            V_SUM := V_SUM+I;
        END IF;
    END LOOP;
        