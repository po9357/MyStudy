/****** HR ����Ÿ ��ȸ ����2 ****************
/*1�� HR �μ��� � ����� �޿������� ��ȸ�ϴ� ������ �ð� �ִ�. 
  Tucker ��� ���� �޿��� ���� �ް� �ִ� ����� 
  �̸��� ��(Name���� ��Ī), ����, �޿��� ����Ͻÿ�
*****************************************************/

/*2�� ����� �޿� ���� �� ������ �ּ� �޿��� �ް� �ִ� ����� 
  �̸��� ��(Name���κ�Ī), ����, �޿�, �Ի����� ����Ͻÿ�
********************************************************/

/*3�� �Ҽ� �μ��� ��� �޿����� ���� �޿��� �޴� ����� 
  �̸��� ��(Name���� ��Ī), �޿�, �μ���ȣ, ������ ����Ͻÿ�
***********************************************************/

/*4�� ��� ����� �ҼӺμ� ��տ����� ����Ͽ� ������� �̸��� ��(Name���� ��Ī),
  ����, �޿�, �μ���ȣ, �μ���տ���(Department Avg Salary�� ��Ī)�� ����Ͻÿ�
***************************************************************/

/*5�� HR ��Ű���� �ִ� Job_history ���̺��� ������� ���� ���� �̷��� ��Ÿ���� ���̺��̴�. 
  �� ������ �̿��Ͽ� ��� ����� ���� �� ������ ���� �̷� ������ ����ϰ��� �Ѵ�. 
  �ߺ��� ��������� ������ �� ���� ǥ���Ͽ� ����Ͻÿ�
  (�����ȣ, ����)
*********************************************************************/

/*6�� �� �������� �� ����� ���� �̷� ������ Ȯ���Ͽ���. ������ '��� �����
  ���� �̷� ��ü'�� ������ ���ߴ�. ���⿡���� ��� ����� 
  ���� �̷� ���� ����(JOB_HISTORY) �� �������濡 ���� �μ������� 
  �����ȣ�� ���� ������� ����Ͻÿ�(���տ����� UNION)
  (�����ȣ, �μ�����, ����)
**********************************************************************/
  
/*7�� HR �μ������� �ű� ������Ʈ�� �������� �̲� �ش� �����ڵ��� 
  �޿��� �λ� �ϱ�� �����Ͽ���. 
  ����� ���� 107���̸� 19���� ������ �ҼӵǾ� �ٹ� ���̴�. 
  �޿� �λ� ����ڴ� ȸ���� ����(Distinct job_id) �� ���� 5�� �������� 
  ���ϴ� ����� �ش�ȴ�. ������ ������ ���ؼ��� �޿��� ����ȴ�. 
  5�� ������ �޿� �λ���� ������ ����.
  HR_REP(10%), MK_REP(12%), PR_REP(15%), SA_REP(18%), IT_PROG(20%)
**********************************************************************/

/*8�� HR �μ������� �ֻ��� �Ի��Ͽ� �ش��ϴ� 2001����� 2003����� �Ի��ڵ��� �޿��� 
  ���� 5%, 3%, 1% �λ��Ͽ� ���п� ���� �������� �����ϰ��� �Ѵ�. 
  ��ü ����� �� �ش� �⵵�� �ش��ϴ� ������� �޿��� �˻��Ͽ� �����ϰ�, 
  �Ի����ڿ� ���� �������� ������ �����Ͻÿ�
**********************************************************************/

/*9�� �μ��� �޿� �հ踦 ���ϰ�, �� ����� ������ ���� ǥ���Ͻÿ�.
  Sum Salary > 100000 �̸�, "Excellent"
  Sum Salary > 50000 �̸�, "Good"
  Sum Salary > 10000 �̸�, "Medium"
  Sum Salary <= 10000 �̸�, "Well"
**********************************************************************/

/*10�� 2005�� ������ �Ի��� ��� �� ������ "MGR"�� ���Ե� ����� 15%, 
  "MAN"�� ���Ե� ����� 20% �޿��� �λ��Ѵ�. 
  ���� 2005����� �ٹ��� ������ ��� �� "MGR"�� ���Ե� ����� 25% �޿��� �λ��Ѵ�. 
  �̸� �����ϴ� ������ �ۼ��Ͻÿ�
**********************************************************************/

/*11�� ������ �Ի��� ��� �� ���
  (���1) ������ �Ի��� ��� ���� �Ʒ��� ���� �� �ະ�� ��µǵ��� �Ͻÿ�(12��).
  1�� xx
  2�� xx
  3�� xx
  ..
  12�� xx
  �հ� XXX
**********************************************************************/  
---------------------------------------------------------
/* (���2) ù �࿡ ��� ���� �Ի� ��� ���� ��µǵ��� �Ͻÿ�
  1�� 2�� 3�� 4�� .... 11�� 12��
  xx  xx  xx xx  .... xx   xx
**********************************************************************/

/*1�� HR �μ��� � ����� �޿������� ��ȸ�ϴ� ������ �ð� �ִ�. 
  Tucker ��� ���� �޿��� ���� �ް� �ִ� ����� 
  �̸��� ��(Name���� ��Ī), ����, �޿��� ����Ͻÿ�
*****************************************************/
SELECT FIRST_NAME||' '||LAST_NAME NAME, JOB_ID, SALARY FROM EMPLOYEES 
 WHERE SALARY > (SELECT SALARY FROM EMPLOYEES WHERE UPPER(LAST_NAME) IN 'TUCKER')
 ORDER BY SALARY DESC;
 
/*2�� ����� �޿� ���� �� ������ �ּ� �޿��� �ް� �ִ� ����� 
  �̸��� ��(Name���κ�Ī), ����, �޿�, �Ի����� ����Ͻÿ�
********************************************************/
SELECT FIRST_NAME||' '||LAST_NAME NAME, E.JOB_ID, SALARY, HIRE_DATE
  FROM EMPLOYEES E, (SELECT MIN(SALARY) MIN, JOB_ID FROM EMPLOYEES GROUP BY JOB_ID) SUB
 WHERE E.JOB_ID = SUB.JOB_ID
   AND SUB.MIN = SALARY
 ORDER BY JOB_ID;
 
-- ��� �������� ���
SELECT FIRST_NAME||' '||LAST_NAME NAME, E.JOB_ID, SALARY, HIRE_DATE
  FROM EMPLOYEES E
 WHERE E.SALARY = (SELECT MIN(SALARY)
                     FROM EMPLOYEES
                    WHERE E.JOB_ID = JOB_ID
                    GROUP BY JOB_ID);

/*3�� �Ҽ� �μ��� ��� �޿����� ���� �޿��� �޴� ����� 
  �̸��� ��(Name���� ��Ī), �޿�, �μ���ȣ, ������ ����Ͻÿ�
***********************************************************/
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.SALARY, E.DEPARTMENT_ID, E.JOB_ID, ROUND(SUB.AVG, 2)
  FROM EMPLOYEES E, (SELECT AVG(SALARY) AVG, DEPARTMENT_ID FROM EMPLOYEES GROUP BY DEPARTMENT_ID) SUB
 WHERE E.DEPARTMENT_ID = SUB.DEPARTMENT_ID
   AND E.SALARY > SUB.AVG
 ORDER BY SALARY;
-- ��� �������� ���
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.SALARY, E.DEPARTMENT_ID, E.JOB_ID
  FROM EMPLOYEES E
 WHERE E.SALARY > (SELECT AVG(SALARY) AVG FROM EMPLOYEES WHERE E.DEPARTMENT_ID = DEPARTMENT_ID GROUP BY DEPARTMENT_ID);

/*4�� ��� ����� �ҼӺμ� ��տ����� ����Ͽ� ������� �̸��� ��(Name���� ��Ī),
  ����, �޿�, �μ���ȣ, �μ���տ���(Department Avg Salary�� ��Ī)�� ����Ͻÿ�
***************************************************************/
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.JOB_ID, E.SALARY, E.DEPARTMENT_ID
                , ROUND(SUB.AVG, 2) "Department Avg Salary"
  FROM EMPLOYEES E, (SELECT AVG(SALARY) AVG, DEPARTMENT_ID FROM EMPLOYEES GROUP BY DEPARTMENT_ID) SUB
 WHERE E.DEPARTMENT_ID = SUB.DEPARTMENT_ID
 ORDER BY AVG DESC;

/*5�� HR ��Ű���� �ִ� Job_history ���̺��� ������� ���� ���� �̷��� ��Ÿ���� ���̺��̴�. 
  �� ������ �̿��Ͽ� ��� ����� ���� �� ������ ���� �̷� ������ ����ϰ��� �Ѵ�. 
  �ߺ��� ��������� ������ �� ���� ǥ���Ͽ� ����Ͻÿ�
  (�����ȣ, ����)
*********************************************************************/
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES
UNION ALL
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM JOB_HISTORY
 ORDER BY EMPLOYEE_ID, JOB_ID;
 
/*6�� �� �������� �� ����� ���� �̷� ������ Ȯ���Ͽ���. ������ '��� �����
  ���� �̷� ��ü'�� ������ ���ߴ�. ���⿡���� ��� ����� 
  ���� �̷� ���� ����(JOB_HISTORY) �� �������濡 ���� �μ������� 
  �����ȣ�� ���� ������� ����Ͻÿ�(���տ����� UNION)
  (�����ȣ, �μ�����, ����)
**********************************************************************/
SELECT EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
  FROM EMPLOYEES 
UNION
SELECT EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
  FROM JOB_HISTORY
ORDER BY EMPLOYEE_ID
;
/*7�� HR �μ������� �ű� ������Ʈ�� �������� �̲� �ش� �����ڵ��� 
  �޿��� �λ� �ϱ�� �����Ͽ���. 
  ����� ���� 107���̸� 19���� ������ �ҼӵǾ� �ٹ� ���̴�. 
  �޿� �λ� ����ڴ� ȸ���� ����(Distinct job_id) �� ���� 5�� �������� 
  ���ϴ� ����� �ش�ȴ�. ������ ������ ���ؼ��� �޿��� ����ȴ�. 
  5�� ������ �޿� �λ���� ������ ����.
  HR_REP(10%), MK_REP(12%), PR_REP(15%), SA_REP(18%), IT_PROG(20%)
**********************************************************************/
SELECT EMPLOYEE_ID, JOB_ID, SALARY, NVL((CASE WHEN (JOB_ID = 'HR_REP') THEN TO_CHAR(SALARY*1.10)
                                              WHEN (JOB_ID = 'MK_REP') THEN TO_CHAR(SALARY*1.12)
                                              WHEN (JOB_ID = 'PR_REP') THEN TO_CHAR(SALARY*1.15)
                                              WHEN (JOB_ID = 'SA_REP') THEN TO_CHAR(SALARY*1.18)
                                              WHEN (JOB_ID = 'IT_PROG') THEN TO_CHAR(SALARY*1.20)
                                          END), '�޿�����') AS "�λ��� �޿�"
FROM EMPLOYEES;
-- DECODE(JOB_ID, 'HR_REP', SALARY * 1.10
--              , 'MK_REP', SALARY * 1.12 ... 'IT_PROG', SALARY * 1.20, SALARY)

/*8�� HR �μ������� �ֻ��� �Ի��Ͽ� �ش��ϴ� 2001����� 2003����� �Ի��ڵ��� �޿��� 
  ���� 5%, 3%, 1% �λ��Ͽ� ���п� ���� �������� �����ϰ��� �Ѵ�. 
  ��ü ����� �� �ش� �⵵�� �ش��ϴ� ������� �޿��� �˻��Ͽ� �����ϰ�, 
  �Ի����ڿ� ���� �������� ������ �����Ͻÿ�
**********************************************************************/
SELECT E.EMPLOYEE_ID �����ȣ, E.FIRST_NAME||' '||E.LAST_NAME NAME, E.HIRE_DATE, E.SALARY
       , (CASE WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 1) THEN SALARY * 1.05
               WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 2) THEN SALARY * 1.03
               WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 3) THEN SALARY * 1.01
          END) "�λ�޿�"
  FROM EMPLOYEES E
 WHERE TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) BETWEEN 1 AND 3
 ORDER BY HIRE_DATE;

/*9�� �μ��� �޿� �հ踦 ���ϰ�, �� ����� ������ ���� ǥ���Ͻÿ�.
  Sum Salary > 100000 �̸�, "Excellent"
  Sum Salary > 50000 �̸�, "Good"
  Sum Salary > 10000 �̸�, "Medium"
  Sum Salary <= 10000 �̸�, "Well"
**********************************************************************/
SELECT DEPARTMENT_ID, SUM(SALARY) SUM_SAL
       , (CASE WHEN SUM(SALARY) > 100000 THEN 'Excellent'
               WHEN SUM(SALARY) > 50000 THEN 'Good'
               WHEN SUM(SALARY) > 10000 THEN 'Medium'
               WHEN SUM(SALARY) <= 10000 THEN 'Well' END) ���
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY SUM_SAL DESC;
--------------------------------------------
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
-- �Լ� ���� ó��
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME, DEPARTMENT_ID, GET_DEPT_NAME(DEPARTMENT_ID) FROM EMPLOYEES;
SELECT DEPARTMENT_ID DEPT_ID, GET_DEPT_NAME(DEPARTMENT_ID) DEPT_NAME
       , SUM(SALARY) SUM_SAL, GET_GRADE(DEPARTMENT_ID) GRADE 
  FROM EMPLOYEES 
 GROUP BY DEPARTMENT_ID
 ORDER BY SUM_SAL DESC;




/*10�� 2005�� ������ �Ի��� ��� �� ������ "MGR"�� ���Ե� ����� 15%, 
  "MAN"�� ���Ե� ����� 20% �޿��� �λ��Ѵ�. 
  ���� 2005����� �ٹ��� ������ ��� �� "MGR"�� ���Ե� ����� 25% �޿��� �λ��Ѵ�. 
  �̸� �����ϴ� ������ �ۼ��Ͻÿ�
**********************************************************************/
SELECT E.*, NVL((CASE WHEN JOB_ID LIKE '%MGR%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) < 5 
                                                             THEN TO_CHAR(SALARY*1.15)
                      WHEN JOB_ID LIKE '%MAN%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) < 5 
                                                             THEN TO_CHAR(SALARY*1.20)
                      WHEN JOB_ID LIKE '%MGR%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) >= 5 
                                                             THEN TO_CHAR(SALARY*1.25)END), '�޿�����') �λ�޿�
  FROM EMPLOYEES E
 WHERE E.JOB_ID LIKE '%MGR%' OR JOB_ID LIKE '%MAN%'
 ORDER BY "�λ�޿�";

SELECT CASE WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005' THEN
                 CASE WHEN JOB_ID LIKE '%MGR%' THEN SALARY * 1.15
                      WHEN JOB_ID LIKE '%MAN%' THEN SALARY * 1.2
                      ELSE SALARY
                 END
            WHEN TO_CHAR(HIRE_DATE, 'YYYY') >= '2005' THEN
                 SALARY * 1.25
       END
       AS "����� �޿�"
 FROM EMPLOYEES
 WHERE JOB_ID LIKE '%MGR%' OR JOB_ID LIKE '%MAN%'
 ORDER BY ;
/*11�� ������ �Ի��� ��� �� ���
  (���1) ������ �Ի��� ��� ���� �Ʒ��� ���� �� �ະ�� ��µǵ��� �Ͻÿ�(12��).
  1�� xx
  2�� xx
  3�� xx
  ..
  12�� xx
  �հ� XXX
**********************************************************************/  
SELECT '�հ�' �Ի��, COUNT(*) �����
  FROM EMPLOYEES
union   
SELECT TO_CHAR(HIRE_DATE, 'MM')||'��' �Ի��, COUNT(*) �����
  FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM') 
 ORDER BY "�Ի��"
;
---------------------------------------------------------
/* (���2) ù �࿡ ��� ���� �Ի� ��� ���� ��µǵ��� �Ͻÿ�
  1�� 2�� 3�� 4�� .... 11�� 12��
  xx  xx  xx xx  .... xx   xx
**********************************************************************/
SELECT COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '01', 1)) AS "01��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '02', 1)) AS "02��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '03', 1)) AS "03��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '04', 1)) AS "04��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '05', 1)) AS "05��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '06', 1)) AS "06��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '07', 1)) AS "07��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '08', 1)) AS "08��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '09', 1)) AS "09��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '10', 1)) AS "10��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '11', 1)) AS "11��"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '12', 1)) AS "12��"
       , COUNT(*) AS "����"      
  FROM EMPLOYEES;
  


