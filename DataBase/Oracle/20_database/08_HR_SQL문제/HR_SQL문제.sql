/* ***** HR DB ������ ��ȸ �ǽ� *****************
��1 HR �μ����� ���� �� ������ �޿� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  �������(Employees) ���̺��� �޿��� $7,000~$10,000 ���� �̿��� ����� 
  �̸��� ��(Name���� ��Ī) �� �޿��� �޿��� ���� ������ ����Ͻÿ�
  

��2 HR �μ������� �޿�(salary)�� ������(commission_pct)�� ���� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ �޴� ��� ����� �̸��� ��(Name���� ��Ī), �޿�, ����, �������� ����Ͻÿ�. 
  �̶� �޿��� ū ������� �����ϵ�, �޿��� ������ �������� ū ������� �����Ͻÿ�

  
��3 �̹� �б⿡ 60�� IT �μ������� �ű� ���α׷��� �����ϰ� �����Ͽ� ȸ�翡 �����Ͽ���. 
  �̿� �ش� �μ��� ��� �޿��� 12.3% �λ��ϱ�� �Ͽ���. 
  60�� IT �μ� ����� �޿��� 12.3% �λ��Ͽ� ������(�ݿø�) ǥ���ϴ� ������ �ۼ��Ͻÿ�. 
  ������ �����ȣ, ���� �̸�(Name���� ��Ī), �޿�, �λ�� �޿�(Increase Salary�� ��Ī)������ ����Ͻÿ�
  

��4 �� ����� ��(last_name)�� ��s���� ������ ����� �̸��� ������ �Ʒ��� ���� ���� ����ϰ��� �Ѵ�. 
  ��� �� �̸�(first_name)�� ��(last_name)�� ù ���ڰ� �빮��, ������ ��� �빮�ڷ� ����ϰ� 
  �Ӹ���(��ȸ�÷���)�� Employee JOBs.�� ǥ���Ͻÿ�
  ��) FIRST_NAME  LAST_NAME  Employee JOBs.
      Shelley     Higgins    AC_MGR

��5 ��� ����� ������ ǥ���ϴ� ������ �ۼ��Ϸ��� �Ѵ�. 
  ������ ����� �̸��� ��(Name���� ��Ī), �޿�, ���翩�ο� ���� ������ �����Ͽ� ����Ͻÿ�. 
  ���翩�δ� ������ ������ ��Salary + Commission��, ������ ������ ��Salary only����� ǥ���ϰ�, 
  ��Ī�� ������ ���̽ÿ�. ���� ��� �� ������ ���� ������ �����Ͻÿ�

  
��6 �� ����� �Ҽӵ� �μ����� �޿� �հ�, �޿� ���, �޿� �ִ�, �޿� �ּڰ��� �����ϰ��� �Ѵ�. 
  ���� ��°��� ���� �ڸ��� �� �ڸ� ���б�ȣ, $ǥ�ÿ� �Բ� ���($123,456) 
  ��, �μ��� �Ҽӵ��� ���� ����� ���� ������ �����ϰ�, ��� �� �Ӹ����� ��Ī(alias) ó���Ͻÿ�
    

��7 ������� ������ ��ü �޿� ����� $10,000���� ū ��츦 ��ȸ�Ͽ� ������ �޿� ����� ����Ͻÿ�. 
  �� ������ CLERK�� ���Ե� ���� �����ϰ� ��ü �޿� ����� ���� ������� ����Ͻÿ�


��8 HR ��Ű���� �����ϴ� Employees, Departments, Locations ���̺��� ������ �ľ��� �� 
  Oxford�� �ٹ��ϴ� ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �����̸��� ����Ͻÿ�. 
  �̶� ù ��° ���� ȸ���̸��� 'HR-Company'�̶�� ������� ��µǵ��� �Ͻÿ�


��9 HR ��Ű���� �ִ� Employees, Departments ���̺��� ������ �ľ��� �� ������� �ټ� �� �̻��� 
  �μ��� �μ��̸��� ��� ���� ����Ͻÿ�. �̶� ��� ���� ���� ������ �����Ͻÿ�


��10 �� ����� �޿��� ���� �޿� ����� �����Ϸ��� �Ѵ�. 
  �޿� ����� Job_Grades ���̺� ǥ�õȴ�. �ش� ���̺��� ������ ���캻 �� 
  ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �Ի���, �޿�, �޿������ ����Ͻÿ�.
  
CREATE TABLE JOB_GRADES (
    GRADE_LEVEL VARCHAR2(3),
    LOWEST_SAL NUMBER,
    HIGHEST_SAL NUMBER
);
INSERT INTO JOB_GRADES VALUES ('A', 1000, 2999);
INSERT INTO JOB_GRADES VALUES ('B', 3000, 5999);
INSERT INTO JOB_GRADES VALUES ('C', 6000, 9999);
INSERT INTO JOB_GRADES VALUES ('D', 10000, 14999);
INSERT INTO JOB_GRADES VALUES ('E', 15000, 24999);
INSERT INTO JOB_GRADES VALUES ('F', 25000, 40000);
COMMIT;

********************************/
-- ��1 HR �μ����� ���� �� ������ �޿� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
--   �������(Employees) ���̺��� �޿��� $7,000~$10,000 ���� �̿��� ����� 
--   �̸��� ��(Name���� ��Ī) �� �޿��� �޿��� ���� ������ ����Ͻÿ�
SELECT * FROM EMPLOYEES;
SELECT (FIRST_NAME||' '||LAST_NAME) NAME, SALARY FROM EMPLOYEES WHERE NOT SALARY BETWEEN 7000 AND 10000 ORDER BY SALARY;

-- ��2 HR �μ������� �޿�(salary)�� ������(commission_pct)�� ���� ���� ������ �ۼ��Ϸ��� �Ѵ�. 
--   ������ �޴� ��� ����� �̸��� ��(Name���� ��Ī), �޿�, ����, �������� ����Ͻÿ�. 
--   �̶� �޿��� ū ������� �����ϵ�, �޿��� ������ �������� ū ������� �����Ͻÿ�
SELECT (FIRST_NAME||' '||LAST_NAME) NAME, SALARY, JOB_ID, COMMISSION_PCT
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT IS NOT NULL
 ORDER BY SALARY DESC, COMMISSION_PCT DESC;
 
-- ��3 �̹� �б⿡ 60�� IT �μ������� �ű� ���α׷��� �����ϰ� �����Ͽ� ȸ�翡 �����Ͽ���. 
--   �̿� �ش� �μ��� ��� �޿��� 12.3% �λ��ϱ�� �Ͽ���. 
--   60�� IT �μ� ����� �޿��� 12.3% �λ��Ͽ� ������(�ݿø�) ǥ���ϴ� ������ �ۼ��Ͻÿ�. 
--   ������ �����ȣ, ���� �̸�(Name���� ��Ī), �޿�, �λ�� �޿�(Increase Salary�� ��Ī)������ ����Ͻÿ�
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 60;
SELECT E.EMPLOYEE_ID, E.FIRST_NAME||' '||E.LAST_NAME NAME, SALARY, SUB.ROU "Increase Salary"
  FROM EMPLOYEES E, (SELECT ROUND(SALARY * 1.123) ROU, EMPLOYEE_ID
                       FROM EMPLOYEES
                      WHERE DEPARTMENT_ID = 60) SUB
 WHERE E.EMPLOYEE_ID = SUB.EMPLOYEE_ID;
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME NAME, SALARY, ROUND(SALARY * 1.123) "Increase Salary"
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 60;
 
-- ��4 �� ����� ��(last_name)�� ��s���� ������ ����� �̸��� ������ �Ʒ��� ���� ���� ����ϰ��� �Ѵ�. 
--  ��� �� �̸�(first_name)�� ��(last_name)�� ù ���ڰ� �빮��, ������ ��� �빮�ڷ� ����ϰ� 
--  �Ӹ���(��ȸ�÷���)�� Employee JOBs.�� ǥ���Ͻÿ�
--  ��) FIRST_NAME  LAST_NAME  Employee JOBs.
--     Shelley     Higgins    AC_MGR
SELECT INITCAP(FIRST_NAME), INITCAP(LAST_NAME), UPPER(JOB_ID) "Employee JOBs."
  FROM EMPLOYEES
 WHERE UPPER(LAST_NAME) LIKE '%S';

-- ��5 ��� ����� ������ ǥ���ϴ� ������ �ۼ��Ϸ��� �Ѵ�. 
--   ������ ����� �̸��� ��(Name���� ��Ī), �޿�, ���翩�ο� ���� ������ �����Ͽ� ����Ͻÿ�. 
--   ���翩�δ� ������ ������ ��Salary + Commission��, ������ ������ ��Salary only����� ǥ���ϰ�, 
--   ��Ī�� ������ ���̽ÿ�. ���� ��� �� ������ ���� ������ �����Ͻÿ�
SELECT * FROM EMPLOYEES;
SELECT FIRST_NAME||' '||LAST_NAME NAME, SALARY, (SALARY * NVL(commissION_PCT, 0)) Ŀ�̼Ǳݾ�, ((SALARY + SALARY * NVL(COMMISSION_PCT, 0))*12) "Ŀ�̼� ���� ����", DECODE(COMMISSION_PCT, NULL, 'Salary only', 'Salary + Commission') ���翩��
  FROM EMPLOYEES
 ORDER BY "Ŀ�̼� ���� ����" DESC;
 
-- ��6 �� ����� �Ҽӵ� �μ����� �޿� �հ�, �޿� ���, �޿� �ִ�, �޿� �ּڰ��� �����ϰ��� �Ѵ�. 
--  ���� ��°��� ���� �ڸ��� �� �ڸ� ���б�ȣ, $ǥ�ÿ� �Բ� ���($123,456) 
--  ��, �μ��� �Ҽӵ��� ���� ����� ���� ������ �����ϰ�, ��� �� �Ӹ����� ��Ī(alias) ó���Ͻÿ�
SELECT * FROM EMPLOYEES;
SELECT DEPARTMENT_ID �μ��ѹ�
       , COUNT(*) �����
       , TO_CHAR(SUM(SALARY), '$999,999') �޿��հ�
       , TO_CHAR(ROUND(AVG(SALARY), 2), '$999,999.99') �޿����
       , TO_CHAR(MAX(SALARY), '$999,999') �ִ�޿�
       , TO_CHAR(MIN(SALARY), '$999,999') �ּұ޿�
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID
 ORDER BY 1;
 
-- ��7 ������� ������ ��ü �޿� ����� $10,000���� ū ��츦 ��ȸ�Ͽ� ������ �޿� ����� ����Ͻÿ�. 
--  �� ������ CLERK�� ���Ե� ���� �����ϰ� ��ü �޿� ����� ���� ������� ����Ͻÿ�
SELECT DISTINCT E.JOB_ID, SUB.AVG
  FROM EMPLOYEES E, (SELECT AVG(SALARY) AVG, JOB_ID FROM EMPLOYEES WHERE JOB_ID NOT LIKE '%CLERK%' GROUP BY JOB_ID) SUB
 WHERE E.JOB_ID = SUB.JOB_ID
   AND SUB.AVG > 10000
 ORDER BY SUB.AVG DESC;

   
-- ��8 HR ��Ű���� �����ϴ� Employees, Departments, Locations ���̺��� ������ �ľ��� �� 
--   Oxford�� �ٹ��ϴ� ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �����̸��� ����Ͻÿ�. 
--   �̶� ù ��° ���� ȸ���̸��� 'HR-Company'�̶�� ������� ��µǵ��� �Ͻÿ�   
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT 'HR-Company', E.FIRST_NAME||' '||E.LAST_NAME NAME, E.JOB_ID, D.DEPARTMENT_NAME, L.CITY
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
  AND D.LOCATION_ID = L.LOCATION_ID
  AND UPPER(L.STATE_PROVINCE) = 'OXFORD';
  
-- ��9 HR ��Ű���� �ִ� Employees, Departments ���̺��� ������ �ľ��� �� ������� �ټ� �� �̻��� 
-- �μ��� �μ��̸��� ��� ���� ����Ͻÿ�. �̶� ��� ���� ���� ������ �����Ͻÿ�
SELECT COUNT(*) FROM EMPLOYEES E, DEPARTMENTS D WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_ID;
SELECT DP.DEPARTMENT_NAME, SUB.CNT
  FROM DEPARTMENTS DP, (SELECT COUNT(*) CNT, D.DEPARTMENT_ID DID
                       FROM EMPLOYEES E, DEPARTMENTS D 
                      WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
                      GROUP BY D.DEPARTMENT_ID) SUB
 WHERE DP.DEPARTMENT_ID = SUB.DID
   AND SUB.CNT > 5 
 ORDER BY SUB.CNT DESC;
 
-- ��10 �� ����� �޿��� ���� �޿� ����� �����Ϸ��� �Ѵ�. 
-- �޿� ����� Job_Grades ���̺� ǥ�õȴ�. �ش� ���̺��� ������ ���캻 �� 
-- ����� �̸��� ��(Name���� ��Ī), ����, �μ��̸�, �Ի���, �޿�, �޿������ ����Ͻÿ�.
SELECT * FROM JOB_GRADES;
SELECT E.FIRST_NAME||' '||E.LAST_NAME �̸�, E.JOB_ID ����, D.DEPARTMENT_NAME �μ��̸�, E.HIRE_DATE �Ի���, E.SALARY �޿�
       , (CASE WHEN E.SALARY BETWEEN 1000 AND 2999 THEN 'A'
               WHEN E.SALARY BETWEEN 3000 AND 5999 THEN 'B'
               WHEN E.SALARY BETWEEN 6000 AND 9999 THEN 'C'
               WHEN E.SALARY BETWEEN 10000 AND 14999 THEN 'D'
               WHEN E.SALARY BETWEEN 15000 AND 24999 THEN 'B'
               WHEN E.SALARY BETWEEN 25000 AND 40000 THEN 'B'
         END) �޿����
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;
