/*************************
<��¥���� �����Լ�>
��¥,�ð��Լ� : ������ ����
DATEŸ�� + ����(����) : ���ڸ�ŭ ���� ����
DATEŸ�� - ����(����) : ���ڸ�ŭ ���� ����

ADD_MONTHS(��¥, ������) : ������ ��ŭ ���� ����
LAST_DAY(��¥) : ��¥�� ���� ���� ������ ��¥ ���ϱ�
NEXT_DAY(��¥, ����) : ���ϱ��ϱ�, ��¥ ������ ���� ù��° ���� ���� ���ϱ� 
MONTHS_BETWEEN(��¥1, ��¥2) : �Ⱓ ���ϱ�(����) ������: ��¥1 - ��¥2
**************************/
SELECT SYSDATE, SYSDATE + 1, SYSDATE - 1 FROM DUAL;         --  �� ���� ���ϰ� ��

--  ADD_MONTHS(��¥, ������) : ������ ��ŭ ���� ����
SELECT SYSDATE, ADD_MONTHS (SYSDATE, 2) FROM DUAL;
SELECT SYSDATE, ADD_MONTHS (SYSDATE, -2) FROM DUAL;

--  LAST_DAY(��¥) : ��¥�� ���� ���� ������ ��¥ ���ϱ�
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;
SELECT SYSDATE, ADD_MONTHS (SYSDATE, -6), LAST_DAY (SYSDATE) FROM DUAL;
SELECT SYSDATE, ADD_MONTHS (SYSDATE, -6), LAST_DAY (ADD_MONTHS (SYSDATE, -6)) FROM DUAL; 

--  NEXT_DAY(��¥, ����) : ���ϱ��ϱ�, ��¥ ������ ���� ù��° ���� ���� ���ϱ� 
SELECT SYSDATE, NEXT_DAY (SYSDATE, 'ȭ') FROM DUAL;              --  ���� ���ķ� �ٰ����� 'ȭ'���� ��¥ 
SELECT SYSDATE, NEXT_DAY (SYSDATE, '�ݿ���') FROM DUAL;
SELECT SYSDATE, NEXT_DAY (SYSDATE, '��') FROM DUAL;

--  MONTHS_BETWEEN(��¥1, ��¥2) : �Ⱓ ���ϱ�(����) ������: ��¥1 - ��¥2
SELECT SYSDATE, ADD_MONTHS (SYSDATE, 2) FROM DUAL;
SELECT MONTHS_BETWEEN (SYSDATE, ADD_MONTHS (SYSDATE, 2)) FROM DUAL;
                                                                --  SYSDATE - ADD_MONTHS(SYSDATE, 2) = -2
SELECT MONTHS_BETWEEN (ADD_MONTHS (SYSDATE, 2), SYSDATE) FROM DUAL;

