/* ** �ǽ����� : HR����(DB)���� �䱸���� �ذ� **********
-- ���(employee_id)�� 100�� ���� ���� ��ü ����
-- ����(salary)�� 15000 �̻��� ������ ��� ���� ����
-- ������ 15000 �̻��� ����� ���, �̸�(LAST_NAME), �Ի���(hire_date), ���޿� ���� ����
-- ������ 10000 ������ ����� ���, �̸�(LAST_NAME), �Ի���, ���޿� ���� ����
---- (�޿��� ���� �������)
-- �̸�(first_name)�� john�� ����� ��� ���� ��ȸ
-- �̸�(first_name)�� john�� ����� �� ���ΰ�?
-- 2008�⿡ �Ի��� ����� ���, ����('first_name last_name'), ���޿� ���� ��ȸ
---- ���� ��¿�) 'Steven King'
-- ���޿��� 20000~30000 ������ ���� ���, ����(last_name first_name), ���޿� ���� ��ȸ
-- ������ID(MANAGER_ID)�� ���� ��� ���� ��ȸ
-- ����(job_id)�ڵ� 'IT_PROG'���� ���� ���� ���޿��� ��
-- ������ �ִ� ���޿� �˻�
-- ������ �ִ� ���޿� �˻��ϰ�, �ִ� ���޿��� 10000�̻��� ���� ��ȸ
-- ������ ��ձ޿� �̻��� ���� ��ȸ
**********************************************************/
SELECT * FROM EMPLOYEES ORDER BY JOB_ID;
-- ���(employee_id)�� 100�� ���� ���� ��ü ����
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;
-- ����(salary)�� 15000 �̻��� ������ ��� ���� ����
SELECT * FROM EMPLOYEES WHERE SALARY >= 15000;
-- ������ 15000 �̻��� ����� ���, �̸�(LAST_NAME), �Ի���(hire_date), ���޿� ���� ����
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY FROM EMPLOYEES WHERE SALARY >= 15000;
-- ������ 10000 ������ ����� ���, �̸�(LAST_NAME), �Ի���, ���޿� ���� ����
---- (�޿��� ���� �������)
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY FROM EMPLOYEES WHERE SALARY <= 10000 ORDER BY SALARY DESC;
-- �̸�(first_name)�� john�� ����� ��� ���� ��ȸ
SELECT * FROM EMPLOYEES WHERE UPPER (FIRST_NAME) IN ('JOHN');
-- �̸�(first_name)�� john�� ����� �� ���ΰ�?
SELECT COUNT(*) FROM EMPLOYEES WHERE UPPER (FIRST_NAME) IN ('JOHN');
-- 2008�⿡ �Ի��� ����� ���, ����('first_name last_name'), ���޿� ���� ��ȸ
---- ���� ��¿�) 'Steven King'
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, SALARY FROM EMPLOYEES WHERE HIRE_DATE LIKE '08%';
-- ���޿��� 20000~30000 ������ ���� ���, ����(last_name first_name), ���޿� ���� ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY BETWEEN 20000 AND 30000;
-- ������ID(MANAGER_ID)�� ���� ��� ���� ��ȸ
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
-- ����(job_id)�ڵ� 'IT_PROG'���� ���� ���� ���޿��� ��
SELECT MAX(SALARY) FROM EMPLOYEES WHERE UPPER (JOB_ID) IN 'IT_PROG';
-- ������ �ִ� ���޿� �˻�
SELECT JOB_ID, MAX(SALARY) MAX FROM EMPLOYEES GROUP BY JOB_ID ORDER BY MAX;
-- ������ �ִ� ���޿� �˻��ϰ�, �ִ� ���޿��� 10000�̻��� ���� ��ȸ
SELECT E.JOB_ID, MAX(SALARY) FROM EMPLOYEES E 
 WHERE (SELECT MAX(SALARY) 
                 FROM EMPLOYEES 
               WHERE E.JOB_ID = JOB_ID) >= 10000 GROUP BY JOB_ID;
-- ������ ��ձ޿� �̻��� ���� ��ȸ
SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY JOB_ID; --   ������ ��� �޿�
SELECT E.*
           , (SELECT AVG(SALARY) FROM EMPLOYEES WHERE E.JOB_ID = JOB_ID) AVG_SAL  
   FROM EMPLOYEES E 
 WHERE SALARY >= (SELECT AVG(SALARY) 
                                   FROM EMPLOYEES 
                                 WHERE E.JOB_ID = JOB_ID)
ORDER BY JOB_ID, SALARY;