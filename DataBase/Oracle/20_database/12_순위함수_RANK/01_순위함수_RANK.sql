-- �����Լ� : RANK(), DENSE_RANK(), ROW_NUMBER()
-- PARTITION BY : �׷� ���� (GROUP BY�� ���)
-- ORDER BY : ���� ����
-----------------------------------------------------------
-- RANK() : ������ ����(���ϼ����� ���� �ݿ�)
-- ���� : RANK() OVER (PARTITION BY �÷� ORDER BY �÷�)
-- �������� : 1, 2, 2, 4, 5
-----------------------------------------------------------
-- DENSE_RANK() : ������ ����(���ϼ����� ���� ����)
-- ���� : DENSE_RANK() OVER (PARTITION BY �÷� ORDER BY �÷�)
-- �������� : 1, 2, 2, 2, 3, 4, 5
-----------------------------------------------------------
-- ROW_NUMBER() : ������ ����(���ϼ����� ���� ����)
-- ���� : ROW_NUMBER() OVER (PARTITION BY �÷� ORDER BY �÷�)
-- �������� : 1, 2, 3, 4, 5
-----------------------------------------------------------
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
       , RANK() OVER (ORDER BY SALARY DESC) RANK_SALARY
       , DENSE_RANK() OVER (ORDER BY SALARY DESC) RANK_SALARY
       , ROW_NUMBER() OVER (ORDER BY SALARY DESC) RANK_SALARY
  FROM EMPLOYEES;
  
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, SALARY
       , RANK() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
       , DENSE_RANK() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
       , ROW_NUMBER() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
  FROM EMPLOYEES;